package com.example.papricacookhousebot.repositories;

import com.example.papricacookhousebot.objects.ChatState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatStateRepository extends JpaRepository<ChatState, Long> {

    ChatState findStateByChatId(Long chatId);

}
