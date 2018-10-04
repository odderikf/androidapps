package local.oving.odderikf.oving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class RandomIntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_int);


        Intent intent = getIntent();
        int upperBound = 100;
        int lowerBound = 0;

        upperBound = intent.getIntExtra("randomInt", 0);

        Random random = new Random();
        int i = random.nextInt(upperBound) + lowerBound;
        //Toast.makeText(this, ""+i, Toast.LENGTH_LONG).show();
        Intent ret = new Intent();
        ret.putExtra("randomInt", i);
        setResult(RESULT_OK, ret);
        finish();
    }
}
