package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    List<Paiement> retrieveAllPaiements();
    Paiement addPaiement(Paiement paiement);
    Paiement updatePaiement(Paiement paiement);
    Paiement retrievePaiement(Long idPaiement);
    void removePaiement(Long idPaiement);
}
