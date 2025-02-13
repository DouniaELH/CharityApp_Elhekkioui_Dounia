package ma.emsi.donationms;

import ma.emsi.donationms.Entity.Donation;
import ma.emsi.donationms.Entity.OrganisationModel;
import ma.emsi.donationms.Entity.UserModel;
import ma.emsi.donationms.Repo.DonationRepo;
import ma.emsi.donationms.Service.OrganisationModelRestClient;
import ma.emsi.donationms.Service.UserModelRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DonationMsApplication implements CommandLineRunner {

    @Autowired
    UserModelRestClient usrRest;
    @Autowired
    DonationRepo donationRepo;
    @Autowired
    OrganisationModelRestClient orgRest;
    public static void main(String[] args) {

        SpringApplication.run(DonationMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserModel user = usrRest.getUserById(1);
        OrganisationModel orga = orgRest.getOrganisationById(2);
        Donation donation = donationRepo.save(Donation.builder()
                .userId(user.getId())
                .organisationId(orga.getId())
                .amount(200.0)
                .org(orga)
                .usr(user)
                .build());
    }
}
