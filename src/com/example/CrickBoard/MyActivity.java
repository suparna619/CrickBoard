package com.example.CrickBoard;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.style.TtsSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private static int number = 0;
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
        TextView foo = (TextView) findViewById(R.id.formattedtext);
        foo.setText(""+number);
        TextView teamName = (TextView)findViewById(R.id.TeamName);
            teamName.setText("Team - 1");
        final String[] text = {""};
        Button addButton = (Button) findViewById(R.id.Add);
        Button reduceButton = (Button) findViewById(R.id.Reduce);
        Button doneButton = (Button) findViewById(R.id.Done);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.formattedtext);
                String text = editText.getText().toString();
                number += Integer.parseInt(text);
                foo.setText(number + "");
                editText.setText("");
            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.formattedtext);
                String text = editText.getText().toString();
                number -= Integer.parseInt(text);
                foo.setText(number + "");
                editText.setText("");
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView foo = (TextView) findViewById(R.id.formattedtext);
                Integer targetValue = number;
                teamName.setText("Team - 2");
                TextView target = (TextView) findViewById(R.id.Target);
                target.setText("Target : "+targetValue);
                number = 0;
                foo.setText(number + "");
                editText.setText("");
            }
        });

        }

    }
