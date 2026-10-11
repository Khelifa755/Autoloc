package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> retrieveAllVehicules() { return vehiculeRepository.findAll(); }
    public Vehicule addVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule updateVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule retrieveVehicule(Long idVehicule) { return vehiculeRepository.findById(idVehicule).orElse(null); }
    public void removeVehicule(Long idVehicule) { vehiculeRepository.deleteById(idVehicule); }
}
