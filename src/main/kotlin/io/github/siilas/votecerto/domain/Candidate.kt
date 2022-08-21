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

    fun toResponse(): CandidateResponse {
        return CandidateResponse(
            id,
            name,
            number,
            politicalParty,
            office,
            description
        )
    }
}
