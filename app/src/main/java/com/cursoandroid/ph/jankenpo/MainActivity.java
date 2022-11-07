package com.cursoandroid.ph.jankenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock (View view) {
        this.optionSelected("rock");
    }

    public void selectPaper (View view) {
        this.optionSelected("paper");
    }

    public void selectShears (View view) {
        this.optionSelected("shears");
    }

    public void optionSelected (String option) {
        ImageView imageCPU = findViewById(R.id.imageCPU);
        TextView textResult = findViewById(R.id.result);
        int number = new Random().nextInt(3);
        String [] optionsCPU = {"rock", "paper", "shears"};
        String optionCPU = optionsCPU[number];
        switch (optionCPU) {
            case "rock": imageCPU.setImageResource(R.drawable.pedra);
                break;
            case "paper": imageCPU.setImageResource(R.drawable.papel);
                break;
            case "shears": imageCPU.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((option == "rock" && optionCPU == "paper") || (option == "paper" && optionCPU == "shears")
                || (option == "shears" && optionCPU == "rock")) textResult.setText("App venceu!");
        else if ((optionCPU == "rock" && option == "paper") || (optionCPU == "paper" && option == "shears")
                || (optionCPU == "shears" && option == "rock")) textResult.setText("Jogador venceu!");
        else textResult.setText("Empate!");

    }
}