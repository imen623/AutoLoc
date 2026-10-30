package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public List<Client> retrieveAllClients() {
        return repository.findAll();
    }

    @Override
    public Client retrieveClient(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Client addClient(Client entity) {
        return repository.save(entity);
    }

    @Override
    public void removeClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Client modifyClient(Client entity) {
        return repository.save(entity);
    }
}
