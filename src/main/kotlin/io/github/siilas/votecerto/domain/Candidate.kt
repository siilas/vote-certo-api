package io.github.siilas.votecerto.domain

import java.util.UUID

data class Candidate(
    val id: UUID,
    val name: String,
    val party: String,
    val number: Int,
    val age: Int,
    val proposals: List<Proposal>
)
