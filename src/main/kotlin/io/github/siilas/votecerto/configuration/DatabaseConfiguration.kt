package io.github.siilas.votecerto.configuration

import com.opentable.db.postgres.embedded.EmbeddedPostgres
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration {

    @Bean
    fun dataSource(): DataSource {
        return EmbeddedPostgres.builder()
            .start()
            .postgresDatabase;
    }
}
