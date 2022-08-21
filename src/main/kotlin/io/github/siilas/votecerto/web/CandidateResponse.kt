package io.github.siilas.votecerto.web

data class CandidateResponse(
    val id: Int,
    val name: String,
    val number: Int,
    val politicalParty: String,
    val office: String,
    val description: String,
    val career: List<CareerResponse>? = emptyList(),
    val projects: List<ProjectsResponse>? = emptyList()
)
