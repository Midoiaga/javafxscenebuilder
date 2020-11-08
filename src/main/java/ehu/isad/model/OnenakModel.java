package ehu.isad.model;

import javafx.scene.image.Image;

public class OnenakModel {
    private Image image;
    private String imagepath;
    private String herrialdea;
    private int puntuak;

    public OnenakModel(String imagepath, String herrialdea, int puntuak) {
        this.imagepath = imagepath;
        this.herrialdea = herrialdea;
        this.puntuak = puntuak;
        this.image=new Image(imagepath);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }
}
