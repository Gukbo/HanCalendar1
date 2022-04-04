package com.example.hancalendar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView monthView;
    TextView monthText;
    MonthAdapter adt;
    CalendarItem cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 액티비티를 생성하는 OnCreate함수
        setContentView(R.layout.activity_main);

        monthView = findViewById(R.id.monthView); // xml에서 설정된 뷰들을 가져오는 메소드인 findviewbyid
        adt = new MonthAdapter(this);
        monthView.setAdapter(adt);

        monthText = findViewById(R.id.monthText);
        setMonthText();

        Button monthPrevious = findViewById(R.id.monthPrevious); // 이전버튼에 동적인 역할을 부여하기 위해 가져옴
        Button monthNext = findViewById(R.id.monthNext); // 다음버튼에 동적인 역할을 부여하기 위해 가져옴

        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adt.setPreviousMonth();
                adt.notifyDataSetChanged(); // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용됨.
                setMonthText();
            }
        });

        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adt.setNextMonth();
                adt.notifyDataSetChanged();
                setMonthText();
            }
        });

        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"" + adt.toast_year() + "." + adt.toast_month() + "."  ,Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void setMonthText(){ // 텍스트뷰에 설정된 년도와 월을 출력하는 것.
        int curYear = adt.getCurYear();
        int curMonth = adt.getCurMonth();
        monthText.setText(curYear+"년 "+(curMonth+1)+"월"); // 이게 양식이다.
    }


}