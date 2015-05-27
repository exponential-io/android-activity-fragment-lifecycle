package io.exponential.androidactivityandfragmentlifecycle;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class CActivity extends AppCompatActivity
    implements AlertDialogFragment.Callbacks {

    private static final String TAG = "CActivity:lcm";

    OnClickListener openDialog = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = "Alert";
            String message = "The Activity has been paused.";

            DialogFragment alertDialog = AlertDialogFragment.newInstance(title, message);
            alertDialog.show(getSupportFragmentManager(), "alertDialog");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "S:onCreate");
        setContentView(R.layout.activity_c);

        // Event handlers
        ((Button) findViewById(R.id.activity_c_pause)).setOnClickListener(openDialog);

        Log.v(TAG, "E:onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "S:onStart");
        Log.v(TAG, "E:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "S:onResume");
        Log.v(TAG, "E:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "S:onPause");
        Log.v(TAG, "E:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "S:onStop");
        Log.v(TAG, "E:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "S:onRestart");
        Log.v(TAG, "E:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "S:onDestroy");
        Log.v(TAG, "E:onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_c, menu);
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

    // AlertDialogFragment.Callbacks
    @Override
    public void onClickAlertOK() {
        Log.v(TAG, "Close alert dialog");
    }

    @Override
    public void onClickAlertCancel() {
        Log.v(TAG, "Close alert dialog");
    }

}
