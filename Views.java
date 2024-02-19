import java.util.Scanner;

import entities.Bien;
import entities.Zone;
import services.BienManagementService;
import services.ZoneManagementService;

public class Main {

    private static ZoneManagementService zoneService = new ZoneManagementService();
    private static BienManagementService bienService = new BienManagementService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1. Ajouter une zone");
            System.out.println("2. Ajouter un bien");
            System.out.println("3. Afficher les zones");
            System.out.println("4. Afficher les biens");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ajouterZone(scanner);
                    break;
                case 2:
                    ajouterBien(scanner);
                    break;
                case 3:
                    afficherZones();
                    break;
                case 4:
                    afficherBiens();
                    break;
            }
        } while (choix != 0);

        scanner.close();
    }

    private static void ajouterZone(Scanner scanner) {
        System.out.print("Nom de la zone: ");
        scanner.nextLine(); // Pour consommer le saut de ligne
        Zone nouvelleZone = new Zone();
        zoneService.ajouterZone(nouvelleZone);
        System.out.println("Zone ajoutée avec succès.");
    }

    private static void ajouterBien(Scanner scanner) {
        System.out.print("Référence: ");
        System.out.print("Description: ");
        scanner.nextLine(); // Pour consommer le saut de ligne
        System.out.print("Prix: ");
        System.out.print("ID de la zone: ");
        int idZone = scanner.nextInt();
        Zone zone = zoneService.rechercherZoneParId(idZone);
        if (zone == null) {
            System.out.println("La zone spécifiée n'existe pas.");
            return;
        }
        Bien nouveauBien = new Bien();
        bienService.ajouterBien(nouveauBien);
        System.out.println("Bien ajouté avec succès.");
    }

    private static void afficherZones() {
        System.out.println("Liste des zones:");
        for (Zone zone : zoneService.listerZones()) {
            System.out.println(zone.getId() + ". " + zone.getNomZone());
        }
    }

    private static void afficherBiens() {
        System.out.println("Liste des biens:");
        for (Bien bien : bienService.listerBiens()) {
            System.out.println("ID: " + bien.getId());
            System.out.println("Référence: " + bien.getReference());
            System.out.println("Description: " + bien.getDescription());
            System.out.println("Prix: " + bien.getPrix());
            System.out.println("Zone: " + bien.getZone().getNomZone());
            System.out.println("---------------------------------");
        }
    }
}