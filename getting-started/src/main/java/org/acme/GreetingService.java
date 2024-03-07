package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(final String name) {
        return "Hello %s".formatted(name);
    }
    
}
