package org.lucifer.cloud.stream.server.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.lucifer.cloud.stream.common.model.User;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author lucifer
 * @since 2023/10/19
 */
@Slf4j
@Service
public class UserService {

    private final StreamBridge streamBridge;

    public UserService(final StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void saveUser(final User user) {
        log.info("send message: {}", user);
        streamBridge.send("user-1", MessageBuilder.withPayload(user).build());
    }
}
