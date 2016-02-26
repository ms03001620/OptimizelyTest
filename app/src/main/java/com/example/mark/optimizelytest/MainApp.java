package com.example.mark.optimizelytest;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.optimizely.Optimizely;
import com.optimizely.integration.OptimizelyEventListener;
import com.optimizely.integration.OptimizelyExperimentData;

import java.util.List;

/**
 * Created by Mark on 2016/1/28.
 */
public class MainApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        /*        Optimizely.startOptimizelyWithAPIToken("249d4eb3f1acf474dc5402f27afd500d:c96d2946",getApplication()*/
        Optimizely.startOptimizelyWithAPIToken("AANLrccB06750O2hxa7Qkqa8HKgepf1B~4768573261", this, new OptimizelyEventListener() {
            @Override
            public void onOptimizelyStarted() {
                Log.v("____", "onOptimizelyStarted");
            }

            @Override
            public void onOptimizelyFailedToStart(String s) {
                Log.v("____", "onOptimizelyFailedToStart:"+s);
            }

            @Override
            public void onOptimizelyExperimentVisited(OptimizelyExperimentData optimizelyExperimentData) {
                Log.v("____", "onOptimizelyExperimentVisited:"+optimizelyExperimentData.toString());
            }

            @Override
            public void onOptimizelyExperimentViewed(OptimizelyExperimentData optimizelyExperimentData) {
                Log.v("____", "onOptimizelyExperimentViewed:"+optimizelyExperimentData.toString());
            }

            @Override
            public void onOptimizelyEditorEnabled() {
                Log.v("____", "onOptimizelyEditorEnabled");
            }

            @Override
            public void onOptimizelyDataFileLoaded() {
                Log.v("____", "onOptimizelyDataFileLoaded");
            }

            @Override
            public void onGoalTriggered(String s, List<OptimizelyExperimentData> list) {
                Log.v("____", "onGoalTriggered s:"+s+", list:"+list.size());
            }

            @Override
            public void onMessage(String s, String s1, Bundle bundle) {
                Log.v("____", "onMessage s:"+s+", s1:"+s1+", bundle:"+bundle);
            }
        });
    }
}
