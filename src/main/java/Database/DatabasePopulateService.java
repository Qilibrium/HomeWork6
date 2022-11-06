package Database;

import Database.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabasePopulateService {
    public void populateDb(Database database) {
        String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL) ;

            Flyway flyway = Flyway
                    .configure()
                    .dataSource(connectionUrl, null, null).load();

            flyway.migrate();
    }
}
