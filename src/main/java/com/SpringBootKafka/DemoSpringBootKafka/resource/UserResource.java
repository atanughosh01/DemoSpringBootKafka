package com.SpringBootKafka.DemoSpringBootKafka.resource;

import com.SpringBootKafka.DemoSpringBootKafka.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Class for publishing messages to Kafka-Broker
@RestController
@RequestMapping("kafka")
public class UserResource {

    /**
     * The UserResource has a dependency on a KafkaTemplate
     * Like we use RestTemplate for calling REST APIs,
     * we use KafkaTemplate for communicating with Kafka-Broker
     */
    private final KafkaTemplate<String, User> kafkaTemplate;

    /**
     * A Constructor so that the Spring container can inject a KafkaTemplate object.
     * Constructor Injection has been used instead of Field injection (@AutoWired) here
     * because the KafkaTemplate is a Spring Bean declared in the KafkaConfiguration Class.
     * @see <a href="https://bit.ly/3MYGrDR">How_To_Avoid_Field_Injection</a> 
     * to know more about avoiding field injection and using constructor injection.
     */
    public UserResource(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Declare the constant topic name
    private static final String TOPIC = "kafka_example_topic";

    /**
     * This method is used to publish a message to Kafka-Broker.
     * @param name has to be typed in the URL as a path variable.
     * @return String message indicating the success of the operation.
     */
    @GetMapping("/publish/{name}")
    public String post(@PathVariable(value="name") final String name) {

        // String name = "Mark Zuckerberg";
        String dept = "Technology";
        Long salary = 15000000L;

        // Publish the message to the Kafka-broker
        kafkaTemplate.send(TOPIC, new User(name, dept, salary));

        // After publishing, return success-message
        return "Message Published Successfully!!";
    }
}
