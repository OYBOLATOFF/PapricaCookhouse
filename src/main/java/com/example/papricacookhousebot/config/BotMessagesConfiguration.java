package com.example.papricacookhousebot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("bot-messages.properties")
public class BotMessagesConfiguration {

    public static String AUTHORIZATION_SUCCESSFUL;

    public static String AUTHORIZATION_NOT_SUCCESSFUL;

    public static String SOMETHING_WENT_WRONG;

    @Value("${AUTHORIZATION.SUCCESSFUL}")
    public void setAuthorizationSuccessful(String authorizationSuccessful) {
        AUTHORIZATION_SUCCESSFUL = authorizationSuccessful;
    }

    @Value("${AUTHORIZATION.NOT_SUCCESSFUL}")
    public void setAuthorizationNotSuccessful(String authorizationNotSuccessful) {
        AUTHORIZATION_NOT_SUCCESSFUL = authorizationNotSuccessful;
    }

    @Value("${SOMETHING_WENT_WRONG}")
    public void setSomethingWentWrong(String somethingWentWrong) {
        SOMETHING_WENT_WRONG = somethingWentWrong;
    }
}
