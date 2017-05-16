package com.example.mark.optimizelytest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.optimizely.Optimizely;
import com.optimizely.Variable.LiveVariable;
import com.optimizely.integration.OptimizelyEventListener;
import com.optimizely.integration.OptimizelyExperimentData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action:"+enableGravityVariable.get()+
                        ", Gravity:"+gravityVariable.get(), Snackbar.LENGTH_LONG).setAction(
                        "Action", null).show();
            }
        });


        //Optimizely.enableEditor();


    }

    private static LiveVariable<Float> gravityVariable = Optimizely.floatForKey("Gravity", 0f /* default value */);
    private static LiveVariable<Boolean> enableGravityVariable = Optimizely.booleanForKey("EnableGravity", false /* default value */);

    private float updateSpeed(float currentSpeed) {
        if (enableGravityVariable.get()) {
            return currentSpeed + gravityVariable.get();
        } else {
            return currentSpeed;
        }
    }

}
