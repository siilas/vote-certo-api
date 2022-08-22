package io.github.siilas.votecerto.handler

import io.github.siilas.votecerto.exception.CandidateNotFoundException
import io.github.siilas.votecerto.extension.createCookie
import io.github.siilas.votecerto.extension.getCookie
import io.github.siilas.votecerto.service.ReportService
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
class ReportHandler(
    private val reportService: ReportService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(ReportHandler::class.java)
    }

    suspend fun getReport(request: ServerRequest): ServerResponse {
        return try {
            val report = request.getCookie() ?: throw IllegalArgumentException("You need to add candidates before generating the report")

            ServerResponse.ok()
                .json()
                .bodyValueAndAwait(reportService.getReport(report))
        } catch (e: Exception) {
            logger.error("Error getting report", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later")
        }
    }

    suspend fun addCandidate(request: ServerRequest): ServerResponse {
        return try {
            val id = request.queryParamOrNull("id")?.toInt() ?: throw IllegalArgumentException("Parameter required: id")
            val report = request.getCookie()

            ServerResponse.ok()
                .createCookie(reportService.addCandidate(id, report))
                .buildAndAwait()
        } catch (e: IllegalArgumentException) {
            ServerResponse.badRequest()
                .json()
                .bodyValueAndAwait(e.message ?: "Validation error")
        } catch (e: CandidateNotFoundException) {
            ServerResponse.notFound()
                .buildAndAwait()
        } catch (e: Exception) {
            logger.error("Error adding candidate", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later")
        }
    }

    suspend fun removeCandidate(request: ServerRequest): ServerResponse {
        return try {
            val id = request.pathVariable("id").toInt()
            val report = request.getCookie() ?: throw IllegalArgumentException("You need to add candidates before removing candidates")

            ServerResponse.ok()
                .createCookie(reportService.removeCandidate(id, report))
                .buildAndAwait()
        } catch (e: IllegalArgumentException) {
            ServerResponse.badRequest()
                .json()
                .bodyValueAndAwait(e.message ?: "Validation error")
        } catch (e: CandidateNotFoundException) {
            ServerResponse.notFound()
                .buildAndAwait()
        } catch (e: Exception) {
            logger.error("Error removing candidate", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later")
        }
    }
}
