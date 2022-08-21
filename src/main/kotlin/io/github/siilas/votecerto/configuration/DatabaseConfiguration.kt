package io.github.siilas.votecerto.configuration

import com.opentable.db.postgres.embedded.EmbeddedPostgres
import io.github.siilas.votecerto.extension.getR2dbcUrl
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import javax.sql.DataSource

@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration {

    companion object {
        private const val DB_NAME = "vote_certo_db"
    }

    @Bean
    fun postgres(): EmbeddedPostgres {
        return EmbeddedPostgres.builder()
            .setDatabaseName(DB_NAME)
            .start()
    }

    @Bean
    fun connectionFactory(postgres: EmbeddedPostgres): ConnectionFactory {
        return ConnectionFactoryBuilder.withUrl(postgres.getR2dbcUrl(DB_NAME))
            .username(postgres.userName)
            .build()
    }

    @Bean
    fun dataSource(postgres: EmbeddedPostgres): DataSource {
        return postgres.postgresDatabase
    }
}
