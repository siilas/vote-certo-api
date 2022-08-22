package io.github.siilas.votecerto.extension

import org.springframework.http.ResponseCookie
import org.springframework.web.reactive.function.server.ServerRequest

private const val COOKIE_NAME = "cola_voto_certo"

fun getCookie(request: ServerRequest): String? {
    return request.cookies().getFirst(COOKIE_NAME)?.value
}

fun createCookie(value: String): ResponseCookie {
    return ResponseCookie.from(COOKIE_NAME, value).build()
}
