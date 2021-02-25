package com.example.classactivity4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we cannot find the second fragment in the layout
        // that means we only have 1 column
        // if we can
        // that means we have 2 panes
        if (findViewById(R.id.fragContainer_land_second) != null) {
            twoPane = true;
        }

        // loading in whether 1 or 2 frags based on this boolean variable
        if (!twoPane) { // portrait
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button_personality = findViewById(R.id.button_personality);
            button_personality.setOnClickListener(v->launchActivityPersonality(v));
            Button button_house = findViewById(R.id.button_house);
            button_house.setOnClickListener(v->launchActivityHouse(v));
        }
        else {
            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(), R.id.fragContainer_land_second);
            loadFragment(new ThirdFragment(), R.id.fragContainer_land_third);
        }
    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivityPersonality(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void launchActivityHouse(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}