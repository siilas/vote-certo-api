package io.github.siilas.votecerto.domain

import java.util.UUID

data class Proposal(
    val id: UUID,
    val title: String,
    val description: String
)
