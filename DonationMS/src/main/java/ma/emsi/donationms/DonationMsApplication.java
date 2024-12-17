package ma.emsi.donationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DonationMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonationMsApplication.class, args);
    }

}
