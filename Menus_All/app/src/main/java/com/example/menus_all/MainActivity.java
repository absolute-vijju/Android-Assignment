package com.example.menus_all;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnpopup);
        tv = findViewById(R.id.tv);

        registerForContextMenu(tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                PopupMenu pop = new PopupMenu(MainActivity.this, btn);
                pop.getMenuInflater().inflate(R.menu.mymenu, pop.getMenu());
                pop.show();

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.op_search) {
                            Toast.makeText(MainActivity.this, "Serach Clicked", Toast.LENGTH_SHORT).show();
                        }
                        if (item.getItemId() == R.id.op_setting) {
                            Toast.makeText(MainActivity.this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                        }
                        if (item.getItemId() == R.id.op_about) {
                            Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.op_search) {
            Toast.makeText(this, "Serach Clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.op_setting) {
            Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.op_about) {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
