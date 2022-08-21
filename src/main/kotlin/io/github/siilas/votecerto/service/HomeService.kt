package io.github.siilas.votecerto.service

import io.github.siilas.votecerto.repository.CandidateRepository
import io.github.siilas.votecerto.web.InformationResponse
import org.springframework.stereotype.Service

@Service
class HomeService(
    private val candidateRepository: CandidateRepository
) {

    suspend fun getInformation(): InformationResponse {
        return candidateRepository.getInformation().toResponse()
    }
}
