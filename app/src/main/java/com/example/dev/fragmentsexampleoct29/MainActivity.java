package com.example.dev.fragmentsexampleoct29;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }

    public void swich_clicked(View view) {
        Fragment secondFragment = new SecondFragment();
        //secondFragment.setArguments();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.swich_area_for_fragments, secondFragment);
        transaction.commit();
    }

    public void second_swich_clicked(View view) {

        Fragment firstFragmentObject = new FirstFragment();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.swich_area_for_fragments, firstFragmentObject);
        transaction.commit();

    }

    public void add_remove_fragment(View view) {
        FragmentManager fm = getFragmentManager();

        ThirdFragment thirdFragmentObject = (ThirdFragment) fm.findFragmentById(R.id.add_remove_area);
        FragmentTransaction transaction = fm.beginTransaction();


        if (thirdFragmentObject == null) {// that mean the area is empty
            // I'm able to add fragment here
            ThirdFragment thirdfragment = new ThirdFragment();

            transaction.add(R.id.add_remove_area, thirdfragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        } else {// the area is already has third fragment
            // I'm able to delete that fragment

            transaction.remove(thirdFragmentObject);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        }

        transaction.commit();

    }




}
