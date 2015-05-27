package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

/**
 * DO NOT USE THIS CLASS. IT IS ONLY FOR STUDYING THE ACTIVITY LIFECYCLE.
 */
public class DialogActivity extends Activity {
    public static final String EXTRA_DIALOG_TITLE = "io.exponential.androidactivityandfragmentlifecycle.dialogactivity.TITLE";
    public static final String EXTRA_DIALOG_MESSAGE = "io.exponential.androidactivityandfragmentlifecycle.dialogactivity.MESSAGE";

    OnClickListener closeHandler = new OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);

        ((Button) findViewById(R.id.dialog_activity_close)).setOnClickListener(closeHandler);
    }

}
