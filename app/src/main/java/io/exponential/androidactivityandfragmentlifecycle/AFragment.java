package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AFragment extends Fragment {
    private static final String ARG_CITY = "city";
    private String city;
    private Callbacks callbacks;
    private static final String TAG = "AFragment";

    OnClickListener displayNameHandler = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = ((EditText) getView().findViewById(R.id.fragment_a_name))
                    .getText().toString();

            if (callbacks != null) {
                callbacks.updateName(name);
            }
        }
    };

    // Factory method without arguments
    public static AFragment newInstance(String city) {
        Log.v(TAG, "S:lcm:newInstance");

        AFragment aFragment = new AFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY, city);
        aFragment.setArguments(args);
        Log.v(TAG, "E:lcm:newInstance");
        return aFragment;
    }

    public AFragment() {
        // Required empty public constructor
        Log.v(TAG, "S:lcm:Constructor");
        Log.v(TAG, "E:lcm:Constructor");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG, "S:lcm:onAttach");
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
        Log.v(TAG, "E:lcm:onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "S:lcm:onCreate");
        if (getArguments() != null) {
            city = getArguments().getString(ARG_CITY);
        }
        Log.v(TAG, "E:lcm:onCreate");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        Log.v(TAG, "S:lcm:onCreateView");
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Update the UI based on args passed into newInstance()
        ((TextView) view.findViewById(R.id.fragment_a_city)).setText(city);

        // Event handlers
        Button displayName = (Button) view.findViewById(R.id.fragment_a_display_name);
        displayName.setOnClickListener(displayNameHandler);

        Log.v(TAG, "E:lcm:onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG, "S:lcm:onActivityCreated");
        Log.v(TAG, "E:lcm:onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "S:lcm:onStart");
        Log.v(TAG, "E:lcm:onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "S:lcm:onResume");
        Log.v(TAG, "E:lcm:onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "S:lcm:onPause");
        Log.v(TAG, "E:lcm:onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "S:lcm:onStop");
        Log.v(TAG, "E:lcm:onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG, "S:lcm:onDestroyView");
        Log.v(TAG, "E:lcm:onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "S:lcm:onDestroy");
        Log.v(TAG, "E:lcm:onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG, "S:lcm:onDetach");
        Log.v(TAG, "E:lcm:onDetach");
        callbacks = null;
    }

    public interface Callbacks {
        public void updateName(String name);
    }

    // AFragment has no public methods as the containing Activity never passed data down to the
    // Fragment after the Fragment is created.
}
