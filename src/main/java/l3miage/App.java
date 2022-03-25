package l3miage;


import l3miage.model.*;
import l3miage.repository.*;
import l3miage.repository.api.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {

    static EntityManager entityManager =  Persistence.createEntityManagerFactory("APP").createEntityManager();
    protected static RepositoryFactory daoFactory = new RepositoryFactory();

    public static void main(String[] args) {

        try {
            /* Menu utilisateur */
            System.out.println("Bienvenue sur l'application VePick !");
            Scanner sc = new Scanner(System.in);
            int choix;

            do{
                System.out.println("Que souhaitez-vous faire ?");
                System.out.println("[1] Emprunter un velo");
                System.out.println("[2] Rendre un velo");
                System.out.println("[3] Vous abonner");
                System.out.println("[4] Programme Vplus");
                System.out.println("[5] Louer plusieurs vélos");
                System.out.println("[6] Voir l'état des stations");
                System.out.println("[7] Signaler"); // signaler l'état d'un vélo (vélo rendu ou non)
                System.out.println("[8] retirer un velo");

                Bornette bornette = new Bornette();
                choix = sc.nextInt();
                switch(choix){
                    case 1:
                        System.out.flush();
                        empruntVelo();
                        break;

                    case 2:
                        System.out.flush();
                        rendreVelo();
                    case 4:
                        System.out.flush();
                        progVplus();
                        break;

                    case 5:
                        System.out.flush();
                        louerPlusieursVelos();
                        break;

                    case 6:
                        System.out.flush();
                        etatStation();
                        break;

                    case 7:
                        System.out.flush();
                        signaler();
                        break;
                    case 8:
                        System.out.flush();
                        //BornetteRepository bornetteRepository =  daoFactory.newBornetteRepository(entityManager);
                        //ArrayList<Bornette> li =  (ArrayList<Bornette>) bornetteRepository.getAll();
                        retraitVelo(bornette);
                        break;

                    default:
                        System.out.flush();
                        break;

                }
            }while(choix != 0);
            sc.close(); // fermeture du scanner
            //TheConnection.close();
            System.out.println("bye.");





        } catch (Exception e) {
            //TODO: handle exception
        }

    }

    private static void retraitVelo(Bornette bornette) {
        BornetteRepository bornetteRepository =  daoFactory.newBornetteRepository(entityManager);
        bornetteRepository.retraitVeloBornette(bornette.getId());

    }

    private static void signaler() {

    }

    private static void etatStation() {
    }

    private static void louerPlusieursVelos() {
    }

    private static void progVplus() {
    }

    private static void sAbonner() {
    }

    private static void rendreVelo() {
    }

    private static void empruntVelo() {
    }
}
