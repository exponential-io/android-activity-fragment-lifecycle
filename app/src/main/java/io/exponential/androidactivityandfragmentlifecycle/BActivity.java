package io.exponential.androidactivityandfragmentlifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class BActivity extends AppCompatActivity
    implements BFragment.Callbacks, AlertDialogFragment.Callbacks {

    public static final String EXTRA_CITY = "io.exponential.androidactivityandfragmentlifecycle.CITY";
    private static final String TAG = "BActivity";

    OnClickListener openFragmentDialog = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = "Alert";
            String message = "The Activity has NOT been paused.";

            DialogFragment alertDialog = AlertDialogFragment.newInstance(title, message);
            alertDialog.show(getSupportFragmentManager(), "alertDialog");
        }
    };

    OnClickListener openActivityDialog = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = "Alert";
            String message = "The Activity has been paused.";

            Intent intent = new Intent(BActivity.this, DialogActivity.class);
            intent.putExtra(DialogActivity.EXTRA_DIALOG_TITLE, title);
            intent.putExtra(DialogActivity.EXTRA_DIALOG_MESSAGE, message);
            startActivity(intent);
        }
    };

    OnClickListener displayActivityC = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(BActivity.this, CActivity.class);
            startActivity(intent);
        }
    };

    OnClickListener displayActivityD = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(BActivity.this, DActivity.class);
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
        ((Button) findViewById(R.id.activity_b_no_pause)).setOnClickListener(openFragmentDialog);
        ((Button) findViewById(R.id.activity_b_pause)).setOnClickListener(openActivityDialog);
        ((Button) findViewById(R.id.display_activity_c)).setOnClickListener(displayActivityC);
        ((Button) findViewById(R.id.display_activity_d)).setOnClickListener(displayActivityD);

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

    @Override
    public void onClickAlertOK() {
        // Short form of the code below is:
        //Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();

        Context context = getApplicationContext();
        CharSequence message = "OK";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, message, duration).show();
    }

    @Override
    public void onClickAlertCancel() {
        Context context = getApplicationContext();
        CharSequence message = "Cancel";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
