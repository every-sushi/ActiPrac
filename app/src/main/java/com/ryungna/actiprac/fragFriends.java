package com.ryungna.actiprac;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.ryungna.actiprac.R.id.container;


public class fragFriends extends Fragment {
    Context ct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //프래그먼트 상속받는 클래스 oncreate에 있어야함

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_frag_friends, container, false);
        ct = container.getContext();
        return v;
    }

    public void onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.item_addFriends).setVisible(true);
        menu.findItem(R.id.item_logout).setVisible(true);
        menu.findItem(R.id.item_addMe).setVisible(false);
        menu.findItem(R.id.item_addGroup).setVisible(false);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent whereToGo;
        switch (item.getItemId()) {

            case R.id.item_addFriends:
                whereToGo = new Intent(getActivity(),addFriends.class);
                Toast.makeText(getActivity(), "친구추가", Toast.LENGTH_SHORT).show();
                startActivity(whereToGo);
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
