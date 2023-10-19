package org.lucifer.cloud.stream.server.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.lucifer.cloud.stream.common.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author lucifer
 * @since 2023/10/19
 */
@Slf4j
@Configuration
public class StreamConfig {

    @Bean
    public Function<Message<User>, Message<User>> processName() {
        return message -> {
            final User user = message.getPayload();
            log.info("function message: {}", user);
            user.setName("process:" + user.getName());
            return MessageBuilder.withPayload(user).build();
        };
    }

    @Bean
    public Consumer<Message<User>> userConsumer() {
        return message -> {
            final User user = message.getPayload();
            log.info("consumer message: {}", user);
        };
    }

}
