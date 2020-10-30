package ehu.isad.controller.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BozkaketaDBKud {

    // singleton patroia

    private static BozkaketaDBKud instantzia = new BozkaketaDBKud();

    public static BozkaketaDBKud getInstantzia() {
        return instantzia;}

    private BozkaketaDBKud() {
        }

        public String lortuBozkatua (String pHerrialde) {

            String emaitza="";
            DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

            String query = "select bandera from Bozkaketa b,Herrialde h WHERE b.bozkatuDu='"+pHerrialde+"' AND b.urtea=2019 AND b.bozkatuDu=h.izena ";
            ResultSet rs = dbkud.execSQL(query);

            try {
                if (rs.next()) {

                    emaitza = rs.getString("bandera");

                }
            } catch (SQLException e) {
                System.err.println(e);
            }


            return emaitza;
        }
    }
