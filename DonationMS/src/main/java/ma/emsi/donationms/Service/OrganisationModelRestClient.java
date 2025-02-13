package ma.emsi.donationms.Service;

import ma.emsi.donationms.Entity.OrganisationModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("OrganisationMS")
public interface OrganisationModelRestClient {
    @GetMapping("/organisations/getOrganisationById/{id}")
    OrganisationModel getOrganisationById(@PathVariable long id);
}