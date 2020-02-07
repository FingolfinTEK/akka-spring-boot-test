package com.example.test.configuration;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties
public class ActorSystemProperties {

    /**
     * The name of the {@link akka.actor.ActorSystem} of our application.
     */
    @NotBlank
    private String actorSystemName;

    /**
     * The name of our root actor created in the {@link akka.actor.ActorSystem}
     */
    @NotBlank
    private String rootActorName;

    /**
     * The Akka remoting port we'll use to form Akka Clusters. Defaults to 55001.
     */
    @Range(min = 1024, max = 65535)
    private int remotePort = 55001;

    public String getActorSystemName() {
        return actorSystemName;
    }

    public void setActorSystemName(final String actorSystemName) {
        this.actorSystemName = actorSystemName;
    }

    public String getRootActorName() {
        return rootActorName;
    }

    public void setRootActorName(final String rootActorName) {
        this.rootActorName = rootActorName;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(final int remotePort) {
        this.remotePort = remotePort;
    }
}
