package org.acme;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.resteasy.reactive.RestQuery;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

  @GET
  @Transactional
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@RestQuery final String name) {
    Greeting greeting = new Greeting();
    greeting.name = name;
    greeting.persist();
    return "Hello %s".formatted(name);
  }

  @GET
  @Path("names")
  @Produces(MediaType.TEXT_PLAIN)
  public String names() {
    final List<Greeting> greetings = Greeting.listAll();
    final String names = greetings.stream().map(g -> g.name).collect(Collectors.joining(", "));
    return "I've said hello to: %s".formatted(names);
  }
}
