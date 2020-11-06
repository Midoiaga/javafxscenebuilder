package ehu.isad.controller.db;

import ehu.isad.model.OrdezkapenModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdezkapenDBKud {
    // singleton patroia

    private static OrdezkapenDBKud instantzia = new OrdezkapenDBKud();

    public static OrdezkapenDBKud getInstantzia() {
        return instantzia;
    }


    private OrdezkapenDBKud() {

    }

    public List<OrdezkapenModel> ordezkpaenakLortu() {

        List<OrdezkapenModel> emaitza = new ArrayList<>();
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

        String query = "SELECT o.artista,o.herrialdea,o.abestia, h.bandera FROM Ordezkaritza o,Herrialde h WHERE urtea=2019 AND o.herrialdea=h.izena";
        ResultSet rs = dbkud.execSQL(query);

        try {
            while (rs.next()) {

                String artista = rs.getString("artista");
                String herrialdea = rs.getString("herrialdea");
                String abestia = rs.getString("abestia");
                String argazkia = rs.getString("bandera");

                OrdezkapenModel ordez = new OrdezkapenModel(herrialdea,abestia,artista,"irudiak/"+argazkia+".png");
                emaitza.add(ordez);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }
}