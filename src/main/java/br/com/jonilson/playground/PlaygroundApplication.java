package br.com.jonilson.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class PlaygroundApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@Override
	public void run(String... args) {
		redisTemplate.opsForValue().set("myKey", "myValue");
		System.out.println("Value from redis: " + redisTemplate.opsForValue().get("myKey"));
	}
}
