package ru.mail.vlados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textField);
        View.OnClickListener listener = new ClickListener(textView);
            Button button1 = findViewById(R.id.button1);
            button1.setOnClickListener(listener);
            Button button2 = findViewById(R.id.button2);
            button2.setOnClickListener(listener);
            Button button3 = findViewById(R.id.button3);
            button3.setOnClickListener(listener);
            Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(listener);
            Button button5 = findViewById(R.id.button5);
            button5.setOnClickListener(listener);
            Button button6 = findViewById(R.id.button6);
            button6.setOnClickListener(listener);
            Button button7 = findViewById(R.id.button7);
            button7.setOnClickListener(listener);
            Button button8 = findViewById(R.id.button8);
            button8.setOnClickListener(listener);
            Button button9 = findViewById(R.id.button9);
            button9.setOnClickListener(listener);
            Button button0 = findViewById(R.id.button0);
            button0.setOnClickListener(listener);
            Button buttonC = findViewById(R.id.buttonC);
            buttonC.setOnClickListener(listener);
            Button buttonDot = findViewById(R.id.buttonDot);
            buttonDot.setOnClickListener(listener);
            Button buttonAddition = findViewById(R.id.buttonAddition);
            buttonAddition.setOnClickListener(listener);
            Button buttonSubstraction = findViewById(R.id.buttonSubtraction);
            buttonSubstraction.setOnClickListener(listener);
            Button buttonMultiplication = findViewById(R.id.buttonMultiplication);
            buttonMultiplication.setOnClickListener(listener);
            Button buttonDivision = findViewById(R.id.buttonDivision);
            buttonDivision.setOnClickListener(listener);
            Button buttonEven = findViewById(R.id.buttonEven);
            buttonEven.setOnClickListener(listener);
            Button buttonBackspace = findViewById(R.id.buttonBackspace);
            buttonBackspace.setOnClickListener(listener);
            Button buttonAC = findViewById(R.id.buttonAc);
            buttonAC.setOnClickListener(listener);
    }

    private class ClickListener implements View.OnClickListener {
        private TextView textView;
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<String> listActions = new ArrayList<>();
        boolean flagEven=false;

        private ClickListener(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void onClick(View v) {
            if((textView.getText().toString().equals("+")) | (textView.getText().toString().equals("-"))
                    | (textView.getText().toString().equals("*")) |(textView.getText().toString().equals("/"))) {
                beforeNewNumber(textView,textView.getText().toString());
            }
            if (v.getId() == R.id.button1)
                concatination(textView,"1");
            if (v.getId() == R.id.button2)
                concatination(textView,"2");
            if (v.getId() == R.id.button3)
                concatination(textView,"3");
            if (v.getId() == R.id.button4)
                concatination(textView,"4");
            if (v.getId() == R.id.button5)
                concatination(textView,"5");
            if (v.getId() == R.id.button6)
                concatination(textView,"6");
            if (v.getId() == R.id.button7)
                concatination(textView,"7");
            if (v.getId() == R.id.button8)
                concatination(textView,"8");
            if (v.getId() == R.id.button9)
                concatination(textView,"9");
            if (v.getId() == R.id.button0)
                concatination(textView,"0");
            if (v.getId() == R.id.buttonDot)
                concatination(textView,".");
            if (v.getId() == R.id.buttonC)
                textView.setText("");
            if (v.getId() == R.id.buttonAddition) {
                action(textView,"+");
            }
            if (v.getId() == R.id.buttonSubtraction) {
                action(textView,"-");
            }
            if (v.getId() == R.id.buttonMultiplication) {
                action(textView,"*");
            }
            if (v.getId() == R.id.buttonDivision) {
                action(textView,"/");
            }
            if(v.getId() == R.id.buttonEven){
                even(textView);
            }
            if(v.getId() == R.id.buttonBackspace){
                backspace(textView);
            }
            if(v.getId() == R.id.buttonAc){
                ac(textView);
            }
        }
        private void concatination(TextView toConc, String s){
            String fin = toConc.getText().toString();
            toConc.setText(fin.concat(s));
        }
        private void action(TextView toAct,String s){
            Double additionToList = Double.parseDouble(toAct.getText().toString());
            list.add(additionToList);
            toAct.setText(s);
        }
        private void beforeNewNumber(TextView bef,String s){
            String addition = bef.getText().toString();
            listActions.add(addition);
            bef.setText("");
        }
        private void even(TextView toEven){
            list.add(Double.parseDouble(toEven.getText().toString()));
            double fin=list.get(0);
            for (int i=1;i<list.size();++i){
                if(listActions.get(i-1).equals("+"))
                    fin+=list.get(i);
                if(listActions.get(i-1).equals("-"))
                    fin-=list.get(i);
                if(listActions.get(i-1).equals("*"))
                    fin*=list.get(i);
                if(listActions.get(i-1).equals("/"))
                    if(list.get(i)==0){
                    toEven.setText("Div by 0");
                    return;
                    }
                else
                    fin/=list.get(i);
            }
            listActions.clear();
            list.clear();
            toEven.setText(String.valueOf(fin));
        }
        private void backspace(TextView view){
            String s = view.getText().toString();
            String s2=s.substring(0,s.length()-1);
            view.setText(s2);
        }
        private void ac(TextView view){
            listActions.clear();
            list.clear();
            view.setText("");
        }
    }
}