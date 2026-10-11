package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> retrieveAllReservations() { return reservationRepository.findAll(); }
    public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation updateReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation retrieveReservation(Long idReservation) { return reservationRepository.findById(idReservation).orElse(null); }
    public void removeReservation(Long idReservation) { reservationRepository.deleteById(idReservation); }
}
