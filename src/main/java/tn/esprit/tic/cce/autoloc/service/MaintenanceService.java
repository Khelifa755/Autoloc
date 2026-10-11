package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Maintenance;
import tn.esprit.tic.cce.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> retrieveAllMaintenances() { return maintenanceRepository.findAll(); }
    public Maintenance addMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Maintenance updateMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Maintenance retrieveMaintenance(Long idMaintenance) { return maintenanceRepository.findById(idMaintenance).orElse(null); }
    public void removeMaintenance(Long idMaintenance) { maintenanceRepository.deleteById(idMaintenance); }
}
