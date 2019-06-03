package cinema.domain.repository;

import cinema.domain.entity.MovieTheater;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MovieTheaterRepositoryDB implements MovieTheaterRepository {
    private List<MovieTheater> movieTheaters = new LinkedList<>();

    public MovieTheaterRepositoryDB() {
        ResultSet resultSetFreeSeats = null;
        ResultSet resultSetMovies = null;
        ResultSet resultSetPlays = null;
        ResultSet resultSetMovieTheaters = null;
        PreparedStatement preparedStatement = null;
        try(
                Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
                Statement statement = conn.createStatement();
        )
        {
            resultSetMovieTheaters = statement.executeQuery("SELECT capacity, id FROM movietheaters");
            while (resultSetMovieTheaters.next()) {
                preparedStatement = conn.prepareStatement("SELECT * FROM freeseats WHERE movietheater_id = ? ORDER BY index;");
                preparedStatement.setInt(1, resultSetMovieTheaters.getInt("id"));
                resultSetFreeSeats = preparedStatement.executeQuery();
                int[] temp = new int[3];
                int counter = 0;
                while (resultSetFreeSeats.next()) {
                    temp[counter++] = resultSetFreeSeats.getInt("free_seats");
                }

                preparedStatement = conn.prepareStatement("SELECT id FROM movies WHERE movietheater_id = ?");
                preparedStatement.setInt(1, resultSetMovieTheaters.getInt("id"));
                resultSetMovies = preparedStatement.executeQuery();
                int[] showsTemp = new int[3];
                int showsCounter = 0;
                while (resultSetMovies.next()) {
                    showsTemp[showsCounter++] = resultSetMovies.getInt("id");
                }

                preparedStatement = conn.prepareStatement("SELECT id FROM plays WHERE movietheater_id = ?");
                preparedStatement.setInt(1, resultSetMovieTheaters.getInt("id"));
                resultSetPlays = preparedStatement.executeQuery();
                while(resultSetPlays.next()) {
                    showsTemp[showsCounter++] = resultSetPlays.getInt("id");
                }

                movieTheaters.add(new MovieTheater(resultSetMovieTheaters.getInt("capacity"),
                                                    temp, showsTemp, resultSetMovieTheaters.getInt("id")));
            }
        }
        catch (SQLException e) {
            System.out.println("Eroare la citirea din baza de date!" + e);
        }
        finally {
            try {
                if (resultSetFreeSeats != null) {
                    resultSetFreeSeats.close();
                }
                if (resultSetMovieTheaters != null) {
                    resultSetMovieTheaters.close();
                }
                if (resultSetMovies != null) {
                    resultSetMovies.close();
                }
                if (resultSetPlays != null) {
                    resultSetPlays.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            catch (SQLException e) {
                System.out.println("Eroare la citirea din baza de date!" + e);
            }
        }
    }

    public List<MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

    public MovieTheater getMovieTheaterById(int id) {
        Iterator<MovieTheater> it = movieTheaters.iterator();
        while (it.hasNext()) {
            MovieTheater movieTheater = it.next();
            if (movieTheater.getId() == id)
                return movieTheater;
        }
        return null;
    }
}
