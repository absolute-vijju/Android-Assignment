package com.example.dialogs_demo;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {


    Button btndate, btntime, btncustom;
    Calendar cal = Calendar.getInstance();
    int dd, mm, yyyy;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndate = findViewById(R.id.btndate);
        btntime = findViewById(R.id.btntime);
        btncustom = findViewById(R.id.btncus);

        dd = cal.get(Calendar.DAY_OF_MONTH);
        mm = 1 + cal.get(Calendar.MONTH);
        yyyy = cal.get(Calendar.YEAR);

        btndate.setText(dd + "/" + mm + "/" + yyyy);

        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        btntime.setText(hour + ":" + minute);

        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this
                        , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int mon = 1 + month;
                        btndate.setText(dayOfMonth + "/" + mon + "/" + year);
                    }
                }
                        , cal.get(Calendar.YEAR)
                        , cal.get(Calendar.MONTH)
                        , cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this
                        , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btntime.setText(hourOfDay + ":" + minute);
                    }
                }
                        , cal.get(Calendar.HOUR_OF_DAY)
                        , cal.get(Calendar.MINUTE)
                        , false).show();
            }
        });

        btncustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(MainActivity.this);
                d.setContentView(R.layout.mydialog);
                d.show();

                final EditText etname;
                final Button btn;

                etname = d.findViewById(R.id.name);
                btn = d.findViewById(R.id.save);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btncustom.setText(etname.getText().toString());
                        d.dismiss();
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert")
                .setMessage("Are you sure want to close this app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setCancelable(false).show();
    }
}
