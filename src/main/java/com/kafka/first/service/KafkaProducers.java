package com.kafka.first.service;

import com.kafka.first.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducers {
    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    @PostConstruct
    public void function () {

        UserDTO userDTO = UserDTO.builder()
                    .firstName("Adrian")
                    .lastName("Croitoru")
                    .id(3131)
                    .CNP("1234567891234")
                    .email("adrian.croitoru@transiris.com")
                .build();

        kafkaTemplate.send("test_topic", userDTO);
    }
}
