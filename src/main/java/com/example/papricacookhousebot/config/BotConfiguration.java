package com.example.papricacookhousebot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("application.properties")
public class BotConfiguration {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.api.key}")
    private String botToken;

}
