package com.example.test.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorB extends AbstractActor {

    private final ActorRef actorA;

    public ActorB(final ActorRef actorA) {
        this.actorA = actorA;
    }

    public static Props props(ActorRef actorA) {
        return Props.create(ActorB.class, () -> new ActorB(actorA));
    }

    @Override public Receive createReceive() {
        return receiveBuilder()
            .matchAny(msg -> actorA.tell(msg, sender()))
            .build();
    }
}
