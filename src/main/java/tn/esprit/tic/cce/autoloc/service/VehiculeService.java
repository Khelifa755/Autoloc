package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import tn.esprit.tic.cce.autoloc.domain.Equipement;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.repository.EquipementRepository;
import tn.esprit.tic.cce.autoloc.repository.VehiculeRepository;
import tn.esprit.tic.cce.autoloc.web.dto.VehiculeDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository, EquipementRepository equipementRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.equipementRepository = equipementRepository;
    }

    public List<Vehicule> retrieveAllVehicules() { return vehiculeRepository.findAll(); }
    public Vehicule addVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule updateVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule retrieveVehicule(Long idVehicule) { return vehiculeRepository.findById(idVehicule).orElse(null); }
    public void removeVehicule(Long idVehicule) { vehiculeRepository.deleteById(idVehicule); }

    @Override
    @Transactional
    public VehiculeDTO affecterVehiculeAEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }
        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }

        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return new VehiculeDTO(
                savedVehicule.getImmatriculation(),
                savedVehicule.getMarque(),
                savedVehicule.getModele(),
                savedVehicule.getCategorie(),
                savedVehicule.getTarifJournalier(),
                savedVehicule.getStatut()
        );
    }
}
