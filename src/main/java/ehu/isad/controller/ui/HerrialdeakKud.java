package ehu.isad.controller.ui;


import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.HerrialdeDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeakKud implements Kudeatzaile {
  private Main mainapp;

  @FXML
  private Button okBotoia;

  @FXML
  private ComboBox<String> combozerbitzua;

  @FXML
  void onOK(ActionEvent event) {
    String bandera = BozkaketaDBKud.getInstantzia().lortuBozkatua(combozerbitzua.getValue());
    if (bandera != "") {
      mainapp.erroreErakutsi(combozerbitzua.getValue());
    } else {
      System.exit(0);
    }
  }

  public void setMainApp(Main mainapp){
    this.mainapp=mainapp;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    List<String> herrrialdeList = HerrialdeDBKud.getInstantzia().lortuHerrialdeak();
    ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrrialdeList);

    combozerbitzua.setItems( herrialdeak );
    combozerbitzua.getSelectionModel().selectFirst();
  }
}
