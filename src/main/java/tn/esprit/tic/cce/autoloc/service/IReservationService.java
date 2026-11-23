package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.web.dto.ReservationResponseDTO;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    Reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    ReservationResponseDTO affecterReservationAClient(Long idReservation, String nom, String prenom);
}
