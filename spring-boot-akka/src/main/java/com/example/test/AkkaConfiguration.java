package com.example.test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.example.test.actors.ActorA;
import com.example.test.actors.ActorB;
import com.example.test.configuration.ActorSystemProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ActorSystemProperties.class)
public class AkkaConfiguration {
    
    private final ActorSystemProperties properties;

    public AkkaConfiguration(ActorSystemProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ActorSystem actorSystem() {
        return ActorSystem.create(properties.getActorSystemName());
    }
    
    @Bean
    public ActorRef actorA() {
        return actorSystem().actorOf(ActorA.props());
    }

    @Bean
    public ActorRef actorB(ActorRef actorA) {
        return actorSystem().actorOf(ActorB.props(actorA));
    }
}
