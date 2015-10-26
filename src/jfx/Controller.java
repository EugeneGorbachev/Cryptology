package jfx;

import console.CaesarDecoder;
import console.Language;
import console.VigenereDecoder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Eugene on 10/19/2015.
 */
public class Controller implements Initializable {
    CaesarDecoder caesarDecoder;
    VigenereDecoder vigenereDecoder;

    @FXML// fx:id="tab1EncryptedText"
    private TextArea tab1EncryptedText;

    @FXML// fx:id="tab1DecryptedText"
    private TextArea tab1DecryptedText;

    @FXML// fx:id="tab1ButtonEncrypt"
    private Button tab1ButtonEncrypt;

    @FXML// fx:id="tab1ButtonDecrypt"
    private Button tab1ButtonDecrypt;

    @FXML// fx:id="tab1LabelSlider"
    private Label tab1LabelSlider;

    @FXML// fx:id="tab1Slider"
    private Slider tab1Slider;

    @FXML// fx:id="tab1LanguageComboBox"
    private ComboBox<Language> tab1LanguageComboBox;

    ///////////////////////
    @FXML// fx:id="tab2EncryptedText"
    private TextArea tab2EncryptedText;

    @FXML// fx:id="tab2DecryptedText"
    private TextArea tab2DecryptedText;

    @FXML// fx:id="tab2ButtonEncrypt"
    private Button tab2ButtonEncrypt;

    @FXML// fx:id="tab2ButtonDecrypt"
    private Button tab2ButtonDecrypt;

    @FXML// fx:id="tab2Keyword"
    private TextField tab2Keyword;

    @FXML// fx:id="tab2LanguageComboBox"
    private ComboBox<Language> tab2LanguageComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caesarDecoder = new CaesarDecoder(0, Language.ENG);
        tab1Slider.setMin(-caesarDecoder.getAlphabet().size());
        tab1Slider.setMax(caesarDecoder.getAlphabet().size());
        tab1Slider.setValue(0);
        tab1LanguageComboBox.setValue(Language.ENG);

        tab1ButtonEncrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tab1DecryptedText.setText(caesarDecoder.encrypt(tab1EncryptedText.getText()));
            }
        });

        tab1ButtonDecrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tab1EncryptedText.setText(caesarDecoder.decrypt(tab1DecryptedText.getText()));
            }
        });

        tab1Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                caesarDecoder.setShift(newValue.intValue());
                tab1LabelSlider.setText(String.valueOf(newValue.intValue()));
            }
        });

        tab1LanguageComboBox.getItems().setAll(Language.values());
        tab1LanguageComboBox.valueProperty().addListener(new ChangeListener<Language>() {
            @Override
            public void changed(ObservableValue<? extends Language> observable, Language oldValue, Language newValue) {
                if (newValue != null) {
                    caesarDecoder.setLanguage(newValue);
                    tab1Slider.setMin(-caesarDecoder.getAlphabet().size());
                    tab1Slider.setMax(caesarDecoder.getAlphabet().size());
                    tab1Slider.setValue(0);
                }
            }
        });

        vigenereDecoder = new VigenereDecoder("lemon", Language.ENG);
        tab2Keyword.setText("lemon");
        tab2LanguageComboBox.setValue(Language.ENG);

        tab2ButtonEncrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tab2DecryptedText.setText(vigenereDecoder.encrypt(tab2EncryptedText.getText()));
            }
        });

        tab2ButtonDecrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tab2EncryptedText.setText(vigenereDecoder.decrypt(tab2DecryptedText.getText()));
            }
        });

        tab2Keyword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                vigenereDecoder.setKey(tab2Keyword.getText());
            }
        });

        tab2LanguageComboBox.getItems().setAll(Language.values());
        tab2LanguageComboBox.valueProperty().addListener(new ChangeListener<Language>() {
            @Override
            public void changed(ObservableValue<? extends Language> observable, Language oldValue, Language newValue) {
                if (newValue != null) {
                    vigenereDecoder.setLanguage(newValue);
                }
            }
        });
    }
}
