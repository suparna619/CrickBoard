package com.example.CrickBoard;

import android.app.Activity;
import android.os.Bundle;
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
        TextView teamName = (TextView)findViewById(R.id.TeamName);
            teamName.setText("Team - 1");
        final String[] text = {""};
        Button addButton = (Button) findViewById(R.id.Add);
        Button reduceButton = (Button) findViewById(R.id.Reduce);
        Button doneButton = (Button) findViewById(R.id.Done);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.Formattedtext);
                String text = editText.getText().toString();
                score += Integer.parseInt(text);
                foo.setText(score + "");

                editText.setText("");
                if (score > targetScore && targetScore != 0){
                    editText.setText("Congratulation Team-2, You Won");
                }
            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.Formattedtext);
                String text = editText.getText().toString();
                score -= Integer.parseInt(text);
                foo.setText(score + "");
                editText.setText("");
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.Formattedtext);
                teamName.setText("Team - 2");
                TextView target = (TextView) findViewById(R.id.Target);
                editText.setText("");
                if (score < targetScore && targetScore != 0){
                    editText.setText("Congratulation Team-1, You Won");
                }
                targetScore = score;
                score = 0;
                foo.setText(score + "");
                target.setText("Target : "+targetScore);

            }
        });

        }

    }
