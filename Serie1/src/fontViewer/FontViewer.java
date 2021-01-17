/**
 * @title First Presentation
 * @authors Seyed Hady Asady & Huguenin-Elie Steve André
 * @version v1.0
 * @date April 2018
 */
package fontViewer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.function.Function;

/**
 * This frame contains a text sample, a control panel, and a menu structure to
 * change the font of the text.
 */
public class FontViewer extends Application {

    private static final double SMALL_SIZE = 24.0, MEDIUM_SIZE = 36.0, LARGE_SIZE = 48.0;

    private FontWeight weight;
    private FontPosture posture;
    private Font font;

    private Menu faceMenu;
    private Label label, fontSizeLabel;
    private ComboBox<String> comboBox;

    private Stage stage;
    private ToggleGroup toggleGroup;
    private HBox styleBox;

    /**
     * main is the entry point of the program
     *
     * @param args arguments
     */
    public static void main (String[] args) {
        Application.launch(args);
    }

    /**
     * @param stage
     */
    public void start (Stage stage) {
        this.stage = stage;
        font = Font.font(LARGE_SIZE);

        BorderPane pane = new BorderPane();
        pane.setBottom(createControlBox());
        pane.setCenter(createLabel());
        pane.setTop(createMenuBar());
        label.setFont(font);
        toggleGroup.getToggles().get(2).setSelected(true);

        Scene scene = new Scene(pane);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Font Viewer");
        stage.show();
    }

    /**
     * Creates the label.
     *
     * @return the label
     */
    private Label createLabel () {
        Image img = new Image(getClass().getResourceAsStream("BigJava.jpg"));
        ImageView imgView = new ImageView(img);
        label = new Label("Big Java", imgView);
        // Specifies the positioning of the graphic relative to the text.
        label.setContentDisplay(ContentDisplay.RIGHT);
        label.setFont(Font.font("Serif", font.getSize()));
        // The amount of space between the graphic and text
        label.setGraphicTextGap(20);
        label.setPadding(new Insets(20));

        return label;
    }

    /**
     * Creates the label font.getSize().
     *
     * @return the h box
     */
    private HBox createLabelSize () {
        HBox labelHbox = new HBox();
        fontSizeLabel = new Label("Font Size: " + (long)font.getSize());
        labelHbox.getChildren().add(fontSizeLabel);
        labelHbox.setAlignment(Pos.CENTER);

        return labelHbox;
    }

    /**
     * Creates the control box.
     *
     * @return the h box
     */
    private Pane createControlBox () {
        Slider slider = createSizeSlider();
        VBox vControlBox = new VBox(createLabelSize(), createFaceNameCombo(), createStyleCheckBoxes());
        vControlBox.setAlignment(Pos.CENTER);
        vControlBox.setPadding(new Insets(10));
        vControlBox.setSpacing(40);

        VBox controlBox = new VBox();
        HBox hControlBox = new HBox();
        hControlBox.getChildren().addAll(slider, vControlBox);
        hControlBox.setAlignment(Pos.CENTER);

        controlBox.getChildren().addAll(hControlBox, createSizeButtons(slider));
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setPadding(new Insets(20));

        return controlBox;
    }

    /**
     * Creates the face name combo.
     *
     * @return the combo box
     */
    private ComboBox<String> createFaceNameCombo () {
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Serif", "Sans Serif", "Monospaced");
        comboBox.setValue("Serif");
        comboBox.setEditable(true);

        // Listener to get the selected font
        comboBox.valueProperty().addListener((ov, oldValue, newValue) -> {
            font = Font.font(newValue, weight, posture, font.getSize());
            label.setFont(font);
            // add new font to combobox and menu bar
            if (!comboBox.getItems().contains(newValue)) {
                comboBox.getItems().add(newValue);
                faceMenu.getItems().add(new MenuItem(newValue));
            }
            stage.sizeToScene();
        });

        return comboBox;
    }

    /**
     * Creates the style check boxes.
     *
     * @return the h box
     */
    private HBox createStyleCheckBoxes () {
        // italic CheckBox
        CheckBox italicCheckBox = new CheckBox("Italic");
        // Listener for italicCheckBox
        italicCheckBox.selectedProperty().addListener(i -> {
            if (italicCheckBox.isSelected()) {
                posture = FontPosture.ITALIC;
            } else {
                posture = FontPosture.REGULAR;
            }
            font = Font.font(font.getFamily(), weight, posture, font.getSize());
            label.setFont(font);
            stage.sizeToScene();
        });

        // bold CheckBox
        CheckBox boldCheckBox = new CheckBox("Bold");
        // Listener for boldCheckBox
        boldCheckBox.selectedProperty().addListener(i -> {
            if (boldCheckBox.isSelected()) {
                weight = FontWeight.BOLD;
            } else {
                weight = FontWeight.NORMAL;
            }
            font = Font.font(font.getFamily(), weight, posture, font.getSize());
            label.setFont(font);
            stage.sizeToScene();
        });

        // put CheckBoxes to HBox
        styleBox = new HBox();
        styleBox.setAlignment(Pos.CENTER);
        styleBox.setSpacing(20);
        styleBox.getChildren().addAll(italicCheckBox, boldCheckBox);

        return styleBox;
    }

