package com.medtrack.medtrack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String BASE_URL = "http://1bffcdae.ngrok.io/";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.listView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        List<Resource> notes = new ArrayList<Resource>();

        for (int i = 0; i < 3; i++) {   //listaPedidos é um ArrayList comum
            Resource resource = new Resource();
            resource.id=i;
            if(i == 0){
                resource.name = "Pills";
                resource.description = "Bought some pills";
                resource.created_at =  "2016-09-14 10:00:00";
            }else if(i == 1){
                resource.name = "Doctor Consultation";
                resource.description = "Doctor's Phill consultation";
                resource.created_at =  "2016-09-12 13:00:00";
            }else{
                resource.name = "Blood test";
                resource.description = "My first Blood test";
                resource.created_at =  "2016-09-09 16:35:10";
            }

            notes.add(i, resource);
        }

        ArrayAdapter<Resource> adapter = new ArrayAdapter<Resource>(this, android.R.layout.simple_list_item_1, notes);
        mListView.setAdapter(adapter);

        /*api.getResources("ryHcEA5h").enqueue(new Callback<List<Resource>>() {
            @Override
            public void onResponse(Call<List<Resource>> call, Response<List<Resource>> response) {
                Log.d("Response", response.message());
                if (response.code() == 200){
                    ArrayAdapter<Resource> adapter = new ArrayAdapter<Resource>(MainActivity.this, android.R.layout.simple_list_item_1, response.body());
                    AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView parent, View v, int position, long id) {
                            // Do something in response to the click
                            Log.d("Click", String.valueOf(position));
                        }
                    };

                    mListView.setOnItemClickListener(mMessageClickedHandler);
                    mListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Resource>> call, Throwable t) {
                Log.d("FAILURE", t.getMessage());
                //Toast.makeText(MainActivity, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            }
        });*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
}
