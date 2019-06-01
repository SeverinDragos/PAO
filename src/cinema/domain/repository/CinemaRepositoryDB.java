package cinema.domain.repository;

import cinema.domain.entity.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CinemaRepositoryDB implements CinemaRepository {
    List<Cinema> cinemas = new ArrayList<>();

    public CinemaRepositoryDB() {
        ResultSet resultSet = null;
        try(
                //Pasul 1: conectarea la BD
                Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "" );
                //Pasul 2: crearea unui obiect de tip Statement
                Statement statement = conn.createStatement();
        )
        {
        }
        catch (SQLException e) {
            System.out.println("Eroare la citirea din baza de date!" + e);
        }
        finally{
            try{
                if (resultSet != null) {
                    resultSet.close();
                }
            }
            catch (SQLException e) {
                System.out.println("Eroare la inchiderea result set!" + e);
            }
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Cinema getCinemaByMall(String mall) {
        Iterator<Cinema> it = cinemas.iterator();
        while(it.hasNext()) {
            Cinema cinema = it.next();
            if (cinema.getAdress().getMall().toLowerCase().equals(mall.toLowerCase()))
                return cinema;
        }
        return null;
    }
}
