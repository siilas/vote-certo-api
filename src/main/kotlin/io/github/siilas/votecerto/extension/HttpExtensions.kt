package io.github.siilas.votecerto.extension

import org.springframework.http.ResponseCookie
import org.springframework.util.Base64Utils
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.BodyBuilder

private const val COOKIE_NAME = "cola_voto_certo"

fun ServerRequest.getCookie(): String? {
    return this.cookies().getFirst(COOKIE_NAME)?.value?.let { String(Base64Utils.decodeFromString(it)) }
}

fun BodyBuilder.createCookie(value: String): BodyBuilder {
    this.cookie(ResponseCookie.from(COOKIE_NAME, Base64Utils.encodeToString(value.toByteArray())).build())
    return this
}
