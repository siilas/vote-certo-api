package io.github.siilas.votecerto.domain

import io.github.siilas.votecerto.web.CareerResponse

data class Career(
    val id: Int,
    val office: String,
    val startYear: Int,
    val endYear: Int?
) {

    fun toResponse(): CareerResponse {
        return CareerResponse(
            office,
            startYear,
            endYear
        )
    }
}
