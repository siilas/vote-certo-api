package io.github.siilas.votecerto.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.siilas.votecerto.domain.Report
import io.github.siilas.votecerto.exception.CandidateNotFoundException
import io.github.siilas.votecerto.extension.readReport
import io.github.siilas.votecerto.repository.CandidateRepository
import io.github.siilas.votecerto.web.ReportResponse
import org.springframework.stereotype.Service

@Service
class ReportService(
    private val candidateRepository: CandidateRepository
) {

    companion object {
        private val mapper = ObjectMapper()
    }

    suspend fun getReport(reportAsString: String): ReportResponse {
        return mapper.readReport(reportAsString)?.let { report ->
            ReportResponse(
                report.governador?.let { candidateRepository.getById(it)?.toResponse() },
                report.deputadoEstadual?.let { candidateRepository.getById(it)?.toResponse() },
                report.deputadoFederal?.let { candidateRepository.getById(it)?.toResponse() }
            )
        } ?: ReportResponse()
    }

    suspend fun addCandidate(id: Int, reportAsString: String?): String {
        return candidateRepository.getById(id)?.let { candidate ->
            val report = reportAsString?.let { mapper.readReport(reportAsString) } ?: Report()
            when {
                candidate.isGovernador() -> report.governador = id
                candidate.isDeputadoEstadual() -> report.deputadoEstadual = id
                candidate.isDeputadoFederal() -> report.deputadoFederal = id
            }
            mapper.writeValueAsString(report)
        } ?: throw CandidateNotFoundException(id)
    }

    suspend fun removeCandidate(id: Int, reportAsString: String?): String {
        return candidateRepository.getById(id)?.let { candidate ->
            val report = reportAsString?.let { mapper.readReport(reportAsString) } ?: Report()
            when {
                candidate.isGovernador() -> report.governador = null
                candidate.isDeputadoEstadual() -> report.deputadoEstadual = null
                candidate.isDeputadoFederal() -> report.deputadoFederal = null
            }
            mapper.writeValueAsString(report)
        } ?: throw CandidateNotFoundException(id)
    }
}
