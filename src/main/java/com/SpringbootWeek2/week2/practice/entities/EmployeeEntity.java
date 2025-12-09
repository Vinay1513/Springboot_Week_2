package com.SpringbootWeek2.week2.practice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
@Getter
@Setter

@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100)
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age cannot exceed 65")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotNull
    @Past(message = "Date of joining cannot be in future")
    private LocalDate dateOfJoining;

    @NotNull
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotEmpty(message = "Role is required")
    @Size(min = 2, max = 30)
    private String role;

    @NotNull
    @DecimalMin(value = "30000.0")
    @DecimalMax(value = "500000.0")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 6, fraction = 2)
    private Double salary;

    // Added validation fields
    @Length(max = 15)
    private String phoneNumber;

    @FutureOrPresent(message = "Contract expiry cannot be in past")
    private LocalDate contractExpiry;

    @Range(min = 1000, max = 999999)
    private Integer employeeCode;

    @NegativeOrZero(message = "Deduction cannot be positive")
    private Double monthlyDeduction;
}
