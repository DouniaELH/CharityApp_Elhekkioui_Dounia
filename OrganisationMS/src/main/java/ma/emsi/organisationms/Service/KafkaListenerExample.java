package ma.emsi.organisationms.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class KafkaListenerExample {

    @KafkaListener(topics = "topic-donation", groupId = "organisation-consumer-group")
    public void listener(String donationMessage) {
        log.info("Received message: {}", donationMessage);
        if (donationMessage == null || donationMessage.isEmpty()) {
            log.warn("Received an empty or null message!");
        }
    }
}
