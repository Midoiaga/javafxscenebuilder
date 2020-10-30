package ehu.isad;

import ehu.isad.controller.ui.ErroreKud;
import ehu.isad.controller.ui.NagusiaKud;
import ehu.isad.controller.ui.HerrialdeakKud;
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


  private Stage stage;

  private NagusiaKud nagusiaKud;
  private HerrialdeakKud herrialdeakKud;
  private ErroreKud erroreKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(nagusiaUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

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
