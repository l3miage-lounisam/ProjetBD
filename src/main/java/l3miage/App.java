package l3miage;


import l3miage.Application.Generation;
import l3miage.Application.Utilisation;
import l3miage.model.*;
import l3miage.repository.*;
import l3miage.repository.api.*;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static l3miage.Application.Generation.setup;

//class main application
public class App {

    static EntityManager entityManager =  Persistence.createEntityManagerFactory("APP").createEntityManager();
    protected static RepositoryFactory daoFactory = new RepositoryFactory();
    static Utilisation utilisation = new Utilisation(entityManager,daoFactory);
    public static void main(String[] args) {

      try {
            /* Menu utilisateur */
            Station station;
            System.out.println("Bienvenue sur l'application VePick !");
            Scanner sc = new Scanner(System.in);
            int choix;
            do{
                System.out.println("Que souhaitez-vous faire ?");
                System.out.println("[1] Choisir une station");
                System.out.println("[2] S'abonner au service ");
                System.out.println("[3] Setup");
                System.out.println("[4] Quitter");
                choix = sc.nextInt();
                switch(choix){
                    case 1:
                        System.out.flush();
                        station = utilisation.affichageStations();
                        System.out.flush();
                        System.out.println("Que souhaitez-vous faire ?");
                        System.out.println("[1] Emprunter un velo");
                        System.out.println("[2] Rendre un velo");
                        switch (sc.nextInt()){
                            case 1:
                                utilisation.empruntVelo(station);
                                break;
                            case 2:
                                utilisation.renduVelo(station);
                                break;
                        }
                        break;

                    case 2:
                        System.out.flush();
                        utilisation.abonnement();
                        break;
                    case 3:
                        System.out.flush();
                        setup(entityManager,daoFactory);
                }
            }while(choix!=4);




            System.out.println("bye.");





        } catch (Exception e) {
            //TODO: handle exception
        }

    }


}
