package br.com.juliorgm.dengosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.juliorgm.dengosapp.helper.HelperQuestion;

public class MainActivity extends AppCompatActivity {


    private HelperQuestion helperQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.txtFinalResult).setEnabled(false);
        findViewById(R.id.txtFinalResult).setVisibility(View.INVISIBLE);

        helperQuestion = new HelperQuestion(MainActivity.this);

    }

    public void sendAnswers(View view){
        if(!helperQuestion.turnBack())
            helperQuestion.sendQuestions();
        else{
            Intent i = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(i);
            finish();
        }

    }



}
