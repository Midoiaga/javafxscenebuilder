package ehu.isad.model;

import javafx.scene.image.Image;

public class OrdezkapenModel {
    private Image image;
    private String imagePath;
    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    public OrdezkapenModel(String pHerrialde, String pAbestia, String pArtista, String imagePath) {
        this.herrialdea = pHerrialde;
        this.abestia = pAbestia;
        this.artista= pArtista;
        this.puntuak=0;
        this.image = new Image(imagePath);
    }
}
