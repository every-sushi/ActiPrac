package com.ryungna.actiprac;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class fragFriends extends Fragment {
    Intent in;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_frag_friends, container, false);
        FloatingActionButton add_friends = (FloatingActionButton) v.findViewById(R.id.add_friends);
        Button helloFriends = (Button) v.findViewById(R.id.helloFriends);
        in = new Intent(getActivity(),addFriends.class);

        helloFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in);


            }
        });

        add_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"hejjjjjjjjj\n"+getActivity()+" "+in,Toast.LENGTH_SHORT).show();

            }
        });
        // Inflate the layout for this fragment
        return v;
    }

}
