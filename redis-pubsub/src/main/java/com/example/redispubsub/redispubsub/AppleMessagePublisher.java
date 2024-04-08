package com.example.redispubsub.redispubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class AppleMessagePublisher {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;


    public Long publish(AppleEvent appleEvent){

        System.out.println("Sending message Sync: {} "+ appleEvent);
        return redisTemplate.convertAndSend(channelTopic.getTopic(), appleEvent);
    }
}
