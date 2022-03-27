package l3miage.Application;

import l3miage.model.Abonne;
import l3miage.model.Bornette;
import l3miage.model.Sexe;
import l3miage.model.Station;
import l3miage.repository.RepositoryFactory;
import l3miage.repository.api.*;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import l3miage.Application.Generation;
public class Utilisation {
    EntityManager entityManager;
    RepositoryFactory daoFactory;
    AbonneRepository abonneRepository;
    BornetteRepository bornetteRepository;
    DefinitionStationRepository definitionStationRepository;
    LocationRepository locationRepository;
    ModeleRepository modeleRepository;
    NonAbonneRepository nonAbonneRepository;
    StationRepository stationRepository;
    TrajetRepository trajetRepository;
    VeloRepository veloRepository;

    public Utilisation(EntityManager entityManager, RepositoryFactory daoFactory) {
        this.entityManager = entityManager;
        this.daoFactory = daoFactory;

        abonneRepository = daoFactory.newAbonneRepository(entityManager);
        bornetteRepository = daoFactory.newBornetteRepository(entityManager);
        definitionStationRepository = daoFactory.newDefinitionStationRepository(entityManager);
        modeleRepository = daoFactory.newModeleRepository(entityManager);
        nonAbonneRepository = daoFactory.newNonAbonneRepository(entityManager);
        stationRepository = daoFactory.newStationRepository(entityManager);
        trajetRepository = daoFactory.newTrajetRepository(entityManager);
        veloRepository = daoFactory.newVeloRepository(entityManager);
    }
    public Station affichageStations() {
        Scanner sc = new Scanner(System.in);
        List<Station> stations = stationRepository.getAll();
        int choix;
        do {
            int cpt = 0;

            System.out.println("Entrez le numéro de votre station");
            for (Station station : stations) {

                System.out.println("[" + cpt + "] Adresse : " + station.getAdresse());
                cpt++;
            }
            choix = sc.nextInt();
        } while (choix < 0 || choix >= stations.size());
        return stations.get(choix);
    }

    public void abonnement() {
        Scanner sc = new Scanner(System.in);
        String nom;
        String prenom;
        Sexe genre;
        Date datenaissance;
        Long numcb;
        String adresse;
        System.out.println("Bienvenue au programme d'abonnement, il vous permettra d'obtenir une réduction de 30% sur vos locations");
        System.out.println("Veuillez entrer votre nom");
        nom = sc.nextLine();
        System.out.println("Veuillez entrer votre prénom");
        prenom = sc.nextLine();
        System.out.println("Veuillez entrer votre genre (H/F)");
        if(sc.nextLine()=="M")
            genre = Sexe.homme;
        else
            genre = Sexe.femme;
        System.out.println("Veuillez entrer votre date de naissance (yyyy-mm-dd)");
        datenaissance = Date.valueOf(sc.nextLine());

        System.out.println("Veuillez entrer votre adresse");
        adresse = sc.nextLine();

        System.out.println("Veuillez entrer votre numéro de carte bancaire ");
        numcb = sc.nextLong();

        entityManager.getTransaction().begin();
        Abonne abonne = Generation.createAbonne(nom,prenom,numcb,genre);
        abonne.setDateN(datenaissance);
        abonne.setAdresse(adresse);
        abonneRepository.save(abonne);
        entityManager.getTransaction().commit();
        System.out.println("Date de début d'Abonnement");
        System.out.println(abonne.getDateDebutAb().toString());

        System.out.println("Voici votre code secret : ");
        System.out.println(abonne.getCodeSecret());


    }

    public void empruntVelo(Station station) {
        Scanner sc = new Scanner(System.in);
        List<Bornette> bornettes = bornetteRepository.getAllVeloOkByStationId(station.getId());
        int choix;
        do {
            int cpt = 0;

            System.out.println("Voici la liste des vélos disponibles");
            System.out.println("Entrez le numéro de la borne donc vous voulez récupérer le vélo");
            for (Bornette bornette : bornettes) {

                System.out.println("Bornette [" + cpt + "] - Velo : " + bornette.getVelo().getModele().getNom() + " - Prix : " + bornette.getVelo().getModele().getCoutHoraire() +"€/heure");
                cpt++;
            }
            choix = sc.nextInt();
        } while (choix < 0 || choix >= bornettes.size());
        System.out.println("Etes vous Abonne ?");

    }

    public void renduVelo(Station station) {
    }
}
