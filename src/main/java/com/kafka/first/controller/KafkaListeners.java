package com.kafka.first.controller;

import com.kafka.first.dto.UserDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Slf4j
@Validated
public class KafkaListeners {

    @KafkaListener(topics = "test_topic", groupId = "test_group", containerFactory = "factory")
    public void listener(@Valid UserDTO data) {
        log.info("\n\n" + "A valid user profile has been received!\n" + data + "\n\n");
    }
}
