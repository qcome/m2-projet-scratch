package fr.orleans.miage.iisi.evenementservice.init;

import fr.orleans.miage.iisi.evenementservice.domain.EvenementPerso;
import fr.orleans.miage.iisi.evenementservice.jsonwithjackson.EvenementJsonNode;
import fr.orleans.miage.iisi.evenementservice.service.EvenementAggloService;
import fr.orleans.miage.iisi.evenementservice.service.EvenementPersoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataEvenementsInit implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DataEvenementsInit.class);

    @Autowired
    EvenementAggloService evenementAggloService;

    @Autowired
    EvenementPersoService evenementPersoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //si aucun evenement dans la table "evenement"
        if(evenementAggloService.getFirstEvenement() == null){
            log.info("========IMPORT DES EVENEMENTS ORLEANS===========");
            EvenementJsonNode jsonNode = null;
            try {
                jsonNode = new EvenementJsonNode();
                evenementAggloService.insertEvenements(jsonNode.getAllEventsWithJsonNode());
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("========FIN IMPORT DES EVENEMENTS ORLEANS===========");
        }else{
            //updateEvenements();
        }

        EvenementPerso evenementPerso = new EvenementPerso(1L, "mon titre", "ma description", "mon adresse", "ma ville");
        List<Date[]> horaires= new ArrayList<>();
        horaires.add(new Date[]{new Date(), new Date()});
        evenementPerso.addHoraires(horaires);
        evenementPersoService.saveEvenementPerso(evenementPerso);

    }

    public void updateEvenements(){
        log.info("========MAJ DES EVENEMENTS ORLEANS===========");
        EvenementJsonNode jsonNode = null;
        try {
            jsonNode = new EvenementJsonNode();
           // evenementAggloService.updateEvenements(jsonNode.getLastEventsUpdatedWithJsonNode(new Date(System.currentTimeMillis()-24*60*60*1000*2)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("========FIN MAJ DES EVENEMENTS ORLEANS===========");
    }

}
