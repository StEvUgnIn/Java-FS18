package mvc;

import javafx.application.Platform;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;


public class CpView extends View {

    public CpView (CounterModel model, CounterController controller) {

        super(model, controller);

        StringBinding timerState = new When(model.getStopPrp()).then("" + Timer.STOPPED).otherwise("" + Timer.RUNNING);
        label.textProperty().bind(timerState);

        setTitle("Watch");
        setX(500);
        setY(650);

        setOnCloseRequest(e -> Platform.exit());
        show();
    }

}
