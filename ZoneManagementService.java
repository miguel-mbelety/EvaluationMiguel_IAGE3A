package services;

import java.util.ArrayList;
import java.util.List;

import entities.Zone;

public class ZoneManagementService {
    private List<Zone> zones;

    public ZoneManagementService() {
        this.zones = new ArrayList<>();
    }

    public void ajouterZone(Zone zone) {
        zones.add(zone);
    }

    public void supprimerZone(Zone zone) {
        zones.remove(zone);
    }

    public List<Zone> listerZones() {
        return zones;
    }

    public Zone rechercherZoneParId(int id) {
        for (Zone zone : zones) {
            if (zone.getId() == id) {
                return zone;
            }
        }
        return null; // Retourne null si aucune zone avec cet identifiant n'est trouvée
    }

}
