package ma.emsi.donationms.Entity;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Data
public class OrganisationModel {
    private Long id;
    private String name;
    private String address;
    private String contact;
}