package io.github.siilas.votecerto.service

import io.github.siilas.votecerto.domain.Candidate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CandidateService {

    suspend fun list(search: String): List<Candidate> {
        return emptyList()
    }

    suspend fun getById(id: String): Candidate {
        return Candidate(UUID.randomUUID(), "", "", 0, 0, emptyList())
    }
}
