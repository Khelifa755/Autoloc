package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Equipement;
import tn.esprit.tic.cce.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
public class EquipementService implements IEquipementService {
    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    public List<Equipement> retrieveAllEquipements() { return equipementRepository.findAll(); }
    public Equipement addEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement updateEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement retrieveEquipement(Long idEquipement) { return equipementRepository.findById(idEquipement).orElse(null); }
    public void removeEquipement(Long idEquipement) { equipementRepository.deleteById(idEquipement); }
}
