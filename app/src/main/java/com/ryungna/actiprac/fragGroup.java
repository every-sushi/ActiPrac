package com.ryungna.actiprac;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class fragGroup extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //프래그먼트 상속받는 클래스 oncreate에 있어야함

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag_group, container, false);
        Button b = (Button)v.findViewById(R.id.logout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "logout",Toast.LENGTH_SHORT).show(); //okay


            }
        });

        return v;

    }


    public void onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.item_addGroup).setVisible(true);
        menu.findItem(R.id.item_logout).setVisible(true);

        menu.findItem(R.id.item_addFriends).setVisible(false);
        menu.findItem(R.id.item_addMe).setVisible(false);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent whereToGo;

        switch (item.getItemId()) {
            case R.id.item_addGroup:
                Toast.makeText(getActivity(), "그룹추가", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.item_logout:
                whereToGo = new Intent(getActivity(),login.class);

                Toast.makeText(getActivity(), "로그아웃", Toast.LENGTH_SHORT).show();
                startActivity(whereToGo);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }




}
