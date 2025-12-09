package com.SpringbootWeek2.week2.homework.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {
     Long id;
     String title;
     Boolean isActive;
     LocalDateTime createdAt;
}


