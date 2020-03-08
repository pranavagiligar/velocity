package com.velocity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@SpringBootApplication
class VelocityApplication

fun main(args: Array<String>) {
    runApplication<VelocityApplication>(*args)
}