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

package com.mastersoftwarelibre.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mastersoftwarelibre.rest.dtos.MessageDTO;

@Path("/helloworld")
public class HelloWorldService {

    @GET
    @Produces("application/xml")
    public MessageDTO getMessage() {
        return new MessageDTO("Hello World");
    }

    @POST
    @Consumes("application/xml")
    public void setMessage(MessageDTO messageDTO) {
        System.out.println("Storing message: " + messageDTO.content);
    }

}