package io.github.siilas.votecerto.domain

import io.github.siilas.votecerto.web.ProjectsResponse

data class Projects(
    val id: Int,
    val title: String,
    val description: String
) {

    fun toResponse(): ProjectsResponse {
        return ProjectsResponse(
            title,
            description
        )
    }
}
