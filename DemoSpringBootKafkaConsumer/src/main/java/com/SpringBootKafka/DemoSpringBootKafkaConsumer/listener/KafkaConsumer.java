package com.SpringBootKafka.DemoSpringBootKafkaConsumer.listener;

import com.SpringBootKafka.DemoSpringBootKafkaConsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka_example_topic", groupId = "kafka_example_group_string")
    public void consume(String message) {
        System.out.println("Consumer Text Message : " + message);
    }

    @KafkaListener(topics = "kafka_example_topic_json", groupId = "kafka_example_group_json", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumer JSON Message : " + user);
    }
}
