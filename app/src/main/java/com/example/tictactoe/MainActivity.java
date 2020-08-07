package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage]==2) {
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer==0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn: Tap To Play");
            }
            else {
                 img.setImageResource(R.drawable.o);
                 activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn: Tap To Play");
            }
         img.animate().translationYBy(1000f).setDuration(300);
        }

        if ((gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2)) {
            if (!((gameState[0]==gameState[1] && gameState[1]==gameState[2]) && (gameState[3]==gameState[4] && gameState[4]==gameState[5]) && (gameState[6]==gameState[7] && gameState[7]==gameState[8]) &&(gameState[0]==gameState[3] && gameState[3]==gameState[6]) && (gameState[1]==gameState[4] && gameState[4]==gameState[7]) && (gameState[2]==gameState[5] && gameState[5]==gameState[8]) && (gameState[0]==gameState[4] && gameState[4]==gameState[8]) && (gameState[2]==gameState[4] && gameState[4]==gameState[6]))){
                gameActive = false;
                String reset = "NoOne won:";
                TextView status = findViewById(R.id.status);
                status.setText(reset);

            }
        }

        for(int[] winPosition: winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                String winner;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winner = "X Has Won: " +
                            "Tap Anywhere to Restart";
                    }
                else {
                    winner = "O Has Won: " +
                            "Tap Anywhere to Restart";
                    }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
                }
            }

        if ((gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2)) {
             for(int i=0;i<winPositions.length;i++) {
                 if (((gameState[winPositions[i][0]]==gameState[winPositions[i][1]]) && (gameState[winPositions[i][1]]==gameState[winPositions[i][2]]))) {
                     String winner;
                     gameActive = false;
                     winner = "X Has Won: " +
                             "Tap Anywhere to Restart";
                     TextView status = findViewById(R.id.status);
                     status.setText(winner);
                    }
                }
            }

        }

    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's turn: Tap To Play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

