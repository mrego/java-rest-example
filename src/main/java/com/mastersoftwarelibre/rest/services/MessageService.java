package com.mastersoftwarelibre.rest.services;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mastersoftwarelibre.rest.MessageDTO;
import com.mastersoftwarelibre.rest.MessageListDTO;

@Path("/messages/")
public class MessageService {

    private static List<MessageDTO> messages = Arrays.asList(new MessageDTO(
            "First message"),
            new MessageDTO("Second message"));

    @GET
    @Produces("application/xml")
    public MessageListDTO getMessages() {
        return new MessageListDTO(messages);
    }

}