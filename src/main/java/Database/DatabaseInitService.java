package Database;

import Database.prefs.Prefs;
import org.flywaydb.core.Flyway;


public class DatabaseInitService {
    String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL) ;
    public void initDb(Database database)  {
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null).load();

        flyway.migrate();
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseInitService().initDb(database);
    }
}
