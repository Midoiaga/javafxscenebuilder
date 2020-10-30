package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ErroreKud {
    private Main mainapp;
    @FXML
    private Button okBotoia;

    @FXML
    private Label testuaLbl;


    public void setMainApp(Main mainapp){
        this.mainapp=mainapp;
    }
    public void setLabel(String pHerrialde){
        testuaLbl.setText(pHerrialde+" jada banitu ditu bere puntuak");
    }
    @FXML
    void onOK(ActionEvent event) {
        System.exit(0);
    }

}