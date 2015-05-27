package io.exponential.androidactivityandfragmentlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// Change ActionBarActivity to
public class AActivity extends AppCompatActivity
    implements AFragment.Callbacks {

    public static final String EXTRA_NAME = "io.exponential.androidactivityandfragmentlifecycle.NAME";
    private static final String TAG = "AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "S:lcm:onCreate");
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
        Log.v(TAG, "E:lcm:onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "S:lcm:onStart");
        Log.v(TAG, "E:lcm:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "S:lcm:onResume");
        Log.v(TAG, "E:lcm:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "S:lcm:onPause");
        Log.v(TAG, "E:lcm:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "S:lcm:onStop");
        Log.v(TAG, "E:lcm:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "S:lcm:onRestart");
        Log.v(TAG, "E:lcm:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "S:lcm:onDestroy");
        Log.v(TAG, "E:lcm:onDestroy");
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
