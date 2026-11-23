package assign_6_2.view;

import assign_6_2.controller.CurrencyController;
import assign_6_2.model.Currency;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyView extends Application {

    public void start(Stage stage) {
        CurrencyController controller = new CurrencyController();

        Label instructions = new Label("Enter an amount, select currencies and click Convert.");

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From currency:");
        ChoiceBox<Currency> fromBox = new ChoiceBox<>();
        fromBox.getItems().addAll(controller.getCurrencies());
        fromBox.setValue(controller.getCurrencies().get(0));

        Label toLabel = new Label("To currency:");
        ChoiceBox<Currency> toBox = new ChoiceBox<>();
        toBox.getItems().addAll(controller.getCurrencies());
        toBox.setValue(controller.getCurrencies().get(1));

        Label resultLabel = new Label("Converted amount:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Label message = new Label();
        Button convertButton = new Button("Convert");

        convertButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                double result = controller.convert(
                        amount, fromBox.getValue(), toBox.getValue());

                resultField.setText(String.format("%.2f", result));
                message.setText("");
            } catch (NumberFormatException e) {
                resultField.clear();
                message.setText("Please enter a valid number.");
            }
        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromBox, 0, 2);
        grid.add(toLabel, 1, 1);
        grid.add(toBox, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);

        VBox layout = new VBox(15);
        layout.getChildren().addAll(instructions, grid, message);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 480, 300);
        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }
}
