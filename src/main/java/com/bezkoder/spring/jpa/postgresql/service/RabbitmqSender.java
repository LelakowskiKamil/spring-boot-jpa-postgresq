package pl.lelakowski.spring.jpa.postgresql.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitmqSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }
}
