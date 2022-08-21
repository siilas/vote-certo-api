package io.github.siilas.votecerto.handler

import io.github.siilas.votecerto.exception.CandidateNotFoundException
import io.github.siilas.votecerto.service.CandidateService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json
import org.springframework.web.reactive.function.server.queryParamOrNull

@Component
class CandidateHandler(
    private val candidateService: CandidateService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CandidateHandler::class.java)
    }

    suspend fun list(request: ServerRequest): ServerResponse {
        return try {
            val search = request.queryParamOrNull("search") ?: throw IllegalArgumentException("Search parameter is required")

            ServerResponse.ok()
                .json()
                .bodyValueAndAwait(candidateService.list(search))
        } catch (e: IllegalArgumentException) {
            ServerResponse.badRequest()
                .json()
                .bodyValueAndAwait(e.message ?: "Validation error")
        } catch (e: Exception) {
            logger.error("Error listing candidate", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later")
        }
    }

    suspend fun getById(request: ServerRequest): ServerResponse {
        return try {
            val id = request.pathVariable("id").toInt()

            ServerResponse.ok()
                .json()
                .bodyValueAndAwait(candidateService.getById(id))
        } catch (e: IllegalArgumentException) {
            ServerResponse.badRequest()
                .json()
                .bodyValueAndAwait(e.message ?: "Validation error")
        } catch (e: CandidateNotFoundException) {
            ServerResponse.notFound()
                .buildAndAwait()
        } catch (e: Exception) {
            logger.error("Error getting candidate", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .json()
                .bodyValueAndAwait("Error, please try again later")
        }
    }
}
