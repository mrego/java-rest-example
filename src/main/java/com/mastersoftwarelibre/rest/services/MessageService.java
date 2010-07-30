package com.mastersoftwarelibre.rest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mastersoftwarelibre.rest.dtos.MessageConverter;
import com.mastersoftwarelibre.rest.dtos.MessageDTO;
import com.mastersoftwarelibre.rest.dtos.MessageListDTO;
import com.mastersoftwarelibre.rest.entities.Message;

@Path("/messages/")
public class MessageService {

    private static List<Message> messages = new ArrayList<Message>(
            Arrays.asList(new Message("First message"), new Message(
                    "Second message")));

    @GET
    @Produces("application/xml")
    public MessageListDTO getMessages() {
        return MessageConverter.toDTO(messages);
    }

    @POST
    @Consumes("application/xml")
    public void addMessage(MessageDTO messageDTO) {
        Message entity = MessageConverter.toEntity(messageDTO);
        messages.add(entity);
    }

}