package com.SpringBootKafka.DemoSpringBootKafka.config;

import com.SpringBootKafka.DemoSpringBootKafka.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

// Configuration class for Kafka producer
@Configuration
public class KafkaConfiguration {

    /**
     * Bean used to create a KafkaProducer object.
     * @return DefaultKafkaProducerFactory object.
     */
    @Bean
    public ProducerFactory<String, User> producerFactory() {

        // Use your server's IP address or hostname for connecting to server
        final String bootstrapServers = "127.0.0.1:9092";

        // Create a Map of properties for the producer and populate it with the required properties
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }


    /**
     * Like we use RestTemplate for calling REST APIs,
     * we use KafkaTemplate for communicating with Kafka-Broker
     * The producerFactory is injected to this Bean
     * @return KafkaTemplate object.
     */
    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
