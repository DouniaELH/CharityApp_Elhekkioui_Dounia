package ma.emsi.donationms.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import ma.emsi.donationms.Entity.Donation;
import ma.emsi.donationms.Repo.DonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DonationServiceImp implements DonationService {
    @Autowired
    private DonationRepo donationRepo;
    @Autowired
    private UserModelRestClient userModelRestClient;
    @Autowired
    private OrganisationModelRestClient organisationModelRestClient;

    @Override
    public List<Donation> getAllDonations() {
        return donationRepo.findAll().stream()
                .map(donation -> {
                    if (donation.getUserId() != null) {
                        donation.setUsr(userModelRestClient.getUserById(donation.getUserId()));
                    }
                    if (donation.getOrganisationId() != null) {
                        donation.setOrg(organisationModelRestClient.getOrganisationById(donation.getOrganisationId()));
                    }
                    return donation;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Donation createDonation(Donation donation) {
        return donationRepo.save(donation);
    }


    @Override
    public Donation updateDonation(Donation donation) {
        return donationRepo.save(donation);
    }

    @Override
    public void deleteDonation(Long id) {
        donationRepo.deleteById(id);
    }
}
