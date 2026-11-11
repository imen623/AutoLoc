package tn.esprit.autoloc.control;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.EmployeeService;
import tn.esprit.autoloc.service.VehiculeService;
import java.util.List;

@Tag(name = "Autoloc API - employee Management")



@RestController
@AllArgsConstructor
@RequestMapping("/employee")

public class EmployeeControler {

    EmployeeService employeeService;


    @Operation(description = "Recuperer tous les employes")
    @GetMapping("/retrieve-all-employees")
    public List<Employe> retrieveAllEmployees() {
        return employeeService.retrieveAllEmployees();
    }

    @Operation(description = "Recuperer un employe par son identifiant")
    @GetMapping("/retrieve-employee/{employee-id}")
    public Employe retrieveEmployee(@PathVariable("employee-id") Long employeeId) {
        return employeeService.retrieveEmployee(employeeId);
    }

    @Operation(description = "Ajouter un employe")
    @PostMapping("/add-employee")
    public Employe addEmployee(@RequestBody Employe employee) {
        return employeeService.addEmployee(employee);
    }

    @Operation(description = "Supprimer un employe")
    @DeleteMapping("/remove-employee/{employee-id}")
    public void removeEmployee(@PathVariable("employee-id") Long employeeId) {
        employeeService.removeEmployee(employeeId);
    }

    @Operation(description = "Modifier un employe")
    @PutMapping("/modify-employee")
    public Employe modifyEmployee(@RequestBody Employe employee) {
        return employeeService.modifyEmployee(employee);
    }

    @Operation(description = "Affecter une agence a un employe")
    @PutMapping("/affecterAgenceEmployee/{idEmployee}/{idAgence}")
    public Employe affecterAgenceEmployee(@PathVariable("idEmployee") Long idEmployee, @PathVariable("idAgence") Long idAgence) {
        return employeeService.affecterAgenceEmployee(idEmployee, idAgence);

    }



}
