package fr.orleans.miage.iisi.evenementservice.domain;


import javax.persistence.Embeddable;

@Embeddable
public class Coordonnees {
    private Float lat;
    private Float lng;

    public Coordonnees() {
    }

    public Coordonnees(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}
