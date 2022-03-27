package l3miage.Application;

import l3miage.model.*;
import l3miage.repository.RepositoryFactory;
import l3miage.repository.api.*;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
        locationRepository = daoFactory.newLocationRepository(entityManager);
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
        if(Objects.equals(sc.nextLine().toLowerCase(Locale.ROOT), "h"))
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
//Fonction qui permet d'emprunter un velo dans une station donnée

    public void empruntVelo(Station station) {
        Abonne abonne;
        NonAbonne nonAbonne;
        Integer codesecret;
        Trajet trajet;
        Location location;
        String abo;
        Scanner sc = new Scanner(System.in);
        List<Bornette> bornettes = bornetteRepository.getAllVeloOkByStationId(station.getId());
        int choix;
        do {
            int cpt = 0;

            System.out.println("Voici la liste des vélos disponibles");
            System.out.println("Entrez le numéro de la borne dont vous voulez récupérer le vélo");
            for (Bornette bornette : bornettes) {

                System.out.println("Bornette [" + cpt + "] - Velo : " + bornette.getVelo().getModele().getNom() + " - Prix : " + bornette.getVelo().getModele().getCoutHoraire() +"€/heure");
                cpt++;
            }
            choix = sc.nextInt();
        } while (choix < 0 || choix >= bornettes.size());
        System.out.println("Etes vous Abonne ?(Y/N)");
        Scanner sc2 = new Scanner(System.in);
        abo = sc2.nextLine();
        if (Objects.equals(abo, "Y")){
            int cpt2=0;
            do {
                System.out.println("Veuillez entrer votre code secret");
                codesecret = sc.nextInt();
                abonne = abonneRepository.findAbonneByCodeSecret(codesecret);
                cpt2++;
            }while(abonne==null&&cpt2<3);
            if(abonne==null)
                System.out.println("Code secret incorrect");
            else{

               Velo velo =  bornetteRepository.retraitVeloBornette(bornettes.get(choix).getId());

                entityManager.getTransaction().begin();

                location = Generation.createLocationAbonne(abonne);
                trajet = Generation.createTrajet(station,velo);
               location.addTrajet(trajet);
               locationRepository.save(location);
                trajetRepository.save(trajet);
                entityManager.getTransaction().commit();

                System.out.println("Vous avez retiré un velo de type " + velo.getModele().getNom());

            }

        }
        else{
            System.out.println("Veuillez entrer votre numéro de carte bancaire ");
            nonAbonne =  Generation.createNonAbonne(sc.nextLong());
            Velo velo =  bornetteRepository.retraitVeloBornette(bornettes.get(choix).getId()); //Retrait du velo à la bornette

            entityManager.getTransaction().begin();
            nonAbonneRepository.save(nonAbonne);
            location = Generation.createLocationNonAbonne(nonAbonne);
            trajet = Generation.createTrajet(station,velo);
            location.addTrajet(trajet);
            locationRepository.save(location);
            trajetRepository.save(trajet);
            entityManager.getTransaction().commit();

            System.out.println("Vous avez retiré un velo de type " + velo.getModele().getNom());
            System.out.println("Voici votre code secret " + nonAbonne.getCodeSecret());

        }

    }
