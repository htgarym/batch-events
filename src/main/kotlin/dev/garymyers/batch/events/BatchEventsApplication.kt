package dev.garymyers.batch.events

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class BatchEventsApplication

fun main(args: Array<String>) {
	runApplication<BatchEventsApplication>(*args)
}
