package ma.emsi.organisationms.Service;


import ma.emsi.organisationms.Entity.Organisation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganisationService {
    public List<Organisation> getAllOrganisations();
    public Organisation createOrganisation(Organisation organisation);
    public Organisation updateOrganisation(Organisation organisation);
    public void deleteOrganisation(Long id);
    public Organisation findOrganisationById(Long id);

}
