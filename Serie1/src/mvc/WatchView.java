package mvc;

import javafx.application.Platform;

public class WatchView extends View {

    public WatchView (CounterModel model, CounterController controller) {

        super(model, controller);

        label.setText(model.getTime());
        label.textProperty().bind(model.getTimePrp());

        setTitle("Watch");
        setX(1000);
        setY(350);

        setOnCloseRequest(e -> Platform.exit());
        show();
    }

}
