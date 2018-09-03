package com.tickets.ing_yrj.tickets.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class itemTicket  implements Serializable {
    private String number;
    private ArrayList<Ticket> ticket;

    public itemTicket(String number, ArrayList<Ticket> ticket) {
        this.number = number;
        this.ticket = ticket;
    }
    public itemTicket() {
    }


    protected itemTicket(Parcel in) {
        number = in.readString();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(ArrayList<Ticket> ticket) {
        this.ticket = ticket;
    }
}
