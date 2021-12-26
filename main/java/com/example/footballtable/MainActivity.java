package com.example.footballtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int rus = 0;
    private int noRus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume(){
        super.onResume();
        resetUI();
    }
    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putInt("rusCount", rus);
        outstate.putInt("noRusCount", noRus);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("rusCount")&&savedInstanceState.containsKey("noRusCount")){
            rus = savedInstanceState.getInt("rusCount");
            noRus = savedInstanceState.getInt("noRusCount");}
    }
    private void resetUI(){
        ((TextView) findViewById(R.id.noRus)).setText("" + noRus);
        ((TextView) findViewById(R.id.rus)).setText("" + rus);
    }
    public void addRus(View view){
        rus++;
        TextView counterView = (TextView)findViewById(R.id.rus);
        counterView.setText(""+ rus);
    }
    public void addNoRus(View view){
        noRus++;
        TextView counterView = (TextView)findViewById(R.id.noRus);
        counterView.setText(""+ noRus);
    }
    public void resetAll(View view){
        rus=0;
        noRus=0;
        TextView counterView = (TextView)findViewById(R.id.rus);
        counterView.setText(""+ rus);
        counterView = (TextView)findViewById(R.id.noRus);
        counterView.setText(""+ noRus);
    }
}