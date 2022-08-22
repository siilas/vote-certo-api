package io.github.siilas.votecerto.web

data class ReportResponse(
    val governador: CandidateResponse? = null,
    val deputadoFederal: CandidateResponse? = null,
    val deputadoEstadual: CandidateResponse? = null
)
