package ma.emsi.organisationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrganisationMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganisationMsApplication.class, args);
    }

}
