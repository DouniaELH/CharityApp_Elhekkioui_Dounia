package ma.emsi.organisationms.Controller;


import ma.emsi.organisationms.Entity.Organisation;
import ma.emsi.organisationms.Service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @GetMapping("/listOrganisations")
    public List<Organisation> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }

    @PostMapping("/createOrganisation")
    public Organisation createOrganisation(@RequestBody Organisation organisation) {
        return organisationService.createOrganisation(organisation);
    }
    @GetMapping("/getOrganisationById/{id}")
    public Organisation getOrganisation(@PathVariable Long id){
        return organisationService.findOrganisationById(id);
    }

    @PutMapping("/updateOrganisation")
    public Organisation updateOrganisation(@RequestBody Organisation organisation) {
        return organisationService.updateOrganisation(organisation);
    }

    @DeleteMapping("/deleteOrganisation")
    public void deleteOrganisation(@RequestParam("id") Long id) {
        organisationService.deleteOrganisation(id);
    }


}
