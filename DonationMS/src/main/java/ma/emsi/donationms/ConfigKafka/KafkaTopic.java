package ma.emsi.donationms.ConfigKafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic donationTopic() {
        return TopicBuilder.name("donation-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
}