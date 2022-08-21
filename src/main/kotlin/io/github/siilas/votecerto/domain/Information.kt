package io.github.siilas.votecerto.domain

import io.github.siilas.votecerto.web.InformationResponse

data class Information(
    val deputadoEstadualQuantity: Int,
    val deputadoFederalQuantity: Int,
    val governadorQuantity: Int
) {

    fun toResponse(): InformationResponse {
        return InformationResponse(
            deputadoEstadualQuantity,
            deputadoFederalQuantity,
            governadorQuantity,
            deputadoEstadualQuantity + deputadoFederalQuantity + governadorQuantity
        )
    }
}
