package io.github.siilas.votecerto.handler

import io.github.siilas.votecerto.service.HomeService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class HomePageHandler(
    private val homeService: HomeService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(HomePageHandler::class.java)
    }

    suspend fun getInformation(request: ServerRequest): ServerResponse {
        return try {
            ServerResponse.ok()
                .json()
                .bodyValueAndAwait(homeService.getInformation())
        } catch (e: Exception) {
            logger.error("Error getting information", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later.")
        }
    }
}
