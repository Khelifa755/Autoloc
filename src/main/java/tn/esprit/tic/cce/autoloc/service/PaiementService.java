package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Paiement;
import tn.esprit.tic.cce.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
public class PaiementService implements IPaiementService {
    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> retrieveAllPaiements() { return paiementRepository.findAll(); }
    public Paiement addPaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public Paiement updatePaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public Paiement retrievePaiement(Long idPaiement) { return paiementRepository.findById(idPaiement).orElse(null); }
    public void removePaiement(Long idPaiement) { paiementRepository.deleteById(idPaiement); }
}
