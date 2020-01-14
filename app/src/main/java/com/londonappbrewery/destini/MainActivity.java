package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    //Ans1 = topButton
    Button mTopButton;
    //Ans2 = bottomButton
    Button mBottomButton;

    int mCurrentStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mBottomButton = findViewById(R.id.buttonBottom);
        mTopButton = findViewById(R.id.buttonTop);
        mCurrentStory = 1;


        //  Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Top button pressed.");
                updateStory(mCurrentStory,1);
                Log.d("Destini", "Posicao atual: " + mCurrentStory);
                updateAnswers(mCurrentStory);
            }
        });



        // Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Bottom button pressed.");
                updateStory(mCurrentStory,2);
                Log.d("Destini", "Posicao atual: " + mCurrentStory);
                updateAnswers(mCurrentStory);
            }
        });

    }

    private void updateStory(int currentStory, int answer){
        switch(currentStory){
            case 1:
                if (answer==1){
                    mCurrentStory = 3;
                    mStoryText.setText(R.string.T3_Story);
                    break;
                }
                else{
                    mCurrentStory = 2;
                    mStoryText.setText(R.string.T2_Story);
                    break;
                }
            case 2:
                if (answer == 1){
                    mCurrentStory = 3;
                    mStoryText.setText(R.string.T3_Story);
                    break;
                }
                else{
                    mCurrentStory = 4;
                    mStoryText.setText(R.string.T4_End);
                    break;
                }
            case 3:
                if (answer == 1){
                    mCurrentStory = 6;
                    mStoryText.setText(R.string.T6_End);
                    break;
                }
                else{
                    mCurrentStory = 5;
                    mStoryText.setText(R.string.T5_End);
                    break;
                }
        }
    }

    private void updateAnswers(int currentStory){
        switch(currentStory){
            case 1:
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);
                break;
            case 2:
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                break;
            case 3:
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                break;
            default:
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("This is the end of your story!");
                alert.setMessage("Thanks for playing Destini. Would you like to play again?");
                alert.setCancelable(false);
                alert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCurrentStory = 1;
                        mStoryText.setText(R.string.T1_Story);
                        mTopButton.setText(R.string.T1_Ans1);
                        mBottomButton.setText(R.string.T1_Ans2);
                        mTopButton.setVisibility(View.VISIBLE);
                        mBottomButton.setVisibility(View.VISIBLE);
                    }
                });
                alert.setNegativeButton("No.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.show();
        }
    }

}
