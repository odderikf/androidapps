package local.oving.odderikf.oving2.oppgave2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private TextView number1;
    private TextView number2;

    private EditText answer;
    private EditText bound;

    private Button add;
    private Button mul;

    private int number1code = 20;
    private int number2code = 21;


    private void onClickHelper(View v, int expected){
        int actual = Integer.parseInt(answer.getText().toString());
        if (expected == actual){
            Toast.makeText(v.getContext(), R.string.riktigString, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(v.getContext(), getText(R.string.feilString) + Integer.toString(expected), Toast.LENGTH_LONG).show();
        }

        Intent getRandom = new Intent("GetRandomInt");
        getRandom.putExtra("upperBound", Integer.parseInt(bound.getText().toString()));
        startActivityForResult(getRandom, number1code);
        startActivityForResult(getRandom, number2code);

    }

    @SuppressLint("SetTextI18n")
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == number1code){
            number1.setText(Integer.toString(data.getIntExtra("randomInt", 0)));
        } else if (requestCode == number2code){
            number2.setText(Integer.toString(data.getIntExtra("randomInt", 0)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number1.setText("3");
        number2.setText("5");

        answer = findViewById(R.id.answer);
        bound = findViewById(R.id.bound);
        answer.setText("8");
        bound.setText("10");


        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    int expected = Integer.parseInt(number1.getText().toString())
                            + Integer.parseInt(number2.getText().toString());
                    onClickHelper(v, expected);

                }catch (Exception e){
                    Log.d("Error", e.toString());
                    Toast.makeText(v.getContext(), getText(R.string.invalidString), Toast.LENGTH_LONG).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    int expected = Integer.parseInt(number1.getText().toString())
                            * Integer.parseInt(number2.getText().toString());
                    onClickHelper(v, expected);

                }catch (Exception e){
                    Log.d("Error", e.toString());
                    Toast.makeText(v.getContext(), getText(R.string.invalidString), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
