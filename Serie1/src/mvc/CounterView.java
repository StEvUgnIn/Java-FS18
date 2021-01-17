package mvc;

import javafx.application.Platform;

public class CounterView extends View {

    public CounterView (CounterModel model, CounterController controller) {

        super(model, controller);

        label.setText(model.getTime());
        label.textProperty().bind(model.getTimePrp());

        setTitle("Counter");
        setX(500);
        setY(350);

        setOnCloseRequest(e -> Platform.exit());
        show();

        controller.addObserver(model);

    }
}
