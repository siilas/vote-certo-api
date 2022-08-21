package io.github.siilas.votecerto.repository

import io.github.siilas.votecerto.domain.Career
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface CareerRepository : R2dbcRepository<Career, Int> {

    @Query(GET_BY_ID)
    suspend fun getByCandidateId(candidateId: Int): List<Career>?
}

private const val GET_BY_ID = """
    select * from career c where c.candidate_id = :candidateId
"""
