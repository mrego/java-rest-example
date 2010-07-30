package com.mastersoftwarelibre.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloWorldService {

    @GET
    @Produces("text/plain")
    public String getMessage() {
        return "Hello World";
    }
}
