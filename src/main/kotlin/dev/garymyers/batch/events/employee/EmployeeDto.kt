package dev.garymyers.batch.events.employee

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

data class EmployeeDto(

    @field:NotBlank
    @field:Length(min = 3, max = 50)
    var id: String? = null,

    @field:NotBlank
    @field:Length(min = 1, max = 50)
    var firstName: String? = null,

    @field:NotBlank
    @field:Length(min = 1, max = 50)
    var lastName: String? = null,
)
