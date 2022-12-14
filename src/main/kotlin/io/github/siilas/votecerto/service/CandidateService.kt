package io.github.siilas.votecerto.service

import io.github.siilas.votecerto.exception.CandidateNotFoundException
import io.github.siilas.votecerto.extension.toLikeParameter
import io.github.siilas.votecerto.repository.CandidateRepository
import io.github.siilas.votecerto.repository.CareerRepository
import io.github.siilas.votecerto.repository.ProjectsRepository
import io.github.siilas.votecerto.web.CandidateResponse
import org.springframework.stereotype.Service

@Service
class CandidateService(
    private val careerRepository: CareerRepository,
    private val projectsRepository: ProjectsRepository,
    private val candidateRepository: CandidateRepository
) {

    suspend fun list(search: String): List<CandidateResponse> {
        return candidateRepository.list(search.toLikeParameter())?.map { it.toResponse() } ?: emptyList()
    }

    suspend fun getById(id: Int): CandidateResponse {
        val candidate = candidateRepository.getById(id) ?: throw CandidateNotFoundException(id)

        val career = careerRepository.getByCandidateId(id)
        val projects = projectsRepository.getByCandidateId(id)

        return candidate.toResponse(career, projects)
    }
}
