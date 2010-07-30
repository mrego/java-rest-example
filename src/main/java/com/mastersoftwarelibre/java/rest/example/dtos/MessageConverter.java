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

package com.mastersoftwarelibre.java.rest.example.dtos;

import java.util.ArrayList;
import java.util.List;

import com.mastersoftwarelibre.java.rest.example.entities.Message;

public class MessageConverter {

    public static MessageDTO toDTO(Message message) {
        return new MessageDTO(message.getContent());
    }

    public static MessageListDTO toDTO(List<Message> messages) {
        List<MessageDTO> messageDTOs = new ArrayList<MessageDTO>();
        for (Message message : messages) {
            messageDTOs.add(new MessageDTO(message.getContent()));
        }
        return new MessageListDTO(messageDTOs);
    }

    public static Message toEntity(MessageDTO messageDTO) {
        return new Message(messageDTO.content);
    }

}