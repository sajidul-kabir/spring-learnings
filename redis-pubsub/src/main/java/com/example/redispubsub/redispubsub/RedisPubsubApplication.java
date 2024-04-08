package com.example.redispubsub.redispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class RedisPubsubApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx=SpringApplication.run(RedisPubsubApplication.class, args);
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		AppleMessageSubscriber receiver = ctx.getBean(AppleMessageSubscriber.class);


		System.out.println("Sending message...");
		AppleEvent appleEvent=new AppleEvent();
		appleEvent.setProduct("rfl");
		appleEvent.setMessage("message");
			template.convertAndSend("apple-events", appleEvent);
			Thread.sleep(500L);


		System.exit(0);
	}

}
