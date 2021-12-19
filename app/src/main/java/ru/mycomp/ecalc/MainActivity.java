package ru.mycomp.ecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String text = "";
    int num, lastNum = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            num = savedInstanceState.getInt("num");
            lastNum = savedInstanceState.getInt("lastNum");
            text = savedInstanceState.getString("text");
            screen = findViewById(R.id.screen);
            screen.setText(text);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("num", num);
        savedInstanceState.putInt("lastNum", lastNum);
        savedInstanceState.putString("text", text);
    }

    public void button_onClick(View view) {
        screen = findViewById(R.id.screen);
        num = view.getId();
        Button button = findViewById(num);
        if ((text.length() == 0) && ((num == R.id.button_minus) ||
                (num == R.id.button_plus) ||
                (num == R.id.button_x) ||
                (num == R.id.button_slash) ||
                (num == R.id.button_enter) ||
                (num == R.id.button_back) ||
                (num == R.id.button_point)))
            text = "";
        else if (num == R.id.button_back)
            text = text.substring(0, text.length() - 1);
        else if (((num == R.id.button_minus) ||
                (num == R.id.button_plus) ||
                (num == R.id.button_x) ||
                (num == R.id.button_slash) ||
                (num == R.id.button_point)) &&
                ((lastNum == R.id.button_minus) ||
                        (lastNum == R.id.button_plus) ||
                        (lastNum == R.id.button_x) ||
                        (lastNum == R.id.button_slash) ||
                        (lastNum == R.id.button_point)
                )) {
            text = text.substring(0, text.length() - 1);
            text = text + button.getText().toString();
        } else text = text + button.getText().toString();
        screen.setText(text);
        lastNum = num;
    }
}

//        if (view.getId() == R.id.button_enter)
//            if (text.length() == 0) text = "";
//            else
//                {char[] symbol = text.toCharArray();
//                for (int i = 1; i < text.length(); i++) {
//                    if ((symbol[i] != '*') &
//                            (symbol[i] != '/') &
//                            (symbol[i] != '+') &
//                            (symbol[i] != '-'))
//                        symbol[i] = ++symbol[i-1];
//                }
//                for (int i = 1; i < symbol.length; i++) {
//                    if symbol[i]
//                }
//                }