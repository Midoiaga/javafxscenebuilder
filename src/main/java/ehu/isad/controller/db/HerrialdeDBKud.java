package ehu.isad.controller.db;

import ehu.isad.model.Ezarpena;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeDBKud {

  // singleton patroia

  private static HerrialdeDBKud instantzia = new HerrialdeDBKud();

  public static HerrialdeDBKud getInstantzia() {
    return instantzia;
  }


  private HerrialdeDBKud() {
  }

  public List<String> lortuHerrialdeak() {

    List<String> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select izena from ParteHartzea WHERE etorrikoDa='Bai' AND urtea=2019";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String herriIzen = rs.getString("izena");
        emaitza.add(herriIzen);
      }
    } catch (SQLException e) {
      System.err.println(e);
    }


    return emaitza;
  }
}
