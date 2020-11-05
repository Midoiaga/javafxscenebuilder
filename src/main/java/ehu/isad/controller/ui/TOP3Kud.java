package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TOP3Kud implements Kudeatzaile{

    private Main mainapp;

    @FXML
    private Label lbTOP1;

    @FXML
    private Label lbTOP2;

    @FXML
    private Label lbTOP3;

    @FXML
    private Button btnOK;

    @FXML
    private ImageView imgTOP1;

    @FXML
    private ImageView imgTOP2;

    @FXML
    private ImageView imgTOP3;

    public void setMainApp(Main mainapp){
        this.mainapp=mainapp;
    }

    @FXML
    void onOK(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}