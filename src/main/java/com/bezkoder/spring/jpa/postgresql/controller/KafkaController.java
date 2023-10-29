package pl.lelakowski.spring.jpa.postgresql.controller;

import pl.lelakowski.spring.jpa.postgresql.controller.dto.KafkaTopicsDto;
import pl.lelakowski.spring.jpa.postgresql.service.KafkaService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/kafka")
@Validated
@AllArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;

    @GetMapping("/topics")
    public KafkaTopicsDto getTopics() throws RuntimeException {
        return new KafkaTopicsDto(kafkaService.getKafkaTopics());
    }

    @PostMapping(value = "/topic/{topicName}", consumes = APPLICATION_JSON_VALUE)
    public void sendJsonEventToTopic(@PathVariable("topicName") String topicName,
                                     @RequestHeader(name = "key") String key,
                                     @RequestBody String payload) {
        kafkaService.sendEventToTopic(topicName, key, payload);
    }

}