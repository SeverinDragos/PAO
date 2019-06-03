package cinema.controller;

import cinema.services.CinemaService;
import cinema.services.ShowService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    private CinemaService cinemaService = new CinemaService();
    private ShowService showService = new ShowService();

    @FXML
    private TextField ArgumentsTextBox;

    @FXML
    private Button RunButton;

    @FXML
    private ComboBox<String> Dropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dropdown.getItems().addAll("List All Cinemas", "List Available Shows", "List Available Movies", "List Available Plays", "Search For Movie", "Search For Play",
                                    "List Movies With Genre", "List Plays With Genre", "List 2D Movies", "List 3D Movies");
    }

    public void OnRunPressed(ActionEvent actionEvent) {
        switch(Dropdown.getValue()) {
            case "List All Cinemas":
                cinemaService.listAllCinemas();
                break;
            case "List Available Shows":
                cinemaService.listAvailableShows(ArgumentsTextBox.getText());
                break;
            case "List Available Movies":
                cinemaService.listAvailableMovies(ArgumentsTextBox.getText());
                break;
            case "List Available Plays":
                cinemaService.listAvailablePlays(ArgumentsTextBox.getText());
                break;
            case "Search For Movie":
                cinemaService.searchForMovie(ArgumentsTextBox.getText());
                break;
            case "Search For Play":
                cinemaService.searchForPlay(ArgumentsTextBox.getText());
                break;
            case "List Movies With Genre":
                showService.listMoviesWithGenre(ArgumentsTextBox.getText());
                break;
            case "List Plays With Genre":
                showService.listPlaysWithGenre(ArgumentsTextBox.getText());
                break;
            case "List 2D Movies":
                showService.list2DMovies();
                break;
            case "List 3D Movies":
                showService.list3DMovies();
                break;
            default:
                System.out.println("Incorrect input");

        }
    }
}
