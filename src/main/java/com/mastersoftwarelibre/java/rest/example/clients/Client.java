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

package com.mastersoftwarelibre.java.rest.example.clients;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Client {

    public static void main(String[] args) {
        try {
            URL u = new URL(
                    "http://localhost:8080/java-rest-example/rest/helloworld/");
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();

            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = docBuilder.parse(uc.getInputStream());

            System.out.println(doc.getDocumentElement().getFirstChild()
                    .getFirstChild().getNodeValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}