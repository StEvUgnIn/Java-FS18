package demo;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import static javafx.scene.layout.BorderPane.setAlignment;

public class I18nShortExample extends Application {

    private Label dateLb  = new Label("Label");
    private Label timeLb  = new Label("Label");
    private Label msgLb   = new Label("Label");
    private Menu langMenu = new Menu("menu");

    private MenuItem[] langItems = {new MenuItem("MenuItem"),
            new MenuItem("MenuItem"),
            new MenuItem("MenuItem")};

    private Button updateBt = new Button("Button");
    private Locale defaultLoc;

    private static final Locale LOCALES[] = {
            Locale.FRENCH,
            Locale.GERMAN,
            Locale.ENGLISH
    };

    public void start(Stage stage) {
        defaultLoc = Locale.getDefault();
        createGUI(stage);
        stage.show();
    }

    private void createGUI(Stage stage) {
        for (MenuItem item : langItems) {
            item.setOnAction(e -> setLanguage(item.getText()));
            langMenu.getItems().add(item);
        }

        VBox box = new VBox(10.0, dateLb, timeLb, msgLb);
        box.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-font: 14 Verdana");
        setAlignment(updateBt, Pos.CENTER);
        root.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
        root.setTop(new MenuBar(langMenu));
        root.setCenter(box);
        root.setBottom(updateBt);
        updateBt.setOnAction(e -> display(defaultLoc));

        Scene scene = new Scene(root, 650.0, 200.0);

        stage.setScene(scene);
        stage.setTitle("I18n Short Example");
    }

    private void setLanguage (String text) {
        for (Locale loc : LOCALES)
            if (loc.getDisplayLanguage().equals(text)) display(loc);
    }

    private void display(Locale locale) {
        Locale.setDefault(locale);
        ResourceBundle rb = ResourceBundle.getBundle("demo.UIResources");

        ZonedDateTime now = ZonedDateTime.now();
        String msg = rb.getString("date");
        DateTimeFormatter dateFmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String date = dateFmt.format(now);
        dateLb.setText(MessageFormat.format(msg, date));

        msg = rb.getString("time");
        Date time = Date.from(now.toInstant());
        timeLb.setText(MessageFormat.format(msg, time));

        msg = rb.getString("text");
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
        NumberFormat percentFmt = NumberFormat.getPercentInstance();
        percentFmt.setMinimumFractionDigits(1);
        String amount  = currencyFmt.format(Math.random() * 100.0);
        String percent = percentFmt.format(Math.random());
        msgLb.setText(MessageFormat.format(msg, amount, percent));

        String[] languages = new String[LOCALES.length];

        for (int i = 0; i < languages.length; i++)
            languages[i] = LOCALES[i].getDisplayLanguage();
        Arrays.sort(languages, Collator.getInstance());
        List<MenuItem> langItems = langMenu.getItems();
        for (int i = 0; i < langItems.size(); i++)
            langItems.get(i).setText(languages[i]);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
