package com.tickets.ing_yrj.tickets.Model;

public class Ticket {
    private String text_1;
    private String text_2;
    private String date_1;
    private String date_2;
    private String urlImg;
    private int point;

    public Ticket(String text_1, String text_2, String date_1, String date_2, String urlImg, int point) {
        this.text_1 = text_1;
        this.text_2 = text_2;
        this.date_1 = date_1;
        this.date_2 = date_2;
        this.urlImg = urlImg;
        this.point = point;
    }
    public Ticket() {
    }

    public String getText_1() {
        return text_1;
    }

    public void setText_1(String text_1) {
        this.text_1 = text_1;
    }

    public String getText_2() {
        return text_2;
    }

    public void setText_2(String text_2) {
        this.text_2 = text_2;
    }

    public String getDate_1() {
        return date_1;
    }

    public void setDate_1(String date_1) {
        this.date_1 = date_1;
    }

    public String getDate_2() {
        return date_2;
    }

    public void setDate_2(String date_2) {
        this.date_2 = date_2;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "text_1='" + text_1 + '\'' +
                ", text_2='" + text_2 + '\'' +
                ", date_1='" + date_1 + '\'' +
                ", date_2='" + date_2 + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", point=" + point +
                '}';
    }
}
