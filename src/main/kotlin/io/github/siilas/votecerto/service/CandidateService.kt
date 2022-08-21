package io.github.siilas.votecerto.service

import io.github.siilas.votecerto.domain.Candidate
import io.github.siilas.votecerto.domain.Information
import io.github.siilas.votecerto.exception.CandidateNotFoundException
import io.github.siilas.votecerto.repository.CandidateRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CandidateService(
    private val candidateRepository: CandidateRepository
) {

    suspend fun getInformation(): Information {
        return candidateRepository.getInformation()
    }

    suspend fun list(search: String): List<Candidate> {
        return candidateRepository.list(search) ?: emptyList()
    }

    suspend fun getById(id: String): Candidate {
        return candidateRepository.getById(id) ?: throw CandidateNotFoundException(id)
    }
}
