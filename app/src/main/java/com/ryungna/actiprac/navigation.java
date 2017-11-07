package com.ryungna.actiprac;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class navigation extends AppCompatActivity {

    long lastPressed;
    Fragment fragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new fragMe();
                    switchFragment(fragment);
                    return true;

                case R.id.navigation_dashboard:
                    fragment = new fragGroup();
                    switchFragment(fragment);


                    return true;

                case R.id.navigation_notifications:
                    fragment = new fragFriends();
                    switchFragment(fragment);
                    return true;
            }
            return false;
        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragMe fragment = new fragMe();
        fragmentTransaction.add(R.id.content, fragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    public void switchFragment(Fragment fragment){ //프래그먼트 바뀌는거
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_logout,menu);
        return true; //이거 누르면 로그아웃
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goLogin = new Intent(navigation.this,login.class);

        if (item.getItemId() == R.id.logout) {
            Toast.makeText(getApplicationContext(), "로그아웃합니다",
                    Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(goLogin);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastPressed < 1500) {
            finish();
        }
        Toast.makeText(this,"한번더 누르면 종료",Toast.LENGTH_SHORT).show();
        lastPressed = System.currentTimeMillis();
    }


}
