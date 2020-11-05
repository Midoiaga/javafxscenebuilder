package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.OrdezkapenDBKud;
import ehu.isad.model.OrdezkapenModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<OrdezkapenModel> tbBotoak;

    @FXML
    private Label lbBozkatzaile;

    @FXML
    private Button btnGorde;

    private ObservableList<OrdezkapenModel> ordezkapenModels = FXCollections.observableArrayList();


    public void setMainApp(Main mainapp){
        this.mainapp=mainapp;
    }

    @FXML
    void onGorde(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ordezkapenModels.addAll(OrdezkapenDBKud.getInstantzia().ordezkpaenakLortu());

    }
}