    /**
     * Creates the font.getSize() buttons.
     *
     * @return the h box
     */
    private HBox createSizeButtons (Slider slider) {
        // group Buttons together
        toggleGroup = new ToggleGroup();

        RadioButton smallButton = new RadioButton("Small");
        RadioButton mediumButton = new RadioButton("Medium");
        RadioButton largeButton = new RadioButton("Large");

        Function<ActionEvent, Void> action = e -> {
            label.setFont(font);
            fontSizeLabel.setText("" + font.getSize());
            if (smallButton.isSelected()) {
                slider.setValue(SMALL_SIZE);
            } else if (mediumButton.isSelected()) {
                slider.setValue(MEDIUM_SIZE);
            } else if (largeButton.isSelected()) {
                slider.setValue(LARGE_SIZE);
            }
            return null;
        };

        // smallButton
        smallButton.setToggleGroup(toggleGroup);
        smallButton.setOnAction(e -> {
            font = Font.font(font.getFamily(), weight, posture, SMALL_SIZE);
            action.apply(e);
        });

        // mediumButton
        mediumButton.setToggleGroup(toggleGroup);
        mediumButton.setOnAction(e -> {
            font = Font.font(font.getFamily(), weight, posture, MEDIUM_SIZE);
            action.apply(e);
        });

        // largeButton
        largeButton.setToggleGroup(toggleGroup);
        largeButton.setOnAction(e -> {
            font = Font.font(font.getFamily(), weight, posture, LARGE_SIZE);
            action.apply(e);
        });

        // create horizontal box and add buttons
        HBox sizeBox = new HBox();
        sizeBox.setAlignment(Pos.CENTER);
        sizeBox.setSpacing(20);
        sizeBox.getChildren().addAll(smallButton, mediumButton, largeButton);

        return sizeBox;
    }

    /**
     * Creates the font.getSize() slider.
     *
     * @return the slider
     */
    private Slider createSizeSlider () {
        Slider slider = new Slider(10, 70, LARGE_SIZE);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);

        slider.valueProperty().addListener((ov, oldValue, newValue) -> {
            font = Font.font(font.getFamily(), weight, posture, newValue.doubleValue());
            fontSizeLabel.textProperty().setValue("Font Size: " + (long)font.getSize());
            label.setFont(font);
            if (font.getSize() < MEDIUM_SIZE) {
                toggleGroup.getToggles().get(0).setSelected(true);
            } else if (font.getSize() < LARGE_SIZE) {
                toggleGroup.getToggles().get(1).setSelected(true);
            } else {
                toggleGroup.getToggles().get(2).setSelected(true);
            }

            stage.sizeToScene();
        });

        return slider;
    }

    /**
     * Creates the menu bar.
     *
     * @return the menu bar
     */
    private MenuBar createMenuBar () {
        // create Menu
        Menu menu = new Menu("Font");

        // create Face Menu
        faceMenu = new Menu("Face");
        // add items to Face Menu
        faceMenu.getItems().add(new MenuItem("Serif"));
        faceMenu.getItems().add(new MenuItem("Sans Serif"));
        faceMenu.getItems().add(new MenuItem("Monospaced"));

        // create style Menu
        Menu styleMenu = new Menu("Style");
        // create items of Style Menu
        CheckMenuItem italicItem = new CheckMenuItem("Italic");
        CheckMenuItem boldItem = new CheckMenuItem("Bold");
        // add items to Style Menu
        styleMenu.getItems().addAll(italicItem, boldItem);

        // add Face and Style to Menu
        menu.getItems().addAll(faceMenu, new SeparatorMenuItem(), styleMenu);

        // if style is chosen in Font Menu set the according Value in ComboBox
        for (MenuItem item : faceMenu.getItems()) {
            item.setOnAction(e -> comboBox.setValue(item.getText()));
        }
        // bind styleMenu with Style Boxes
        CheckBox italicCheckBox = (CheckBox)(styleBox.getChildren().get(0));
        CheckBox boldCheckBox = (CheckBox)(styleBox.getChildren().get(1));

        italicItem.selectedProperty().bindBidirectional(italicCheckBox.selectedProperty());
        boldItem.selectedProperty().bindBidirectional(boldCheckBox.selectedProperty());

        // activate key combinations for italic and bold
        italicItem.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        boldItem.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));

        return new MenuBar(menu);
    }
}
