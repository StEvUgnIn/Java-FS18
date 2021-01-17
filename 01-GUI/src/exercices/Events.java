package exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static java.lang.Math.random;

public class Events extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) {
        Button button = new Button("Click me!");
        StackPane root = new StackPane(button);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Circle circle = makeCircle(event);
            addEventAnyFilter(circle);
            addEventDraggedFilter(circle);
            addEventPressedFilter(circle);
        });
        Scene scene = new Scene(root, 500.0, 500.0);
        stage.setTitle("Event Demo");
        stage.setScene(scene);
        stage.show();
    }

    private void addEventAnyFilter(Circle circle) {
        circle.addEventFilter(MouseEvent.ANY, event -> event.consume());
    }

    private void addEventDraggedFilter(Circle circle) {
        circle.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {});
    }

    private void addEventPressedFilter(Circle circle) {
        circle.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {});
    }

    private Circle makeCircle(MouseEvent e) {
        Circle circle = new Circle(
                e.getX(),
                e.getY(),
                random() * 200.0 + 10.0,
                Color.color(random(), random(), random())
        );
        return circle;
    }


}
