package mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class View extends Stage {
    protected Label label;
    protected Button start, stop, reset;
    protected VBox vb;

    protected View (CounterModel model, CounterController controller) {

        start = new Button("Start");
        stop = new Button("Stop");
        reset = new Button("Reset");

        start.setOnAction(e -> controller.start());
        reset.setOnAction(e -> controller.reset());
        stop.setOnAction(e -> controller.stop());
        stop.setDisable(true);
        start.disableProperty().bindBidirectional(model.getStartPrp());
        stop.disableProperty().bindBidirectional(model.getStopPrp());
        reset.disableProperty().bindBidirectional(model.getResetPrp());

        label = new Label();
        label.setStyle("-fx-font-Size: 25");

        HBox pane = new HBox(10, start, stop, reset);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));

        vb = new VBox(label, pane);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10));
        vb.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(vb, 400, 200);
        setScene(scene);
    }


    protected enum Timer {
        STOPPED("Timers Stopped"),
        RUNNING("Timers Running");

        private String value;

        Timer (String value) {
            this.value = value;
        }

        public String getValue () {
            return value;
        }

        @Override
        public String toString () {
            return value;
        }
    }
}
