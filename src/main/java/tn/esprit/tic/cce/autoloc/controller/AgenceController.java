package tn.esprit.tic.cce.autoloc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.cce.autoloc.domain.Agence;
import tn.esprit.tic.cce.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{idAgence}")
    public ResponseEntity<Agence> getAgence(@PathVariable Long idAgence) {
        Agence agence = agenceService.retrieveAgence(idAgence);
        return agence == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(agence);
    }

    @PostMapping
    public Agence createAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{idAgence}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long idAgence, @RequestBody Agence agence) {
        if (agenceService.retrieveAgence(idAgence) == null) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(idAgence);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{idAgence}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long idAgence) {
        if (agenceService.retrieveAgence(idAgence) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(idAgence);
        return ResponseEntity.noContent().build();
    }
}
