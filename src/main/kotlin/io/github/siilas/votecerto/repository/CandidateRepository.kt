package io.github.siilas.votecerto.repository

import io.github.siilas.votecerto.domain.Candidate
import io.github.siilas.votecerto.domain.Candidate.Companion.GOVERNADOR
import io.github.siilas.votecerto.domain.Candidate.Companion.DEPUTADO_FEDERAL
import io.github.siilas.votecerto.domain.Candidate.Companion.DEPUTADO_ESTADUAL
import io.github.siilas.votecerto.domain.Information
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepository : R2dbcRepository<Candidate, Int> {

    @Query(GET_INFORMATION)
    suspend fun getInformation(): Information

    @Query(LIST)
    suspend fun list(search: String): List<Candidate>?

    @Query(GET_BY_ID)
    suspend fun getById(id: Int): Candidate?
}

private const val GET_INFORMATION = """
    select 
        count(c.id) filter (where c.office = '$GOVERNADOR') as governador_quantity,
        count(c.id) filter (where c.office = '$DEPUTADO_FEDERAL') as deputado_federal_quantity,
        count(c.id) filter (where c.office = '$DEPUTADO_ESTADUAL') as deputado_estadual_quantity
    from candidates c
"""

private const val LIST = """
    select distinct c.* 
    from candidates c 
    join projects p on c.id = p.candidate_id
    where (c.name || ' ' || c.office || ' ' || p.title) ILIKE :search
"""

private const val GET_BY_ID = """
    select * from candidates c where c.id = :id
"""
