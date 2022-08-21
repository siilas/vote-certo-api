package io.github.siilas.votecerto.repository

import io.github.siilas.votecerto.domain.Candidate
import io.github.siilas.votecerto.domain.Information
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepository : R2dbcRepository<Candidate, String> {

    @Query(GET_INFORMATION)
    suspend fun getInformation(): Information

    @Query(LIST)
    suspend fun list(search: String): List<Candidate>?

    @Query(GET_BY_ID)
    suspend fun getById(id: String): Candidate?
}

private const val GET_INFORMATION = """
    SELECT * FROM CANDIDATES
"""

private const val LIST = """
    SELECT * FROM CANDIDATES C WHERE C.NAME ILIKE :search
"""

private const val GET_BY_ID = """
    SELECT * FROM CANDIDATES C WHERE C.ID = :id
"""
