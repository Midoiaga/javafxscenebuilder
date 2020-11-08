package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreKud implements Kudeatzaile{
    private Main mainapp;
    @FXML
    private Button okBotoia;

    @FXML
    private Label testuaLbl;


    public void setMainApp(Main mainapp){
        this.mainapp=mainapp;
    }
    public void setLabel(String pHerrialde){
        testuaLbl.setText(pHerrialde+"k jada banatu ditu bere puntuak");
    }
    @FXML
    void onOK(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}