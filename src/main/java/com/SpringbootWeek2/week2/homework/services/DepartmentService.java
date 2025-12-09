package com.SpringbootWeek2.week2.homework.services;

import com.SpringbootWeek2.week2.homework.dto.CreateDepartmentDTO;
import com.SpringbootWeek2.week2.homework.dto.DepartmentDTO;
import com.SpringbootWeek2.week2.homework.entities.DepartmentEntity;
import com.SpringbootWeek2.week2.homework.repositories.DepartmentRepository;
import com.SpringbootWeek2.week2.practice.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DepartmentService {
  private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


     public List<DepartmentDTO> getAllDepartments() {

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.
                stream().map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class)).collect(Collectors.toList());
    }


    public Optional<DepartmentDTO> getAllDepartmentsById(Long id) {

        return departmentRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, DepartmentDTO.class));
    }


    public DepartmentDTO createDepartment(CreateDepartmentDTO createDepartmentDTO) {

        DepartmentEntity toSaveDepartmentEntity = modelMapper.map(createDepartmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveDepartmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);

    }

    public  DepartmentDTO updateDepartmentById(@Valid DepartmentDTO departmentDTO, Long departmentId) {

        isExistBydepartmentId(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    private void isExistBydepartmentId(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+departmentId);
    }


    public  boolean deleteDepartmentById(Long departmentId) {
        isExistBydepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;

    }
}
