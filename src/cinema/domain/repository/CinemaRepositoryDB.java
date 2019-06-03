package cinema.domain.repository;

import cinema.domain.entity.Adress;
import cinema.domain.entity.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CinemaRepositoryDB implements CinemaRepository {
    List<Cinema> cinemas = new ArrayList<>();

    public CinemaRepositoryDB() {
        ResultSet resultSet = null;
        ResultSet resultSetForCinemas = null;
        PreparedStatement preparedStatement = null;
        try(
                Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
                Statement statement = conn.createStatement();
        )
        {
            resultSetForCinemas = statement.executeQuery("SELECT * FROM cinemas");
            while(resultSetForCinemas.next()) {
                int[] temp = new int[3];
                int counter = 0;
                preparedStatement = conn.prepareStatement("SELECT id FROM movietheaters WHERE cinema_id = ?");
                preparedStatement.setInt(1, resultSetForCinemas.getInt("id"));
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    temp[counter++] = resultSet.getInt("id");
                }
                cinemas.add(new Cinema(temp,
                                    new Adress(resultSetForCinemas.getString("city"), resultSetForCinemas.getString("mall")),
                                    resultSetForCinemas.getInt("id")));
            }
        }
        catch (SQLException e) {
            System.out.println("Eroare la citirea din baza de date!" + e);
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (resultSetForCinemas != null) {
                    resultSetForCinemas.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

            }
            catch (SQLException e) {
                System.out.println("Eroare la inchiderea bazei de date!" + e);
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
