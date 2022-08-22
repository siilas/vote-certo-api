package io.github.siilas.votecerto.extension

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.siilas.votecerto.domain.Report

fun ObjectMapper.readReport(reportAsString: String?): Report? {
    return this.readValue(reportAsString, Report::class.java)
}
