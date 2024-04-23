package dev.garymyers.batch.events.employee

sealed class EmployeeEvent {
    data class EmployeeCreatedEvent(val employee: EmployeeEntity) : EmployeeEvent()
    data class EmployeeUpdatedEvent(val employee: EmployeeEntity) : EmployeeEvent()
}
