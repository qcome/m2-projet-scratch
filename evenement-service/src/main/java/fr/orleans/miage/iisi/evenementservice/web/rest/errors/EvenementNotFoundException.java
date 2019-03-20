package fr.orleans.miage.iisi.evenementservice.web.rest.errors;

public class EvenementNotFoundException extends RuntimeException{
    public EvenementNotFoundException(Long id) {
        super("Evenement " + id + " non trouvé");
    }
}
