package tn.esprit.tic.cce.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.cce.autoloc.domain.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNomAndPrenom(String nom, String prenom);
}
