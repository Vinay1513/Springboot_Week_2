package com.SpringbootWeek2.week2.homework.controllers;

import com.SpringbootWeek2.week2.homework.dto.CreateDepartmentDTO;
import com.SpringbootWeek2.week2.homework.dto.DepartmentDTO;
import com.SpringbootWeek2.week2.homework.services.DepartmentService;
import com.SpringbootWeek2.week2.practice.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, ModelMapper modelMapper) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(name = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getAllDepartmentsById(@PathVariable (name = "departmentId") Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getAllDepartmentsById(id);
        return departmentDTO.
                map(
                 departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: "+id));
    }


    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid  CreateDepartmentDTO createDepartmentDTO) {

        DepartmentDTO savedDepartmentDTO = departmentService.createDepartment(createDepartmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }


@PutMapping(name = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId) {

        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO,departmentId));

}

@DeleteMapping(name = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
    boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
    if (gotDeleted) return ResponseEntity.ok(true);
    return ResponseEntity.notFound().build();
}



}
