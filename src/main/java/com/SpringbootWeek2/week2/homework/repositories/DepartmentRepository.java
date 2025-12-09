package com.SpringbootWeek2.week2.homework.repositories;

import com.SpringbootWeek2.week2.homework.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
