package com.example.redispubsub.redispubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AppleMessageSubscriber implements MessageListener {

    private  ObjectMapper objectMapper ;



    @Override
    public void onMessage(Message message, byte[] pattern) {

        try {
            System.out.println("New message received: {} "+ message);
            AppleEvent orderEvent = objectMapper.readValue(message.getBody(), AppleEvent.class);
            //Use the order event as necessary
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
