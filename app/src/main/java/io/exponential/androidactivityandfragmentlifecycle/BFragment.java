package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        // Update the UI based on args passed into newInstance()
        ((TextView) view.findViewById(R.id.fragment_b_name)).setText(name);

        // Event handlers
        ((Button) view.findViewById(R.id.fragment_b_update_city))
                .setOnClickListener(updateCityHandler);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void setCity(String city);
    }

    // BFragment has no public methods as the containing Activity never passed data down to the
    // Fragment after the Fragment is created.

}
