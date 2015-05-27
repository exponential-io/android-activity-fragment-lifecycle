# Android Activity and Fragment Lifecycle

Learn about the Android Activity and Fragment lifecycles. Each lifecycle callback method has a log
message output at the beginning and end of the callback method's execution. The lifecycle for both
activities and fragments are tracked.

## Logging in Android

- Create a `private static final String TAG = "ActivityOrFragmentName"` at the top of each
  Activity / Fragment.
- Output a log message via `Log.d(TAG, "Some message");`.
- Change d (debug) to v (verbose), or

## Features used in this repo

- DialogFragment
    - http://developer.android.com/reference/android/app/DialogFragment.html


## How to view log messages

- Filter for `:lcm` or Lifecycle Callback Method

## Activity lifecycle callback methods

- onCreate()
- onRestart(): Only called after onStop()
- onStart()
- onResume()
- onPause()
- onStop()
- onDestroy()

## Fragment lifecycle callback methods

- onAttach()
- onCreate()
- onCreateView()
- onActivityCreated()
- onStart()
- onResume()
- onPause()
- onStop()
- onDestroyView()
- onDestroy()
- onDetach()

## Workflows

### Create Activity

- onCreate()
- onStart()
- onResume()

### Create Activity with Fragment



### Pause Activity

- onPause()

### Pause Activity with Fragment

### Resume Activity after Pause

- onResume()

### Resume Activity after Pause with Fragment

### Stop Activity

- onPause()
- onStop()

### Stop Activity with Fragment

### Restart Activity after Stop

- onRestart()
- onStart()
- onResume()

### Restart Activity after Stop with Fragment
