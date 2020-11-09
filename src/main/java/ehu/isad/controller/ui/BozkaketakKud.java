package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

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
    private TableColumn<OrdezkapenModel, Integer> clPuntuak;

    @FXML
    private Label lbBozkatzaile;

    @FXML
    private Button btnGorde;

    private ObservableList<OrdezkapenModel> ordezkapenModels = FXCollections.observableArrayList();

    private String herrialde;

    private int puntuak;

    public void setHerrialde(String pHerrialde) {
        this.herrialde = pHerrialde;
    }

    public void setMainApp(Main mainapp) {
        this.mainapp = mainapp;
    }

    public void setLbBozkatzaile(String pHerrialde) {
        lbBozkatzaile.setText(pHerrialde + "k horrela banatu nahi ditu bere puntuak");
    }

    @FXML
    void onGorde(ActionEvent event) {

        int i = 0;
        int puntuak = 0;
        while (i < tbBotoak.getItems().size() && puntuak < 5) {
            puntuak = puntuak + tbBotoak.getItems().get(i).getPuntuak();
            i++;
        }
        if (puntuak == 5) {
            this.sartuDB();
            this.mainapp.top3Erakutsi();
        }
    }


        private void sartuDB () {
            int i;
            for (i = 0; i<tbBotoak.getItems().size(); i++) {
                if (tbBotoak.getItems().get(i).getPuntuak() !=0) {
                    int punt = tbBotoak.getItems().get(i).getPuntuak();
                    String bozkatua = tbBotoak.getItems().get(i).getHerrialdea();
                    BozkaketaDBKud.getInstantzia().bozkaketaSartu(punt, this.herrialde, bozkatua);
                    OrdezkapenDBKud.getInstantzia().bozkaketakEguneratu(punt, bozkatua);
                }
            }
        }
        @Override
        public void initialize (URL location, ResourceBundle resources){
            tbBotoak.setEditable(true);

            ordezkapenModels.addAll(OrdezkapenDBKud.getInstantzia().ordezkpaenakLortu());

            clHerrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
            clArtista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
            clAbestia.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
            clPuntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));
            clBandera.setCellValueFactory(new PropertyValueFactory<OrdezkapenModel, Image>("image"));

//            clPuntuak.setCellFactory(
//                    TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            clPuntuak.setOnEditCommit(
                    t -> {
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).setPuntuak(t.getNewValue());

                    });

            clBandera.setCellFactory(p -> new TableCell<>() {
                public void updateItem(Image image, boolean empty) {
                    if (image != null && !empty) {
                        final ImageView imageview = new ImageView();
//                  imageview.setFitHeight(50);
//                  imageview.setFitWidth(50);
                        imageview.setImage(image);
                        setGraphic(imageview);
                        setAlignment(Pos.CENTER);
                        // tbData.refresh();
                    } else {
                        setGraphic(null);
                        setText(null);
                    }
                }

                ;
            });


            Callback<TableColumn<OrdezkapenModel, Integer>, TableCell<OrdezkapenModel, Integer>> defaultTextFieldCellFactory
                    = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

            clPuntuak.setCellFactory(col -> {
                TableCell<OrdezkapenModel, Integer> cell = defaultTextFieldCellFactory.call(col);


                cell.setOnMouseClicked(e -> {
                    if (!cell.isEmpty()) {
                        if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(this.herrialde)) {
                            cell.setEditable(false);
                        } else {
                            cell.setEditable(true);
                        }
                    }
                });

                return cell;
            });

            // modeloaren datuak taulan txertatu
            tbBotoak.setItems(ordezkapenModels);


        }
    }
