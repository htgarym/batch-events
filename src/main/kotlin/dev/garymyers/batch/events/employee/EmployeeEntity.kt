package dev.garymyers.batch.events.employee

data class EmployeeEntity(
    val id: String,
    val firstName: String,
    val lastName: String,
) {
    constructor(dto: EmployeeDto) : this(
        id = dto.id!!,
        firstName = dto.firstName!!,
        lastName = dto.lastName!!,
    )
}
