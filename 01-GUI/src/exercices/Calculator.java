package exercices;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class Calculator extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) {
        Label title = new Label("MY KEYPAD");
        title.setAlignment(Pos.TOP_LEFT);

        Label result = new Label("0");
        result.setStyle("-fx-background-color: lightgreen");
        result.setAlignment(Pos.CENTER_RIGHT);
        result.setMaxWidth(Double.MAX_VALUE);

        Button[] numButtons = new Button[10];
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new Button("" + i);
            numButtons[i].setMaxWidth(Double.MAX_VALUE);
        }

        Button dotButton = new Button(".");
        dotButton.setMaxWidth(Double.MAX_VALUE);
        Button ceButton = new Button("CE");

        TilePane buttonPane = new TilePane(
                numButtons[7], numButtons[8], numButtons[9],
                numButtons[4], numButtons[5], numButtons[6],
                numButtons[1], numButtons[2], numButtons[3],
                numButtons[0], dotButton, ceButton
        );
        buttonPane.setPrefColumns(3);

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(result);
        mainPane.setStyle("-fx-font: 24 Arial");
        mainPane.setCenter(buttonPane);

        HBox hPane = new HBox(mainPane);
        hPane.setAlignment(Pos.CENTER);
        VBox vPane = new VBox(hPane);
        vPane.setAlignment(Pos.CENTER);

        AnchorPane rootPane = new AnchorPane(vPane, title);
        AnchorPane.setLeftAnchor(title, 10.0);

        Scene scene = new Scene(rootPane);

        stage.setScene(scene);
        stage.show();
    }

    private void pressButton(Button sender, MouseEvent event) {

    }
}
