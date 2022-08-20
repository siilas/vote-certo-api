package io.github.siilas.votecerto.handler

import io.github.siilas.votecerto.service.ReportService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class ReportHandler(
    private val reportService: ReportService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(ReportHandler::class.java)
    }

    suspend fun generateReport(request: ServerRequest): ServerResponse {
        return try {
            ServerResponse.ok()
                .json()
                .bodyValueAndAwait(reportService.generateReport())
        } catch (e: Exception) {
            logger.error("Error generating report", e)

            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValueAndAwait("Error, please try again later.")
        }
    }
}
