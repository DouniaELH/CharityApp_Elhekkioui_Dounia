package ma.emsi.organisationms.Service;

import ma.emsi.organisationms.Entity.Organisation;
import ma.emsi.organisationms.Repos.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImp implements OrganisationService{

    @Autowired
    private OrganisationRepo organisationRepo;

    @Override
    public List<Organisation> getAllOrganisations() {
        return organisationRepo.findAll();
    }
    @Override
    public Organisation createOrganisation(Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    @Override
    public Organisation updateOrganisation(Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    @Override
    public void deleteOrganisation(Long id) {
        organisationRepo.deleteById(id);
    }

    @Override
    public Organisation findOrganisationById(Long id) {
        return organisationRepo.findById(id).get();
    }
}
