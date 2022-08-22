package io.github.siilas.votecerto.extension

fun String.toLikeParameter(): String {
    return "%${this.replace(" ", "%")}%"
}
