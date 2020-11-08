package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.OrdezkapenDBKud;
import ehu.isad.model.OnenakModel;
import ehu.isad.model.OrdezkapenModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TOP3Kud implements Kudeatzaile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOK;

    @FXML
    private TableView<OnenakModel> tbOnenak;

    @FXML
    private TableColumn<OnenakModel, Image> clBandera;

    @FXML
    private TableColumn<OnenakModel, String> clHerrialde;

    @FXML
    private TableColumn<OnenakModel, Integer> clPuntuak;

    private Main mainApp;

    private ObservableList<OnenakModel> onenakModels = FXCollections.observableArrayList();


    @FXML
    void onOK(ActionEvent event) {
        System.exit(0);
    }
    public void denaKargatuU(){
        onenakModels.addAll(OrdezkapenDBKud.getInstantzia().onenakLortu());
        clHerrialde.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        clPuntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));
        clBandera.setCellValueFactory(new PropertyValueFactory<OnenakModel, Image>("image"));

        clBandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
//                  imageview.setFitHeight(50);
//                  imageview.setFitWidth(50);
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

        tbOnenak.setItems(onenakModels);


    }

    @Override
    public void setMainApp(Main mainapp) {
        this.mainApp = mainapp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}