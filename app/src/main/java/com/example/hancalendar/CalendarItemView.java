package com.example.hancalendar;

import static android.graphics.Color.WHITE;
import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
// 본문에는 import android.support.v7.app.AppCompatActivity; 였는데 오류가 생겨서 대체했습니다.
// 찾아보니 아티팩트의 버전이 달라서 생긴 문제였습니다.
import android.util.AttributeSet;
import android.view.Gravity;
import android.webkit.WebHistoryItem;

public class CalendarItemView extends AppCompatTextView{

    private CalendarItem item;

    public CalendarItemView(Context context) {
        super(context);
        init();
    }

    public CalendarItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() { // 바탕의 색을 하얗게 초기화시키는 내용입니다.
        setBackgroundColor(Color.WHITE);
    }

    public CalendarItem getItem() {
        return item;
    }

    public void setItem(CalendarItem item) {
        this.item = item;

        int day = item.getDay();           // 날짜를 받아옴
        if (day != 0) {                    // 받아온 날짜가 0이 아니라면
            setText(String.valueOf(day));  // 받아온 날짜를 텍스트로 설정
            setGravity(Gravity.CENTER);    // 텍스트를 중앙 정렬
            setTextColor(Color.BLACK);     // 텍스트 색깔을 검정색으로 설정
            setTextSize(20);               // 텍스트 크기를 20으로 설정
        } else {                           // 받아온 날짜가 0이면
            setText("");                   // 텍스트를 빈칸으로 설정
        }
    }
}
