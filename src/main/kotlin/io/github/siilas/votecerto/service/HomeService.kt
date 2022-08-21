package io.github.siilas.votecerto.service

import io.github.siilas.votecerto.domain.Information
import org.springframework.stereotype.Service

@Service
class HomeService(
    private val candidateService: CandidateService
) {

    suspend fun getInformation(): Information {
        return candidateService.getInformation()
    }
}
