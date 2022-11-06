package Database;

import Database.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL) ;
            connection = DriverManager.getConnection(connectionUrl);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public void executeUpdate(String sql){
        try (Statement st = connection.createStatement()){
            st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("Table already exists");
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
