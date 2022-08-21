package io.github.siilas.votecerto.repository

import io.github.siilas.votecerto.domain.Projects
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectsRepository : R2dbcRepository<Projects, Int> {

    @Query(GET_BY_ID)
    suspend fun getByCandidateId(candidateId: Int): List<Projects>?
}

private const val GET_BY_ID = """
    select * from projects p where p.candidate_id = :candidateId
"""
