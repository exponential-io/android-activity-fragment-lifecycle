package io.exponential.androidactivityandfragmentlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BActivity extends AppCompatActivity
    implements BFragment.Callbacks {

    public static final String EXTRA_CITY = "io.exponential.androidactivityandfragmentlifecycle.CITY";
    private static final String TAG = "BActivity";

    View.OnClickListener displayActivityC = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(BActivity.this, CActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "S:lcm:onCreate");
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

        // Event handlers
        ((Button) findViewById(R.id.display_activity_c)).setOnClickListener(displayActivityC);

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
