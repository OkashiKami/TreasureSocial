package com.sprinunna.treasuresocial;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sprinunna.treasuresocial.Utils.Account;
import com.sprinunna.treasuresocial.Utils.DownloadImage;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static home inst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inst = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final FloatingActionButton fabsend = (FloatingActionButton) findViewById(R.id.fab_send);
        final RelativeLayout msgLayout = (RelativeLayout)findViewById(R.id.messageLayout);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgLayout.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
            }
        });
        fabsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.setVisibility(View.VISIBLE);
                msgLayout.setVisibility(View.GONE);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               ApplySidebarData();
           }
       }, 2000);
    }

    ImageView propic;
    TextView name;
    TextView email;
    private void ApplySidebarData() {
        View  view = findViewById(R.id.nav_view);
        name = (TextView) view.findViewById(R.id.profilenameview);
        email = (TextView) view.findViewById(R.id.profileemailview);
        propic = (ImageView) view.findViewById(R.id.profileimageview);
        if(name == null || email == null || propic == null) return;
        Account acc = Account.Load();
        name.setText(acc.username);
        email.setText(acc.email);
        new DownloadImage(propic).execute(acc.url);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static void SnackBarNotification(View v, String... msg){
        for(int i = 0; i < msg.length-1; i++)
        {
            Snackbar.make(v, msg[i], Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }
}
