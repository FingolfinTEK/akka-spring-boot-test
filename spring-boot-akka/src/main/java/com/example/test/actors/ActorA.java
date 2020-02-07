package com.example.test.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ActorA extends AbstractActor {

    public static Props props() {
        return Props.create(ActorA.class, ActorA::new);
    }

    @Override public Receive createReceive() {
        return receiveBuilder()
            .matchAny(msg -> sender().tell("A's reply to " + msg, self()))
            .build();
    }
}
