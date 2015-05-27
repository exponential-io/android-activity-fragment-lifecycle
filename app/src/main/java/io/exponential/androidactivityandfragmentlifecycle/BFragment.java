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


public class BFragment extends Fragment {
    private static final String ARG_NAME = "name";
    private String name;
    private Callbacks callbacks;
    private static final String TAG = "BFragment";

    OnClickListener updateCityHandler = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String city = ((EditText) getView().findViewById(R.id.fragment_b_city))
                    .getText().toString();
            callbacks.setCity(city);
        }
    };

    // Factory method
    public static BFragment newInstance(String name) {
        Log.v(TAG, "S:lcm:newInstance");
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        Log.v(TAG, "E:lcm:newInstance");
        return fragment;
    }

    public BFragment() {
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
            name = getArguments().getString(ARG_NAME);
        }
        Log.v(TAG, "E:lcm:onCreate");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        Log.v(TAG, "S:lcm:onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        // Update the UI based on args passed into newInstance()
        ((TextView) view.findViewById(R.id.fragment_b_name)).setText(name);

        // Event handlers
        ((Button) view.findViewById(R.id.fragment_b_update_city))
                .setOnClickListener(updateCityHandler);

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
        public void setCity(String city);
    }

    // BFragment has no public methods as the containing Activity never passed data down to the
    // Fragment after the Fragment is created.

}
