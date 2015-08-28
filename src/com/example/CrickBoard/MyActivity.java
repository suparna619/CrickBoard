package com.example.CrickBoard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private static int score;
    private static int targetScore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText editText = (EditText) findViewById(R.id.search);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    handled = true;
                }
                return handled;
            }
        });
        TextView userTextInput = (TextView) findViewById(R.id.Formattedtext);
        userTextInput.setText("" + score);
        userTextInput.setTextSize(70);
        userTextInput.setGravity(Gravity.CENTER);
        TextView teamName = (TextView)findViewById(R.id.TeamName);
            teamName.setText("Team - 1");
        final String[] text = {""};
        Button addButton = (Button) findViewById(R.id.Add);
        Button reduceButton = (Button) findViewById(R.id.Reduce);
        Button doneButton = (Button) findViewById(R.id.Done);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView userTextInput = (TextView) findViewById(R.id.Formattedtext);
                String text = editText.getText().toString();
                if(!text.equals("")){
                    score += Integer.parseInt(text);
                    userTextInput.setText(score + "");
                    userTextInput.setTextSize(70);
                    userTextInput.setGravity(Gravity.CENTER);
                }

                editText.setText("");
                if (score > targetScore && targetScore != 0){
                    setContentView(R.layout.result);
                    TextView resultMessage = (TextView) findViewById(R.id.Result);
                    resultMessage.setText("Congratulation Team-2, You Won");
                }
            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView userTextInput = (TextView) findViewById(R.id.Formattedtext);
                String text = editText.getText().toString();
                if(!text.equals("")){
                    score -= Integer.parseInt(text);
                    userTextInput.setText(score + "");
                    userTextInput.setTextSize(70);
                    userTextInput.setGravity(Gravity.CENTER);
                }
                editText.setText("");
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView userTextInput = (TextView) findViewById(R.id.Formattedtext);
                teamName.setText("Team - 2");
                TextView target = (TextView) findViewById(R.id.Target);
                editText.setText("");
                if (score < targetScore && targetScore != 0){
                    setContentView(R.layout.result);
                    TextView resultMessage = (TextView) findViewById(R.id.Result);
                    resultMessage.setText("Congratulation Team-1, You Won");
                }
                targetScore = score;
                score = 0;
                userTextInput.setText(score + "");
                userTextInput.setTextSize(70);
                userTextInput.setGravity(Gravity.CENTER);
                target.setText("Target : "+targetScore);
            }
        });
    }
}
