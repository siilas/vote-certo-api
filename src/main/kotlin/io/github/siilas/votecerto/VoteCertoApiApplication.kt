package io.github.siilas.votecerto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VoteCertoApiApplication

fun main(args: Array<String>) {
	runApplication<VoteCertoApiApplication>(*args)
}
