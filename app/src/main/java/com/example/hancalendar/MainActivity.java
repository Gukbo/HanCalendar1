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
        super.onCreate(savedInstanceState);     // 액티비티를 생성하는 OnCreate 함수
        setContentView(R.layout.activity_main); // activity_main.xml 파일을 가상 디바이스에 표시

        monthView = findViewById(R.id.monthView); // id를 바탕으로 화면 레이아웃에 정의된 GridView 객체 로딩
        adt = new MonthAdapter(this);     // adt 객체 생성
        monthView.setAdapter(adt);                // adt 객체를 GridView 객체에 연결

        monthText = findViewById(R.id.monthText); // activity_main.xml에 정의된 View객체 중에서 id가 monthText인 것을 찾아 반환함
        setMonthText();

        Button monthPrevious = findViewById(R.id.monthPrevious); // activity_main.xml에 정의된 View객체 중에서 id가 monthPrevious인 것을 찾아 반환함
        Button monthNext = findViewById(R.id.monthNext);         // activity_main.xml에 정의된 View객체 중에서 id가 monthNext인 것을 찾아 반환함

        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 이전 버튼이 눌리면
                adt.setPreviousMonth();     // 달을 이전 달로 바꾸고
                adt.notifyDataSetChanged(); // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용됨.
                setMonthText();             // 바뀐 달을 타이틀로 세팅
            }
        });

        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    // 다음 버튼이 눌리면
                adt.setNextMonth();          // 달을 다음 달로 바꾸고
                adt.notifyDataSetChanged();  // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용됨.
                setMonthText();              // 바뀐 달을 타이틀로 세팅
            }
        });

        // 달력 클릭 이벤트를 처리하는 메소드 정의
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