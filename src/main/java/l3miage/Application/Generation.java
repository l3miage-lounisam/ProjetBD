package l3miage.Application;
import com.github.javafaker.Faker;
import l3miage.model.*;
import l3miage.repository.RepositoryFactory;
import l3miage.repository.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
       bornette.setEtat(Etat.ok);
       if(velo !=null)
           bornette.setVelo(velo);
       return bornette;
    }
    // Créer un vélo

    public static Velo createVelo(Modele modele) {
        Random random = new Random();
        Velo velo = new Velo();
        velo.setModele(modele);
        velo.setDateMiseService(FAKER.date().between(Date.valueOf("2015-01-01"),Date.valueOf("2022-01-01")));
        if(random.nextInt(10)==2)
            velo.setEtat(Etat.hs);
        else
            velo.setEtat(Etat.ok);
        velo.setPuce(FAKER.code().asin());
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

    public static Trajet createTrajet(Station stationDepart,Velo velo) {
        Trajet trajet = new Trajet();
        trajet.setStationDepart(stationDepart);
        trajet.setVelo(velo);
        return trajet;
    }
    // Créer une définition(vplus-vmoins) pour une station

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

    //crée un nonabonne
    public static NonAbonne createNonAbonne(Long cb) {
        NonAbonne nonAbonne = new NonAbonne();

        nonAbonne.setNumeroCB(cb);

        return nonAbonne;
    }

    public static void setup(EntityManager entityManager, RepositoryFactory daoFactory){
        AbonneRepository abonneRepository;
        BornetteRepository bornetteRepository;
        DefinitionStationRepository definitionStationRepository;
        LocationRepository locationRepository;
        ModeleRepository modeleRepository;
        NonAbonneRepository nonAbonneRepository;
        StationRepository stationRepository;
        TrajetRepository trajetRepository;
        VeloRepository veloRepository;
        abonneRepository = daoFactory.newAbonneRepository(entityManager);
        bornetteRepository = daoFactory.newBornetteRepository(entityManager);
        definitionStationRepository = daoFactory.newDefinitionStationRepository(entityManager);
        modeleRepository = daoFactory.newModeleRepository(entityManager);
        nonAbonneRepository = daoFactory.newNonAbonneRepository(entityManager);
        stationRepository = daoFactory.newStationRepository(entityManager);
        trajetRepository = daoFactory.newTrajetRepository(entityManager);
        veloRepository = daoFactory.newVeloRepository(entityManager);

        entityManager.getTransaction().begin();

        Modele m1 = createModele("VTT",1F);
        Modele m2 = createModele("Piste",1.2F);
        Modele m3 = createModele("Enfant",0.5F);
        Modele m4 = createModele("Electrique",2F);

        modeleRepository.save(m1);
        modeleRepository.save(m2);
        modeleRepository.save(m3);
        modeleRepository.save(m4);

        List<Modele> modeles = new ArrayList();
        modeles.add(m1);
        modeles.add(m2);
        modeles.add(m3);
        modeles.add(m4);

        Random random = new Random();
        Bornette bornette;
        Velo velo;
      /*  for (int i = 0; i < 12; i++) {
            veloRepository.save(velo);
        }*/
        for (int i = 0; i < 4; i++) {
           Station station = createStation();
           stationRepository.save(station);
            for (int j = 0; j < 8; j++) {
                velo = createVelo(modeles.get(random.nextInt(4)));
                if(j<6)
                 bornette = createBornette(station,velo);
                else
                    bornette = createBornette(station,null);

                veloRepository.save(velo);
                bornetteRepository.save(bornette);
            }
        }

        entityManager.getTransaction().commit();
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
}
