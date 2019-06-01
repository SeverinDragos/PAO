package cinema.domain.repository;

import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ShowRepositoryDB implements ShowRepository{
    private Set<Show> shows = new TreeSet<>();

    public ShowRepositoryDB() {
        ResultSet resultSet = null;
        try(
                //Pasul 1: conectarea la BD
                Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "" );
                //Pasul 2: crearea unui obiect de tip Statement
                Statement statement = conn.createStatement();
        )
        {
            String Query = "SELECT * FROM movies";
            resultSet = statement.executeQuery(Query);

            while(resultSet.next()) {
                shows.add(new Movie(resultSet.getString("genre"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("duration"),
                                    resultSet.getString("type"),
                                    resultSet.getInt("id")));
            }

            Query = "SELECT * FROM plays";
            resultSet = statement.executeQuery(Query);

            while(resultSet.next()) {
                shows.add(new Play(resultSet.getString("genre"),
                        resultSet.getString("name"),
                        resultSet.getInt("duration"),
                        resultSet.getString("leading_actor"),
                        resultSet.getInt("id")));
            }
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

    public Set<Show> getShows() {
        return shows;
    }

    public Show getShowById(int id) {
        Iterator<Show> it = shows.iterator();
        while(it.hasNext()) {
            Show temp = it.next();
            if (temp.getId() == id)
                return temp;
        }
        return null;
    }
}
