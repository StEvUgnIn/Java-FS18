package factorial;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private TextField input = new TextField("0");
    private Button button = new Button("Send");
    private Text output = new Text("0");

    @Override
    public void start(Stage primaryStage) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            btnClick(button, event);
        });

        Parent root = new StackPane(input, button, output);
        primaryStage.setTitle("Factorial");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void btnClick(Node sender, MouseEvent event) {
        double f = f(Integer.parseInt(input.getText()));
        output.setText(Double.toString(f));
    }

    private int f (int n) {
        n = Math.max(0, n);
        int i;
        for (i = 1; i <= n; i++) { i *= i; }
        return i;
    }
}
