package io.github.siilas.votecerto.extension

fun toLikeParameter(parameter: String): String {
    return "%${parameter.replace(" ", "%")}%"
}
