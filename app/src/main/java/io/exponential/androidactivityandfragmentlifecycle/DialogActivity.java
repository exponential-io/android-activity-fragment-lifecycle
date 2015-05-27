package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * DO NOT USE THIS CLASS. IT IS ONLY FOR STUDYING THE ACTIVITY LIFECYCLE.
 */
public class DialogActivity extends Activity
        implements OnClickListener {

    public static final String EXTRA_DIALOG_TITLE = "io.exponential.androidactivityandfragmentlifecycle.dialogactivity.TITLE";
    public static final String EXTRA_DIALOG_MESSAGE = "io.exponential.androidactivityandfragmentlifecycle.dialogactivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);

        ((Button) findViewById(R.id.ok_btn_id)).setOnClickListener(this);
        ((Button) findViewById(R.id.cancel_btn_id)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_btn_id:
                showToastMessage("Ok Button Clicked");
                this.finish();
                break;
            case R.id.cancel_btn_id:
                showToastMessage("Cancel Button Clicked");
                this.finish();
                break;
        }
    }

    void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
