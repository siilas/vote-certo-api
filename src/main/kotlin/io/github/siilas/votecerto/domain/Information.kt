package io.github.siilas.votecerto.domain

data class Information(
    val deputadoEstadualQuantity: Int,
    val deputadoFederalQuantity: Int,
    val governadoresQuantity: Int
) {

    fun candidatesQuantity(): Int {
        return deputadoEstadualQuantity + deputadoFederalQuantity + governadoresQuantity
    }
}
