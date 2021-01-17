package exercices;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

public class BindingsDemo extends Application {

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private Pane colorPane;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) {
        colorPane = new Pane();
        BorderPane pane = new BorderPane(createControlPane());
        pane.setCenter(colorPane);
        pane.setBottom(createControlPane());

        StringBinding styleBinding = new StringBinding() {
            {
                bind(Bindings.concat(
                    redSlider.valueProperty(), greenSlider.valueProperty(), blueSlider.valueProperty())
                );
            }

            @Override
            protected String computeValue () {
                return getSampleColor();
            }
        };

        redSlider.addEventHandler(MouseEvent.ANY, event -> sliderMoved(redSlider, event));
        greenSlider.addEventHandler(MouseEvent.ANY, event -> sliderMoved(greenSlider, event));
        blueSlider.addEventHandler(MouseEvent.ANY, event -> sliderMoved(blueSlider, event));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Coloured Panel");
        stage.show();
    }

    private Pane createControlPane () {
        Slider redSlider   = new Slider(0, 255, 255);
        Slider greenSlider = new Slider(0, 255, 175);
        Slider blueSlider  = new Slider(0, 255, 175);

        GridPane pane = new GridPane();
        pane.addRow(0, createLabel(redSlider,   "red-ball.gif",   "Red: "),   redSlider);
        pane.addRow(1, createLabel(greenSlider, "green-ball.gif", "Green: "), greenSlider);
        pane.addRow(2, createLabel(blueSlider,  "blue-ball.gif",  "Blue: "),  blueSlider);

        return pane;
    }

    private Label createLabel (Slider slider, Image img, Color color) throws InvocationTargetException {
        return createLabel(slider, img.toString(), color + ": ");
    }

    private Label createLabel (Slider slider, String img, String color) {
        Label label = new Label(color);
        label.setGraphic(new ImageView(getClass().getResource(img).toExternalForm()));
        label.textProperty().bind(Bindings.concat(label, slider.valueProperty().asString("%3.0f")));
        return label;
    }

    private String getSampleColor() {
        double red   = redSlider.getValue();
        double green = greenSlider.getValue();
        double blue  = blueSlider.getValue();

        return  "-fx-background-color: rgb(" + red + ", " + green + ", " + blue + ")";
    }

    private void sliderMoved (Slider sender, MouseEvent event) {
        colorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf(getSampleColor()), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}


