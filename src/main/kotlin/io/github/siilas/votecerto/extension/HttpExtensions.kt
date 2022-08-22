package io.github.siilas.votecerto.extension

import org.springframework.http.ResponseCookie
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.BodyBuilder

private const val COOKIE_NAME = "cola_voto_certo"

fun ServerRequest.getCookie(): String? {
    return this.cookies().getFirst(COOKIE_NAME)?.value
}

fun BodyBuilder.createCookie(value: String): BodyBuilder {
    this.cookie(ResponseCookie.from(COOKIE_NAME, value).build())
    return this
}
