package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    EmployeRepository employeRepository;
    AgenceRepository agenceRepository;

    @Override
    public List<Employe> retrieveAllEmployees() {
        return employeRepository.findAll();
    }
    
    @Override
    public Employe retrieveEmployee(Long employeeId) {
        return employeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public Employe addEmployee(Employe employee) {
        return employeRepository.save(employee);
    }
    @Override 
    public void removeEmployee(Long employeeId) {
        employeRepository.deleteById(employeeId);
    }

    @Override
    public Employe modifyEmployee(Employe employee) {
        return employeRepository.save(employee);
    }
    @Override
    public Employe affecterAgenceEmployee(Long idEmployee, Long idAgence) {
        //DONNEES 
        Employe employe = employeRepository.findById(idEmployee).orElse(null);
        Agence agence = agenceRepository.findById(idAgence).orElse(null);
        // Affectation
       assert employe != null;
       employe.setAgence(agence);
        //save 
        return employeRepository.save(employe);
    }

 }
