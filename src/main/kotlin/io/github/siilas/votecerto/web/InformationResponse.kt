package io.github.siilas.votecerto.web

data class InformationResponse(
    val deputadoEstadualQuantity: Int,
    val deputadoFederalQuantity: Int,
    val governadorQuantity: Int,
    val candidatesQuantity: Int
)
