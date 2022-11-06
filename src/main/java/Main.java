import Client.ClientService;
import Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //CREATE name
       // new ClientService().create("new name");

        //RETURN id, name
       // new Client.ClientService().getById(7);

        //UPDATE name
       // new Client.ClientService().setName(1,"Demetrius Andrade");

        //DELETE id
       // new Client.ClientService().deleteById(7);


        new Client.ClientService().listAll();


    }
}
