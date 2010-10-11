/*
 * This file is part of Java REST example
 *
 * Copyright (C) 2010 Manuel Rego Casasnovas <mrego@igalia.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mastersoftwarelibre.java.rest.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastersoftwarelibre.java.rest.example.dtos.ExceptionDTO;
import com.mastersoftwarelibre.java.rest.example.dtos.MessageConverter;
import com.mastersoftwarelibre.java.rest.example.dtos.MessageDTO;
import com.mastersoftwarelibre.java.rest.example.dtos.MessageListDTO;
import com.mastersoftwarelibre.java.rest.example.entities.Message;

@Path("/messages/")
@Component
@Scope("request")
public class MessageService {

    private static List<Message> messages = new ArrayList<Message>(
            Arrays.asList(new Message("First message"), new Message(
                    "Second message")));

    @GET
    @Produces("application/xml")
    public MessageListDTO getMessages() {
        return MessageConverter.toDTO(messages);
    }

    @GET
    @Produces("application/xml")
    @Path("/{index}")
    public Response getMessage(@PathParam("index") int index) {
        try {
            return Response.status(Status.OK).entity(
                    MessageConverter.toDTO(messages.get(index))).build();
        } catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND)
                    .entity(new ExceptionDTO(e)).build();
        }
    }

    @POST
    @Consumes("application/xml")
    public Response addMessage(MessageDTO messageDTO) {
        Message entity = MessageConverter.toEntity(messageDTO);
        messages.add(entity);
        return Response.status(Status.OK).build();
    }

    @PUT
    @Consumes("application/xml")
    @Path("/{index}")
    public Response updateMessage(@PathParam("index") int index,
            MessageDTO messageDTO) {
        try {
            messages.set(index, MessageConverter.toEntity(messageDTO));
            return Response.status(Status.OK).build();
        } catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND)
                    .entity(new ExceptionDTO(e)).build();
        }
    }

    @DELETE
    @Produces("application/xml")
    @Path("/{index}")
    public Response removeMessage(@PathParam("index") int index) {
        try {
            MessageDTO messageDTO = MessageConverter.toDTO(messages.get(index));
            messages.remove(index);
            return Response.status(Status.OK).entity(messageDTO).build();
        } catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND)
                    .entity(new ExceptionDTO(e)).build();
        }
    }

}