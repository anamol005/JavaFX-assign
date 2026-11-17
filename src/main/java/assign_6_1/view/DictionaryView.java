package assign_6_1.view;

import assign_6_1.controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller;
    private TextField wordField;
    private Label result;

    public void start(Stage stage) {

        controller = new DictionaryController();

        wordField = new TextField();
        wordField.setPromptText("Enter a word");

        Button searchButton = new Button("Search");

        result = new Label("Enter a word to search");

        FlowPane pane = new FlowPane();

        pane.getChildren().add(wordField);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(result);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String word = wordField.getText();
                String meaning = controller.search(word);
                result.setText(meaning);
            }
        });

        Scene scene = new Scene(pane, 400, 200);

        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}
