package com.ryungna.actiprac;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class fragGroup extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag_group, container, false);
        Button b = (Button)v.findViewById(R.id.logout);
        FloatingActionButton add_group = (FloatingActionButton) v.findViewById(R.id.add_group);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "logout",Toast.LENGTH_SHORT).show(); //okay

                //FirebaseAuth.getInstance().signOut();

            }
        });

        add_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "그룹추가 니까 액티비티로 ",Toast.LENGTH_SHORT).show(); //okay
            }
        });



        // Inflate the layout for this fragment
        return v;


    }





}