//Fonction qui permet de rendre un velo dans une station donnée
    public void renduVelo(Station station) {
        Abonne abonne;
        NonAbonne nonAbonne;
        Integer codesecret;
        Trajet trajet;
        Location location;
        String abo;
        Velo velo;
        Scanner sc = new Scanner(System.in);
        List<Bornette> bornettes = bornetteRepository.getAllBornetteVideByStationId(station.getId()); // On affiche toutes les bornettes vides où on peut rendre un velo
        int choix;
        do {
            int cpt = 0;

            System.out.println("Voici la liste des bornettes vide");
            System.out.println("Entrez le numéro de la borne où vous voulez rendre votre vélo");
            for (Bornette bornette : bornettes) {

                System.out.println("Bornette [" + cpt + "]");
                cpt++;
            }
            choix = sc.nextInt();
        } while (choix < 0 || choix >= bornettes.size());
        System.out.println("Etes vous Abonne ?(Y/N)");
        Scanner sc2 = new Scanner(System.in);
        abo = sc2.nextLine();
        if (Objects.equals(abo, "Y")){
            int cpt2=0;
            do {
                System.out.println("Veuillez entrer votre code secret");
                codesecret = sc.nextInt();
                abonne = abonneRepository.findAbonneByCodeSecret(codesecret);
                cpt2++;
            }while(abonne==null&&cpt2<3);
            if(abonne==null)
                System.out.println("Code secret incorrect");
            else{
                location = locationRepository.findLocationNonTermineByAbonneCodeSecret(codesecret);
                trajet = location.trajets.get(0);
                 velo = trajet.getVelo();
                System.out.println("Le vélo était-il en bon état ? (Y/N)");
                if(Objects.equals(sc.nextLine().toLowerCase(Locale.ROOT), "y"))
                    velo.setEtat(Etat.ok);
                else
                   velo.setEtat(Etat.hs);
                bornetteRepository.renduVeloBornette(trajet.getVelo(),bornettes.get(choix).getId());

                location.trajets.remove(trajet);

                trajet.setStationArrive(station);
                location.addTrajet(trajet);
                location.calculPrix();

                entityManager.getTransaction().begin();
                veloRepository.save(velo);
                locationRepository.save(location);
                trajetRepository.save(trajet);
                entityManager.getTransaction().commit();
                System.out.println("Vous avez rendu le velo n°" + trajet.getVelo().getId() + " de type : "+trajet.getVelo().getModele().getNom());
                System.out.println("Vous avez bénéficié d'une reduction de 30% car vous êtes abonné");
                System.out.println("Vous avez été débité de : " + location.getPrix()*0.7+"€");
                System.out.println("Pour le trajet de : " + trajet.stationDepart.getAdresse() + " à : " +trajet.stationArrive.getAdresse());
                System.out.println("D'une durée de : " +location.getDureeLoc());
            }

        }
        else{
            int cpt2=0;
            do {
                System.out.println("Veuillez entrer votre code secret");
                codesecret = sc.nextInt();
                nonAbonne = nonAbonneRepository.findNonAbonneByCodeSecret(codesecret);
                cpt2++;
            }while(nonAbonne==null&&cpt2<3);
            if(nonAbonne==null)
                System.out.println("Code secret incorrect");
            else{
                location = locationRepository.findLocationNonTermineByNonAbonneCodeSecret(codesecret);
                trajet = location.trajets.get(0);
                velo = trajet.getVelo();
                System.out.println("Le vélo était-il en bon état ? (Y/N)");
                if(Objects.equals(sc.nextLine().toLowerCase(Locale.ROOT), "y"))
                    velo.setEtat(Etat.ok);
                else
                    velo.setEtat(Etat.hs);
                bornetteRepository.renduVeloBornette(trajet.getVelo(),bornettes.get(choix).getId());

                location.trajets.remove(trajet);

                trajet.setStationArrive(station);
                location.addTrajet(trajet);
                location.calculPrix();

                entityManager.getTransaction().begin();
                veloRepository.save(velo);
                locationRepository.save(location);
                trajetRepository.save(trajet);
                entityManager.getTransaction().commit();
                System.out.println("Vous avez rendu le velo n°" + trajet.getVelo().getId() + " de type : "+trajet.getVelo().getModele().getNom());
                System.out.println("Vous avez été débité de : " + location.getPrix()+"€");
                System.out.println("Pour le trajet de : " + trajet.stationDepart.getAdresse() + " à : " +trajet.stationArrive.getAdresse());
                System.out.println("D'une durée de : " +location.getDureeLoc());
            }

        }
    }
}
