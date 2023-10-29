package pl.lelakowski.spring.jpa.postgresql.controller;

import pl.lelakowski.spring.jpa.postgresql.service.RabbitmqSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rabbitmq")
@AllArgsConstructor
public class RabbitmqController {

    private RabbitmqSender rabbitmqSender;

    @PostMapping(value = "/queue/{queue}")
    public void sendJsonEventToTopic(@PathVariable("queue") String queue,
                                     @RequestBody String payload) {
        rabbitmqSender.send(queue, payload);
    }

}