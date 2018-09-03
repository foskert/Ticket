package com.tickets.ing_yrj.tickets.Model;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public List<itemTicket> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readRecetasArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<itemTicket> readRecetasArray(JsonReader reader) throws IOException {
        ArrayList items = new ArrayList();
        reader.beginObject();
        while(reader.hasNext()){
            items.add(readItems(reader));
        }
        reader.endArray();
        return items;
    }

    public itemTicket readItems(JsonReader reader) throws IOException {
        String number = "";
        ArrayList<Ticket> ticket = null;
        System.out.println("array "+reader.toString());
       /* reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "number":
                    number = reader.nextString();
                    break;
                case "ticket":
                    reader.beginArray();
                    while(reader.hasNext()){
                        ticket.add(readTickets(reader));
                    }
                    reader.endArray();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();*/
        return new itemTicket(number, ticket);
    }
    public Ticket readTickets(JsonReader reader) throws IOException {
        String text_1 = null;
        String text_2 = null;
        String date_1 = null;
        String date_2 = null;
        String urlImg = null;
        int point = 0;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "text_1":
                    text_1 = reader.nextString();
                    break;
                case "text_2":
                    text_2 = reader.nextString();
                    break;
                case "date_1":
                    date_1 = reader.nextString();
                    break;
                case "date_2":
                    date_2 = reader.nextString();
                    break;
                case "urlImg":
                    urlImg = reader.nextString();
                    break;
                case "point":
                    point = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new Ticket(text_1, text_2, date_1, date_2, urlImg, point);
    }
}
