package pl.lelakowski.spring.jpa.postgresql.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class KafkaTopicsDto {

    private Set<String> topics;

}