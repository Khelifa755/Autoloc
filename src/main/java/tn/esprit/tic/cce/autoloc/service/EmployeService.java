package tn.esprit.tic.cce.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Employe;
import tn.esprit.tic.cce.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeService implements IEmployeService {
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> retrieveAllEmployes() { return employeRepository.findAll(); }
    public Employe addEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe updateEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe retrieveEmploye(Long idEmploye) { return employeRepository.findById(idEmploye).orElse(null); }
    public void removeEmploye(Long idEmploye) { employeRepository.deleteById(idEmploye); }
}
