package mvc;

import javafx.application.Application;
import javafx.stage.Stage;

public class MVCCounter extends Application {

    public static void main (String[] args) {
        Application.launch(args);
    }

    public void start (Stage stage) {
        CounterModel model = new CounterModel();
        CounterController controller = new CounterController(model);

        new WatchView(model, controller);
        new CounterView(model, controller);
        new CpView(model, controller);
        new TotalView(model, controller);

    }

}
