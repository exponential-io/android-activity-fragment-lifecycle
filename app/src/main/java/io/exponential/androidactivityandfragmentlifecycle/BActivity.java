package io.exponential.androidactivityandfragmentlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class BActivity extends AppCompatActivity
    implements BFragment.Callbacks {

    public static final String EXTRA_CITY = "io.exponential.androidactivityandfragmentlifecycle.CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        String name = "";

        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra(AActivity.EXTRA_NAME);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        BFragment bFragment = BFragment.newInstance(name);
        ft.add(R.id.activity_b_fragment_container, bFragment);

        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setCity(String city) {
        Intent intent = new Intent(BActivity.this, AActivity.class);
        intent.putExtra(EXTRA_CITY, city);
        startActivity(intent);
    }
}
