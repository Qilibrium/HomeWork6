import Client.ClientService;
import Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        //CREATE DATABASE
       // new Database.DatabaseInitService().initDb(database);



        //CREATE name
        new ClientService().create("name");

        //RETURN id, name
      //  new Client.ClientService().getById(7);

        //UPDATE name
      //  new Client.ClientService().setName(1,"Demetrius Andrade");

        //DELETE id
       // new Client.ClientService().deleteById(1);


       // new Client.ClientService().listAll();


    }
}
