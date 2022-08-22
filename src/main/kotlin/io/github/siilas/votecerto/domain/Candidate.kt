package io.github.siilas.votecerto.domain

import io.github.siilas.votecerto.web.CandidateResponse

data class Candidate(
    val id: Int,
    val name: String,
    val number: Int,
    val politicalParty: String,
    val office: String,
    val description: String
) {

    companion object {
        const val GOVERNADOR = "Governador"
        const val DEPUTADO_FEDERAL = "Deputado Federal"
        const val DEPUTADO_ESTADUAL = "Deputado Estadual"
    }

    fun isGovernador(): Boolean {
        return office == GOVERNADOR
    }

    fun isDeputadoFederal(): Boolean {
        return office == DEPUTADO_FEDERAL
    }

    fun isDeputadoEstadual(): Boolean {
        return office == DEPUTADO_ESTADUAL
    }

    fun toResponse(career: List<Career>? = null, projects: List<Projects>? = null): CandidateResponse {
        return CandidateResponse(
            id,
            name,
            number,
            politicalParty,
            office,
            description,
            career?.map { it.toResponse() },
            projects?.map { it.toResponse() }
        )
    }
}
