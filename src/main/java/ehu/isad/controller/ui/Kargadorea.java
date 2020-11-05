package ehu.isad.controller.ui;

import javafx.scene.Parent;

public class Kargadorea {

    Parent p;
    Kudeatzaile k;

    public Parent getP() {
        return p;
    }

    public void setP(Parent p) {
        this.p = p;
    }

    public Kudeatzaile getK() {
        return k;
    }

    public void setK(Kudeatzaile k) {
        this.k = k;
    }

    public Kargadorea(Parent p, Kudeatzaile k) {
        this.p = p;
        this.k = k;
    }
}
