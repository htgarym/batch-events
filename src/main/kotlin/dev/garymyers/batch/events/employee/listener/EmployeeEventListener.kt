package dev.garymyers.batch.events.employee.listener

import dev.garymyers.batch.events.employee.EmployeeEvent.EmployeeCreatedEvent
import dev.garymyers.batch.events.employee.EmployeeEvent.EmployeeUpdatedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class EmployeeEventListener {
    private val logger: Logger = LoggerFactory.getLogger(EmployeeEventListener::class.java)

    @Async
    @EventListener
    fun nigelStoreEmployeeCreated(employeeCreatedEvent: EmployeeCreatedEvent) {
        logger.info("Creating Employee: ${employeeCreatedEvent.employee}")
        TimeUnit.SECONDS.sleep(10)
        logger.info("Employee created: ${employeeCreatedEvent.employee}")
    }

    @Async
    @EventListener
    fun nigelStoreEmployeeUpdated(employeeUpdatedEvent: EmployeeUpdatedEvent) {
        logger.info("Updating Employee: ${employeeUpdatedEvent.employee}")
        TimeUnit.SECONDS.sleep(10)
        logger.info("Employee updated: ${employeeUpdatedEvent.employee}")
    }
}