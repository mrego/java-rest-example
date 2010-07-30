package com.mastersoftwarelibre.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mastersoftwarelibre.rest.MessageDTO;

@Path("/helloworld")
public class HelloWorldService {

    @GET
    @Produces("application/xml")
    public MessageDTO getMessage() {
        return new MessageDTO("Hello World");
    }

}