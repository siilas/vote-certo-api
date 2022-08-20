package io.github.siilas.votecerto.configuration

import io.github.siilas.votecerto.handler.CandidateHandler
import io.github.siilas.votecerto.handler.HomePageHandler
import io.github.siilas.votecerto.handler.ReportHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouteConfiguration(
    private val reportHandler: ReportHandler,
    private val homePageHandler: HomePageHandler,
    private val candidateHandler: CandidateHandler
) {

    @Bean
    fun route() = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/api/info", homePageHandler::getInformation)
            GET("/api/candidate", candidateHandler::list)
            GET("/api/candidate/{id}", candidateHandler::getById)
            POST("/api/report", reportHandler::generateReport)
        }
    }
}
