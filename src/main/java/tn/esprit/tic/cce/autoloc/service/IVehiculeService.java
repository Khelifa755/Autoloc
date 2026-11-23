package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.web.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Vehicule vehicule);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    VehiculeDTO affecterVehiculeAEquipement(Long idVehicule, Long idEquipement);
}
