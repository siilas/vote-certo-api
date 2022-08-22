package io.github.siilas.votecerto.extension

import com.opentable.db.postgres.embedded.EmbeddedPostgres

fun EmbeddedPostgres.getR2dbcUrl(dbName: String): String {
    return this.getJdbcUrl(dbName).replace("jdbc:", "r2dbc:")
}
