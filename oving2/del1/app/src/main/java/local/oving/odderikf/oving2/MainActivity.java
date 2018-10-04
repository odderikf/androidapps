package local.oving.odderikf.oving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView randIntField;
    private int request_Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Debug","finished");
        setContentView(R.layout.activity_main);

        randIntField = findViewById(R.id.randomIntField);
        request_Code = 120;
        Intent randNum = new Intent("RANDOMNUMBER");
        randNum.putExtra("randomInt", 50);
        startActivityForResult(randNum, request_Code);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == request_Code){
            Log.d("Debug","boomshakalaka?");
            randIntField.setText(Integer.toString(data.getIntExtra("randomInt", 0)));
        }
    }
}
