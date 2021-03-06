package io.exponential.androidactivityandfragmentlifecycle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * Callback Interface to handle interaction events. Use the {@link AlertDialogFragment#newInstance}
 * factory method to create an instance of this fragment.
 */
public class AlertDialogFragment extends DialogFragment {
    private static final String ARG_MESSAGE = "AlertDialogFragment.message";
    private static final String ARG_TITLE = "AlertDialogFragment.title";

    private String dialogTitle;
    private String dialogMessage;
    private Callbacks callbacks;
    private static final int DEFAULT_THEME = 0;

    /**
     * Factory method to create a new instance of this fragment.
     *
     * @param title   Dialog title.
     * @param message Message to display in dialog.
     * @return A new instance of fragment AlertDialogFragment.
     */
    public static AlertDialogFragment newInstance(String title, String message) {
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    public AlertDialogFragment() {
        // Required empty public constructor
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dialogTitle = getArguments().getString(ARG_TITLE);
            dialogMessage = getArguments().getString(ARG_MESSAGE);
        }

        setStyle(DialogFragment.STYLE_NORMAL, DEFAULT_THEME);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog
                .Builder(getActivity())
                .setTitle(dialogTitle)
                .setMessage(dialogMessage)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int clickedButton) {
                                callbacks.onClickAlertOK();
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int clickedButton) {
                                callbacks.onClickAlertCancel();
                            }
                        }
                )
                .create();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void onClickAlertOK();

        public void onClickAlertCancel();
    }

}
