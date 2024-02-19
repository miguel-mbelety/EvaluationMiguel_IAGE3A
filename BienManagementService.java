package services;

import java.util.ArrayList;
import java.util.List;

import entities.Bien;

public class BienManagementService {
    private List<Bien> biens;

    public BienManagementService() {
        this.biens = new ArrayList<>();
    }

    public void ajouterBien(Bien bien) {
        biens.add(bien);
    }

    public void supprimerBien(Bien bien) {
        biens.remove(bien);
    }

    public List<Bien> listerBiens() {
        return biens;
    }

    public Bien rechercherBienParId(int id) {
        for (Bien bien : biens) {
            if (bien.getId() == id) {
                return bien;
            }
        }
        return null; // Retourne null si aucun bien avec cet identifiant n'est trouvé
    }

}