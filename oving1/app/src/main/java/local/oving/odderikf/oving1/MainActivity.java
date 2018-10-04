package local.oving.odderikf.oving1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);//kaller metoden som vi arver, er dog ikke nødvendig
        menu.add("Odd-Erik"); //legger til meny-valg med teksten «Valg 1»
        menu.add("Frantzen");
        Log.i("onCreateOptionsMenu()","meny laget"); //skriver ut til logg, vises i LogCat
        return true; //true her gjør at menyen vil vises
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("onOptionsItemSelected", (item.getTitle()).toString());
        return super.onOptionsItemSelected(item);
    }
}
