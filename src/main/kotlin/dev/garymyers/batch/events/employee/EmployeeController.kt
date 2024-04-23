package dev.garymyers.batch.events.employee

import dev.garymyers.batch.events.employee.EmployeeEvent.EmployeeCreatedEvent
import dev.garymyers.batch.events.employee.EmployeeEvent.EmployeeUpdatedEvent
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employee")
class EmployeeController (
    private val eventPublisher: ApplicationEventPublisher
) {
    private val logger: Logger = LoggerFactory.getLogger(EmployeeController::class.java)

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun createEmployee(@RequestBody @Valid employeeDto: EmployeeDto): EmployeeDto {
        logger.debug("Creating employee: {}", employeeDto)

        val employeeEntity = EmployeeEntity(employeeDto)

        eventPublisher.publishEvent(EmployeeCreatedEvent(employeeEntity))

        logger.debug("Employee creation requested {}", employeeDto)
        return employeeDto
    }

    @PutMapping(consumes = ["application/json"], produces = ["application/json"])
    fun updateEmployee(@RequestBody @Valid employeeDto: EmployeeDto): EmployeeDto {
        logger.debug("Updating employee: {}", employeeDto)

        val employeeEntity = EmployeeEntity(employeeDto)

        eventPublisher.publishEvent(EmployeeUpdatedEvent(employeeEntity))

        logger.debug("Employee update requested {}", employeeDto)
        return employeeDto
    }
}