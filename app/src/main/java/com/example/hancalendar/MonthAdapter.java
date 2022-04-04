package com.example.hancalendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MonthAdapter extends BaseAdapter {
    Calendar cal;

    Context mContext;

    CalendarItem[] items; // 년도와 월을 입력받기 위해 멤버로 가진다.
    int curYear;
    int curMonth;

    MonthAdapter(Context context){
        super();
        mContext = context;
        init();
    }

    MonthAdapter(Context context, AttributeSet attrs){
        super();
        mContext = context;
        init();
    }

    public void init(){ // 초기화 해주기.
        cal = Calendar.getInstance(); //Calendar 객체 가져오기
        items = new CalendarItem[7*6]; // 배열은 7행에 6열로 받아옴

        calculate();// 객체를 가져와서 날짜등을 계산하기위해 사용
    }

    public void calculate(){ //
        for(int i=0; i<items.length; i++){ // 배열을 초기화함.
            items[i] = new CalendarItem(0);
        }

        cal.set(Calendar.DAY_OF_MONTH, 1); // 월의 시작일을 1로

        int startDay = cal.get(Calendar.DAY_OF_WEEK); //현재 달 1일의 요일 (1: 일요일, . . . 7: 토요일)
        int lastDay = cal.getActualMaximum(Calendar.DATE); //달의 마지막 날짜

        int cnt = 1;
        for(int i=startDay-1; i<startDay-1+lastDay; i++){ // 각 시작위치와 마지막 날을 계산하여 지정
            items[i] = new CalendarItem(cnt);
            cnt++;
        }

        curYear = cal.get(Calendar.YEAR); // 현재 년도와 달을 받음.
        curMonth = cal.get(Calendar.MONTH);
    }

    public void setPreviousMonth(){ // 이전 달을 계산하는 함수
        cal.add(Calendar.MONTH, -1);
        calculate();
    }

    public void setNextMonth(){
        cal.add(Calendar.MONTH, 1); //다음 달을 계산하는 함수
        calculate();
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CalendarItemView view = new CalendarItemView(mContext);
        CalendarItem item = items[position]; // 포지션은 요일에 몇번째인지 알려줌.
        view.setItem(item);

        if(position%7==0){ // 일요일이면 빨간색
            view.setTextColor(Color.RED);
        }

        if(position%7==6){ // 토요일이면 파란색
            view.setTextColor(Color.BLUE);
        }

        GridView.LayoutParams params = new GridView.LayoutParams( GridView.LayoutParams.MATCH_PARENT,150);
        view.setLayoutParams(params);

        return view;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int getCurYear(){
        return curYear;
    }

    public int getCurMonth(){
        return curMonth;
    }

    public int toast_year() { return curYear; }

    public int toast_month() { return curMonth+1; }

}
