package com.SpringBootKafka.DemoSpringBootKafkaConsumer.config;

import com.SpringBootKafka.DemoSpringBootKafkaConsumer.model.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

// Configuration class for Kafka consumer
@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {

    // Use your server's IP address or hostname for connecting to server
    public final String bootstrapServers = "127.0.0.1:9092";

    /**
     * Bean used to create a KafkaConsumer object.
     * @return DefaultKafkaConsumerFactory object.
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        // Group-ID for String messages
        final String groupIdKafkaStr = "kafka_example_group_string";

        // Create a Map of properties for the consumer and populate it with the required properties
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdKafkaStr);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }

    /**
     * The consumerFactory is injected to this Bean
     * @return containerFactory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(consumerFactory());
        return containerFactory;
    }

    @Bean
    public ConsumerFactory<String, User> userConsumerFactory() {

        // Group-ID for JSON messages
        final String groupIdKafkaJson = "kafka_example_group_json";

        // Create a Map of properties for the consumer and populate it with the required properties
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdKafkaJson);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(User.class));
    }

    /**
     * The userConsumerFactory is injected to this Bean
     * @return userContainerFactory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> userContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        userContainerFactory.setConsumerFactory(userConsumerFactory());
        return userContainerFactory;
    }
}
