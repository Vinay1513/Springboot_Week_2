package com.SpringbootWeek2.week2.homework.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentDTO {
    @NotBlank
    String title;
    Boolean isActive = true;

}
