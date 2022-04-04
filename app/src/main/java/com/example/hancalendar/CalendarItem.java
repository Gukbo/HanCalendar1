package com.example.hancalendar;

public class CalendarItem {

    private int dayValue; // dayValue라는 인자를 만들고 날짜 값을 받으려 한다.

    CalendarItem(int dayValue) {
        this.dayValue = dayValue;
    }

    public int getDay(){ // dayValue는 프라이빗하기 때문에 getDay로 리턴시킴
        return dayValue;
    }

}
