package com.example.user.a4_datepickerdialogexam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.user.a4_datepickerdialogexam.helper.DateTimeHelper;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    Button button,button2;
    int HOUR = 0, MINUTE =0;
    int YEAR = 0, MONTH = 0, DAY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        int [] time = DateTimeHelper.getInstance().getTime();
        int[] date = DateTimeHelper.getInstance().getDate();
        HOUR = time[0];
        MINUTE = time[1];
        YEAR = date[0];
        MONTH = date[1];
        DAY = date[2];

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showDatePickerDialog();
                break;
            case R.id.button2:
                showTimePickerDialog();
                break;
        }
    }

    public void showTimePickerDialog(){
        final int temp_hh =HOUR;
        final int temp_mi =MINUTE;

        TimePickerDialog dialog = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                HOUR = hourOfDay;
                MINUTE = minute;

                button2.setText(HOUR + "시" + MINUTE + "분 ");
            }

        }, HOUR,MINUTE,false);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog) {
                HOUR = temp_hh;
                MINUTE = temp_mi;

            }
        });

        dialog.setTitle("시간 선택");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("약속시간을 선택하세요");

        dialog.show();
    }

    public void showDatePickerDialog(){
        final int temp_yy =YEAR;
        final int temp_mm =MONTH;
        final int temp_dd =DAY;

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                YEAR = year;
                MONTH = monthOfYear +1;
                DAY = dayOfMonth;
                button.setText(YEAR + "년" + MONTH + "월" + DAY + "일");
            }
        },YEAR,MONTH - 1,DAY);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog) {
                YEAR = temp_yy;
                MONTH = temp_mm;
                DAY = temp_dd;
            }
        });

        dialog.setTitle("날짜 선택");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("생일을 선택하세요");

        dialog.show();
    }
}
