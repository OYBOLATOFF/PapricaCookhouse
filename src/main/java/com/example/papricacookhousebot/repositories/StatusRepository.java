package com.example.papricacookhousebot.repositories;

import com.example.papricacookhousebot.objects.ChatState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<ChatState, Integer> {

    @Query(value = "SELECT * FROM status", nativeQuery = true)
    List<List<String>> findAllStatusesAndHandlers();

}
