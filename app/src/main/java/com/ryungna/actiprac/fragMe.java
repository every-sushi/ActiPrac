package com.ryungna.actiprac;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class fragMe extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //프래그먼트 상속받는 클래스 oncreate에 있어야함

    }

//    프래그먼트를 포함하고 있는 액티비티의 생성이 완료되
//    었을 때, 즉 액티비티의 onCreate() 메서드가 종료될 때 호출된다
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_frag_me, container, false);



        return v;
    }



    public void onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.item_addMe).setVisible(true);
        menu.findItem(R.id.item_logout).setVisible(true);
        menu.findItem(R.id.item_addFriends).setVisible(false);
        menu.findItem(R.id.item_addGroup).setVisible(false);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent whereToGo;
        switch (item.getItemId()) {

            case R.id.item_addMe:
                whereToGo = new Intent(getActivity(),addFriends.class);
                Toast.makeText(getActivity(), "나에게일기쓰기", Toast.LENGTH_SHORT).show();
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
























