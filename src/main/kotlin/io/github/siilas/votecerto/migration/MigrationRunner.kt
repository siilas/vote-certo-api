package io.github.siilas.votecerto.migration

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.sql.DataSource
import org.flywaydb.core.Flyway


@Component
class MigrationRunner(
    private val dataSource: DataSource
) {

    @PostConstruct
    fun runMigration() {
        val flyway = Flyway.configure()
            .dataSource(dataSource)
            .locations("migrations")
            .mixed(true)
            .load()

        flyway.migrate()
    }
}
