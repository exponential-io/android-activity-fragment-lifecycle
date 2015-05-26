package io.exponential.androidactivityandfragmentlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

// Change ActionBarActivity to
public class AActivity extends AppCompatActivity
    implements AFragment.Callbacks {

    public static final String EXTRA_NAME = "io.exponential.androidactivityandfragmentlifecycle.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Default value for city
        String city = "User has not entered a city";

        // Get the Intent if one was passed into this Activity. When the Activity is first started,
        // no Intent will be available. However, when BActivity calls startActivity() is passes a
        // Bundle to AActivity that includes the user's city.
        Intent intent = getIntent();
        if (intent != null) {
            city = intent.getStringExtra(BActivity.EXTRA_CITY);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        AFragment aFragment = AFragment.newInstance(city);
        ft.add(R.id.activity_a_fragment_container, aFragment);

        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_a, menu);
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

    /**
     * Receive the user's full name from AFragment and pass it to BActivity via an Intent. BActivity
     * then passes the value of 'name' to BFragment via BFragment.newInstance().
     *
     * @param name {String} User's full name.
     */
    @Override
    public void updateName(String name) {
        Intent intent = new Intent(AActivity.this, BActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}
