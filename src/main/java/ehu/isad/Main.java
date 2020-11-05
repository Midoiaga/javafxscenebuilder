package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent herrialdeakUI;
  private Parent erroreUI;
  private Parent bozkaketakUI;
  private Parent TOP3UI;


  private Stage stage;

  private NagusiaKud nagusiaKud;
  private HerrialdeakKud herrialdeakKud;
  private ErroreKud erroreKud;
  private BozkaketakKud bozkaketakKud;
  private TOP3Kud TOP3Kud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(nagusiaUI));
    stage.show();
  }


//  private Parent kargatu(String pFxml,Kudeatzaile pKud) throws IOException {
//
//    FXMLLoader loaderNagusia = new FXMLLoader(getClass().getResource("/"+pFxml+".fxml"));
//    Parent pUi = (Parent) loaderNagusia.load();
//    pKud = loaderNagusia.getController();
//    pKud.setMainApp(this);
//
//    return pUi;
//  }
  private void pantailakKargatu() throws IOException {

//    nagusiaUI=kargatu("NagusiaUI",nagusiaKud);
//    herrialdeakUI=kargatu("Herrialdeak",herrialdeakKud);
//    erroreUI=kargatu("Errorea",erroreKud);
//    bozkaketakUI=kargatu("Bozkaketak",bozkaketakKud);
//    TOP3UI=kargatu("TOP3",this.TOP3Kud);
    FXMLLoader loaderNagusia = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
    nagusiaUI = (Parent) loaderNagusia.load();
    nagusiaKud = loaderNagusia.getController();
    nagusiaKud.setMainApp(this);


    FXMLLoader loaderHerrialdeak = new FXMLLoader(getClass().getResource("/Herrialdeak.fxml"));
    herrialdeakUI = (Parent) loaderHerrialdeak.load();
    herrialdeakKud = loaderHerrialdeak.getController();
    herrialdeakKud.setMainApp(this);

    FXMLLoader loaderErrorea = new FXMLLoader(getClass().getResource("/Errorea.fxml"));
    erroreUI = (Parent) loaderErrorea.load();
    erroreKud = loaderErrorea.getController();
    erroreKud.setMainApp(this);

    FXMLLoader loaderBozkaketak = new FXMLLoader(getClass().getResource("/Bozkaketak.fxml"));
    bozkaketakUI = (Parent) loaderBozkaketak.load();
    bozkaketakKud = loaderBozkaketak.getController();
    bozkaketakKud.setMainApp(this);

    FXMLLoader loaderTOP3 = new FXMLLoader(getClass().getResource("/TOP3.fxml"));
    TOP3UI = (Parent) loaderTOP3.load();
    TOP3Kud = loaderTOP3.getController();
    TOP3Kud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void herrialdeakErakutsi() {
    stage.setScene(new Scene(herrialdeakUI));
    stage.show();

  }
  public void erroreErakutsi(String pHerrialde) {
    stage.setScene(new Scene(erroreUI));
    stage.show();
    erroreKud.setLabel(pHerrialde);

  }
}
