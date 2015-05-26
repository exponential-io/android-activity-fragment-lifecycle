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


public class AFragment extends Fragment {
    private static final String ARG_CITY = "city";
    private String city;
    private Callbacks callbacks;

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
        AFragment aFragment = new AFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY, city);
        aFragment.setArguments(args);
        return aFragment;
    }

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = getArguments().getString(ARG_CITY);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Update the UI based on args passed into newInstance()
        ((TextView) view.findViewById(R.id.fragment_a_city)).setText(city);

        // Event handlers
        Button displayName = (Button) view.findViewById(R.id.fragment_a_display_name);
        displayName.setOnClickListener(displayNameHandler);

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
        public void updateName(String name);
    }

    // AFragment has no public methods as the containing Activity never passed data down to the
    // Fragment after the Fragment is created.
}
