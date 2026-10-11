package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Contrat;
import tn.esprit.tic.cce.autoloc.repository.ContratRepository;

import java.util.List;

@Service
public class ContratService implements IContratService {
    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public List<Contrat> retrieveAllContrats() { return contratRepository.findAll(); }
    public Contrat addContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat updateContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat retrieveContrat(Long idContrat) { return contratRepository.findById(idContrat).orElse(null); }
    public void removeContrat(Long idContrat) { contratRepository.deleteById(idContrat); }
}
