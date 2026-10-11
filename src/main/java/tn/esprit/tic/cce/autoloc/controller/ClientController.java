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
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Client> getClient(@PathVariable Long idClient) {
        Client client = clientService.retrieveClient(idClient);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{idClient}")
    public ResponseEntity<Client> updateClient(@PathVariable Long idClient, @RequestBody Client client) {
        if (clientService.retrieveClient(idClient) == null) {
            return ResponseEntity.notFound().build();
        }
        client.setIdClient(idClient);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient) {
        if (clientService.retrieveClient(idClient) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(idClient);
        return ResponseEntity.noContent().build();
    }
}
