package ma.emsi.donationms.Controller;

import ma.emsi.donationms.Entity.Donation;
import ma.emsi.donationms.Entity.OrganisationModel;
import ma.emsi.donationms.Entity.UserModel;
import ma.emsi.donationms.Service.DonationService;
import ma.emsi.donationms.Service.KafkaSender;
import ma.emsi.donationms.Service.OrganisationModelRestClient;
import ma.emsi.donationms.Service.UserModelRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonationController {
    @Autowired
    private DonationService donationService;

    @Autowired
    private KafkaSender kafkaSenderService;

    @Autowired
    private UserModelRestClient userModelRestClient;

    @Autowired
    private OrganisationModelRestClient organisationRestClient;


    @GetMapping("/listDonations")
    public List<Donation> getAllDonations() {

        return donationService.getAllDonations();
    }

    @PostMapping("/createDonation")
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.createDonation(donation);
    }

    @PutMapping("/updateDonation")
    public Donation updateDonation(@RequestBody Donation donation) {
        return donationService.updateDonation(donation);
    }

    @DeleteMapping("/deleteDonation")
    public void deleteDonation(@RequestParam("id") Long id) {
        donationService.deleteDonation(id);
    }

    @PostMapping("/{donationId}/notify")
    public String notifyDonation(@PathVariable Long donationId, @RequestBody String message) {
        kafkaSenderService.sendMessage(message, "topic-donation");
        return "Message sent to Kafka topic for donation ID: " + donationId;
    }

    @GetMapping("/testFeign/{userId}")
    public UserModel testFeign(@PathVariable long userId) {
        return userModelRestClient.getUserById(userId);
    }

    @GetMapping("/testFeignOrganisation/{organisationId}")
    public OrganisationModel testFeignOrganisation(@PathVariable long organisationId) {
        return organisationRestClient.getOrganisationById(organisationId);
    }



}
