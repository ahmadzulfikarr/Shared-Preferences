package com.zulfikar.notesapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zulfikar.notesapp.fragments.LoginFragments;
import com.zulfikar.notesapp.fragments.NoteFragments;
import com.zulfikar.notesapp.fragments.SettingFragment;
import com.zulfikar.notesapp.models.User;


public class MainActivity extends AppCompatActivity implements LoginFragments.OnLoginFragmentListener, NoteFragments.OnNoteFragmentListener,NoteFragments.OnDisplayListener{

    Settings settings;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        settings = new Settings(this);
        session = new Session(settings);

        addFragment();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            createSettingFragment();  //ketika menu setting di tekan
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addFragment(){
        Fragment fragment = null;
        if (session.isLogin()) {
            fragment = new NoteFragments();
            ((NoteFragments) fragment).setListener(this);
            ((NoteFragments) fragment).setDisplayListener(this);
        } else {
            fragment = new LoginFragments();
            ((LoginFragments) fragment).setListener(this);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void onLoginClicked(View view, String username, String password){
        User user = session.doLogin(username, password);
        String message = "Authentication failed";
        if (user != null) {
            message = "Welcome " + username;
            session.setUser(username);
            addFragment();
        }
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutClick() {
        session.doLogout();
        addFragment();
    }


    private void createSettingFragment(){
        Fragment settingFragment = new SettingFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, settingFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public String getLastList() {
        if (settings.getListMode() == null){
            return  "list";
        }else{
            return settings.getListMode();
        }
    }

    @Override
    public void setLastList(String last) {
        settings.setListMode(last);
    }
}