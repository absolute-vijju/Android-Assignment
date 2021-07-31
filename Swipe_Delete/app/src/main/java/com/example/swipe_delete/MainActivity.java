package com.example.swipe_delete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rev;

    MyAdapter myAdapter;

    Retrofit retrofit;

    List<GetterSetter> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rev = findViewById(R.id.rev);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rev.setLayoutManager(layoutManager);

       /* for (int i = 0; i < images.length; i++) {
            GetterSetter gs = new GetterSetter(images[i], names[i]);

            al.add(gs);

            myAdapter = new MyAdapter(this, al);
            rev.setAdapter(myAdapter);

        }*/

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.androidhive.info/json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<GetterSetter>> call = apiInterface.getMenu();

        call.enqueue(new Callback<List<GetterSetter>>() {
            @Override
            public void onResponse(Call<List<GetterSetter>> call, Response<List<GetterSetter>> response) {
                al = response.body();

                myAdapter = new MyAdapter(MainActivity.this, al);
                rev.setAdapter(myAdapter);

                Toast.makeText(MainActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<GetterSetter>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                al.remove(viewHolder.getAdapterPosition());
                final Snackbar snackbar = Snackbar.make(rev, "Data Deleted Successfully", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                myAdapter.notifyDataSetChanged();
                if (al.size() == 0) {
                    setContentView(R.layout.empty_layout);
                }
            }
        }).attachToRecyclerView(rev);

    }
}
