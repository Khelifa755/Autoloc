package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.repository.ClientRepository;
import tn.esprit.tic.cce.autoloc.repository.ReservationRepository;
import tn.esprit.tic.cce.autoloc.web.dto.ReservationResponseDTO;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }

    public List<Reservation> retrieveAllReservations() { return reservationRepository.findAll(); }
    public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation updateReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation retrieveReservation(Long idReservation) { return reservationRepository.findById(idReservation).orElse(null); }
    public void removeReservation(Long idReservation) { reservationRepository.deleteById(idReservation); }

    @Override
    @Transactional
    public ReservationResponseDTO affecterReservationAClient(Long idReservation, String nom, String prenom) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Réservation introuvable : " + idReservation));
        Client client = clientRepository.findByNomAndPrenom(nom, prenom)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + prenom + " " + nom));

        reservation.setClient(client);
        Reservation savedReservation = reservationRepository.save(reservation);

        return new ReservationResponseDTO(
                savedReservation.getIdReservation(),
                savedReservation.getDateDebut(),
                savedReservation.getDateFin(),
                savedReservation.getStatut(),
                client.getNom(),
                client.getPrenom()
        );
    }
}
