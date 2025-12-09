package com.SpringbootWeek2.week2.homework.entities;

import com.SpringbootWeek2.week2.homework.annotations.IsPrime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// Must be null on create
    @NotNull
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 50, message = "Title must be 2-50 characters")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Title must contain only letters and spaces")
    private String title;

    @NotNull(message = "isActive is required")
    @AssertTrue(message = "Department must be active")  // Business rule
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull
    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime createdAt;

    @Email(message = "Invalid email format")
    @Size(max = 100)
    private String contactEmail;  // Added field

    @Min(value = 1, message = "Department code must be positive")
    @Max(value = 9999)
    @IsPrime(message = "Employee code must be prime")
    private Integer departmentCode;  // Added field

    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "1000000.0")
    @Digits(integer = 7, fraction = 2)
    private BigDecimal budget;  // Added field

    @URL(message = "Invalid website URL")
    private String website;  // Added field

    @CreditCardNumber  // For demo purposes
    private String fundingAccount;  // Added field
}
