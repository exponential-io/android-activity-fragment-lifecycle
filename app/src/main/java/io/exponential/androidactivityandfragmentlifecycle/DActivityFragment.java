package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class DActivityFragment extends Fragment {

    private static final String TAG = "DFragment";

    public DActivityFragment() {
        Log.v(TAG, "S:lcm:Constructor");
        Log.v(TAG, "E:lcm:Constructor");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG, "S:lcm:onAttach");
        Log.v(TAG, "E:lcm:onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "S:lcm:onCreate");
        Log.v(TAG, "E:lcm:onCreate");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        Log.v(TAG, "S:lcm:onCreateView");
        View view = inflater.inflate(R.layout.fragment_d, container, false);

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
    }
}
