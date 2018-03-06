package jp.techacademy.shougo.katsura.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    public int getTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.TextView);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        int selectTime = hourOfDay * 100 + minute;
                        if ((selectTime >= 200 ) && (selectTime <= 959 )) {
                            textView.setText("おはよう");
                        } else if ((selectTime >= 1000) && (selectTime <= 1759)) {
                            textView.setText("こんにちは");
                        } else {
                            textView.setText("こんばんわ");
                        }
                    }
                },
                12,
                0,
                true);
        timePickerDialog.show();
    }


}
