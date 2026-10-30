package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Employe;
import java.util.List;


public interface EmployeeService {

public List<Employe> retrieveAllEmployees();  
public Employe retrieveEmployee(Long employeeId);  
public Employe addEmployee(Employe employee);
public void removeEmployee(Long employeeId);  
public Employe modifyEmployee(Employe employee);


}
