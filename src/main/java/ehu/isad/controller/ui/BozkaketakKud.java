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
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BozkaketakKud implements Kudeatzaile {

    private Main mainapp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<OrdezkapenModel> tbBotoak;


    @FXML
    private TableColumn<OrdezkapenModel, Image> clBandera;

    @FXML
    private TableColumn<OrdezkapenModel, String> clHerrialdea;

    @FXML
    private TableColumn<OrdezkapenModel, String> clArtista;

    @FXML
    private TableColumn<OrdezkapenModel, String> clAbestia;

    @FXML
    private TableColumn<OrdezkapenModel, String> clPuntuak;

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

        clHerrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        clArtista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        clAbestia.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
        clPuntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));
        clBandera.setCellValueFactory(new PropertyValueFactory<OrdezkapenModel, Image>("image"));

        clBandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
//                    imageview.setFitHeight(50);
//                    imageview.setFitWidth(50);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });


        // modeloaren datuak taulan txertatu
        tbBotoak.setItems(ordezkapenModels);


    }
}