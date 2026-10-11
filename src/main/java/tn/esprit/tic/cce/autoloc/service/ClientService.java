package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}
