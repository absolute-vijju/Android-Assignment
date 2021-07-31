package geoacircle.com.navigation_drawernew;

import android.net.MailTo;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView nav;
    DrawerLayout dar;
    HomeFragment homeFragment = new HomeFragment();
    android.app.FragmentTransaction fthome;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.mytoolbar);
        nav = findViewById(R.id.nav);
        dar = findViewById(R.id.drawer_layout);
        floatingActionButton = findViewById(R.id.fab);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("GMAIL");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.menu);

        fthome = getFragmentManager().beginTransaction();
        fthome.replace(R.id.ll, homeFragment);
        fthome.commit();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.lock:
                        menuItem.setChecked(true);
                        dar.closeDrawers();
                        FirstFragment firstFragment = new FirstFragment();
                        android.app.FragmentTransaction ftlock = getFragmentManager().beginTransaction();
                        ftlock.replace(R.id.ll, firstFragment);
                        ftlock.commit();
                        break;
                    case R.id.unlock:
                        menuItem.setChecked(true);
                        dar.closeDrawers();
                        SecodFragment secodFragment = new SecodFragment();
                        android.app.FragmentTransaction ftunlock = getFragmentManager().beginTransaction();
                        ftunlock.replace(R.id.ll, secodFragment);
                        ftunlock.commit();
                        break;
                    case R.id.wifi:
                        menuItem.setChecked(true);
                        dar.closeDrawers();
                        ThirdFragment thirdFragment = new ThirdFragment();
                        android.app.FragmentTransaction ftwifi = getFragmentManager().beginTransaction();
                        ftwifi.replace(R.id.ll, thirdFragment);
                        ftwifi.commit();
                        break;
                    case R.id.bluetooth:
                        menuItem.setChecked(true);
                        dar.closeDrawers();
                        FourthFragment fourthFragment = new FourthFragment();
                        android.app.FragmentTransaction ftbluetooth = getFragmentManager().beginTransaction();
                        ftbluetooth.replace(R.id.ll, fourthFragment);
                        ftbluetooth.commit();
                        break;
                    case R.id.home:
                        menuItem.setChecked(true);
                        dar.closeDrawers();
                        fthome = getFragmentManager().beginTransaction();
                        fthome.replace(R.id.ll, homeFragment);
                        fthome.commit();
                        break;
                }
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Message Sent",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                dar.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
