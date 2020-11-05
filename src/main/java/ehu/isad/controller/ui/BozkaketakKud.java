package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class BozkaketakKud implements Kudeatzaile {

    private Main mainapp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> tbBotoak;

    @FXML
    private Label lbBozkatzaile;

    @FXML
    private Button btnGorde;

    public void setMainApp(Main mainapp){
        this.mainapp=mainapp;
    }

    @FXML
    void onGorde(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}