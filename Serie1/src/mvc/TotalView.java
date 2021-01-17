package mvc;

import javafx.application.Platform;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.scene.control.Label;

public class TotalView extends View {

    private Label label2;

    public TotalView (CounterModel model, CounterController controller) {

        super(model, controller);

        label2 = new Label(model.getTime());
        label2.setStyle(label.getStyle());
        label2.textProperty().bind(model.getTimePrp());

        StringBinding timerState = new When(model.getStopPrp()).then("" + Timer.STOPPED).otherwise("" + Timer.RUNNING);
        label.textProperty().bind(timerState);

        vb.getChildren().add(label2);

        setTitle("Watch");
        setX(1000);
        setY(650);

        setOnCloseRequest(e -> Platform.exit());
        show();
    }

}
