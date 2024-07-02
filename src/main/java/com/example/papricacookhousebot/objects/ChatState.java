package com.example.papricacookhousebot.objects;

import com.example.papricacookhousebot.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatState {

    @Id
    private Long chatId;

    @Enumerated(EnumType.STRING)
    private Status status;

}
