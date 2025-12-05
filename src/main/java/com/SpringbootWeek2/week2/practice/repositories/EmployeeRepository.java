package com.SpringbootWeek2.week2.practice.repositories;

import com.SpringbootWeek2.week2.practice.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
