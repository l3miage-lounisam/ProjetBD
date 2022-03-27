package l3miage.Application;
import com.github.javafaker.Faker;
import l3miage.model.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;


// Cette classe permet de générer tout ce que nous avons besoin pour que notre application fonctionne 
public class Generation {
    private static final Faker FAKER = Faker.instance(new Random(74));

    // Créer une station
    public static Station createStation() {
        Station station = new Station();
                station.setAdresse(FAKER.address().streetAddress());
        return station;
    }

    // Créer une bornette
    public static Bornette createBornette(Station station,Velo velo) {
       Bornette bornette = new Bornette();
       bornette.setStation(station);
       if(velo !=null)
           bornette.setVelo(velo);
       return bornette;
    }

    // Créer un vélo
    public static Velo createVelo(Modele modele) {
        Velo velo = new Velo();
        velo.setModele(modele);
        return velo;
    }
    
    // Créer un modèle de vélo
    public static Modele createModele(String nom,Float prix) {
        Modele modele = new Modele();
        modele.setNom(nom);
        modele.setCoutHoraire(prix);

        return modele;
    }
    
    // Créer une location pour un non abonné
    public static Location createLocationNonAbonne(NonAbonne nonAbonne) {
        Location location = new Location();
        location.setNonAbonne(nonAbonne);


        return location;
    }
    
    // Créer une location pour un abonné
    public static Location createLocationAbonne(Abonne abonne) {
        Location location = new Location();
        location.setAbonne(abonne);

        return location;
    }

    // Créer une trajet 
    public static Trajet createTrajet(Location location, Station stationDepart) {
        Trajet trajet = new Trajet();
        trajet.setStationDepart(stationDepart);
        return trajet;
    }
    
    // Créer une définition pour une station
    public static DefinitionStation createDefinitionStation(Station station, Integer heure, Definition definition) {
        DefinitionStation definitionStation = new DefinitionStation();
        definitionStation.setStation(station);
        definitionStation.setHeure(heure);
        definitionStation.setDefStation(definition);
    return definitionStation;
    }

    // Créer un abonné
    public static Abonne createAbonne(String nom,String prenom,Long cb,Sexe sexe) {
        Abonne abonne = new Abonne();
        abonne.setNom(nom);
        abonne.setPrenom(prenom);
        abonne.setAdresse(FAKER.address().streetAddress());
        abonne.setNumeroCB(cb);
        abonne.setSexe(sexe);

        return abonne;
    }
}
