package cinema.domain.repository;

import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShowRepositoryFile implements ShowRepository{
    private Show[] shows = new Show[100];

    public ShowRepositoryFile(String movieFileName, String playFileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(movieFileName);
        Scanner scanner = new Scanner(fileInputStream);
        int counter = 0;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            shows[counter++] = new Movie(values[0], values[1], Integer.parseInt(values[2]), values[3],Integer.parseInt(values[4]));
        }

        FileInputStream fileInputStream2 = new FileInputStream(playFileName);
        Scanner scanner2 = new Scanner(fileInputStream2);
        while (scanner2.hasNext()) {
            String line = scanner2.nextLine();
            String[] values = line.split(",");
            shows[counter++] = new Play(values[0], values[1], Integer.parseInt(values[2]), values[3], Integer.parseInt(values[4]));
        }
    }

    public Show[] getShows() {
        return shows;
    }

    public Show getShowById(int id) {
        for (int i = 0; i < shows.length; i++)
            if (shows[i].getId() == id)
                return shows[i];
        return null;
    }
}
