# Android Activity and Fragment Lifecycle

Learn about the Android Activity and Fragment lifecycles. Each lifecycle callback method has a log
message output at the beginning and end of the callback method's execution. The lifecycle for both
activities and fragments are tracked.


## Useful shortcuts

The following three shortcuts are a faster method of file navigation than using a mouse and the
**Project** pane (left pane).

- `Ctrl + N`: Open a Java file.
- `Ctrl + Shift + N`: Open a wider range of files, including layouts.
- `Ctrl + Tab`: Iterate through a list of recently opened files.


## Logging in Android

- Create a `private static final String TAG = "ActivityOrFragmentName"` at the top of each
  Activity / Fragment.
- Output a log message via `Log.d(TAG, "Some message");`.
- Change d (debug) to v (verbose), or


## Features used in this repo

- DialogFragment
    - http://developer.android.com/reference/android/app/DialogFragment.html
- Toast
    - http://developer.android.com/guide/topics/ui/notifiers/toasts.html


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

The first set of workflows are for a simple activity that does not use Fragments.

- onCreate()
- onStart()
- onResume()

### Stop current Activity and Create new Activity

Type     | Name | Method            |
---------|--------------------------|------
Activity | A    | onPause           | Start/End
Activity | B    | onCreate          | Start/End
Activity | B    | onStart           | Start/End
Activity | B    | onResume          | Start/End
Activity | A    | onStop            | Start/End
Activity | A    | onDestroy         | Start/End

### Pause Activity

- onPause()

### Resume Activity after Pause

- onResume()

### Stop Activity

- onPause()
- onStop()

### Restart Activity after Stop

- onRestart()
- onStart()
- onResume()

### Create Activity w/Fragment

The workflow below and those that follow are for an Activity with a Fragment that is included via
the FragmentManager/FragmentTransaction.

Type     | Method            |
---------|-------------------|------
Activity | onCreate          | Start
Fragment | newInstance       | Start
Fragment | Constructor       | Start/End
Fragment | newInstance       | End
Activity | onCreate          | End
Fragment | onAttach          | Start/End
Fragment | onCreate          | Start/End
Fragment | onCreateView      | Start/End
Fragment | onActivityCreated | Start/End
Fragment | onStart           | Start/End
Activity | onStart           | Start/End
Activity | onResume          | Start/End
Fragment | onResume          | Start/End

### Create Activity w/Fragment via `<fragment>`

The lifecycle callback workflow for an Activity with Fragment via `<fragment>` is different from the
workflow for an Activity with Fragment via `FragmentManager`.

The following three lifecycle callback methods are called **before** Activity `onCreate` ends when
we insert the Fragment via `<fragment>`.

- onAttach
- onCreate
- onCreateView


Type     | Method            |
---------|-------------------|------
Activity | onCreate          | Start
Fragment | Constructor       | Start/End
Fragment | onAttach          | Start/End
Fragment | onCreate          | Start/End
Fragment | onCreateView      | Start/End
Activity | onCreate          | End
Fragment | onActivityCreated | Start/End
Fragment | onStart           | Start/End
Activity | onStart           | Start/End
Activity | onResume          | Start/End
Fragment | onResume          | Start/End


### Stop current Activity and Create new Activity (w/Fragments)

- Current Activity = A with Fragment = AF
- New Activity = B with Fragment = BF

The following three lifecycle callback methods are called **after** Activity `onCreate` ends when we
insert the Fragment via `FragmentManager` / `FragmentTransaction`.

- onAttach
- onCreate
- onCreateView

Type     | Name | Method            |
---------|--------------------------|------
Fragment | AF   | onPause           | Start/End
Activity | A    | onPause           | Start/End
Activity | B    | onCreate          | Start
Fragment | BF   | newInstance       | Start
Fragment | BF   | Constructor       | Start/End
Fragment | BF   | newInstance       | End
Activity | B    | onCreate          | End
Fragment | BF   | onAttach          | Start/End
Fragment | BF   | onCreate          | Start/End
Fragment | BF   | onCreateView      | Start/End
Fragment | BF   | onActivityCreated | Start/End
Fragment | BF   | onStart           | Start/End
Activity | B    | onStart           | Start/End
Activity | B    | onResume          | Start/End
Fragment | BF   | onResume          | Start/End
Fragment | AF   | onStop            | Start/End
Activity | A    | onStop            | Start/End


### Stop current Activity and Create new Activity w/Fragments via `<fragment>`

- Current Activity = A with Fragment = AF                                        
- New Activity = B with Fragment = BF

Type     | Name | Method            |
---------|--------------------------|------
Fragment | AF   | onPause           | Start/End
Activity | A    | onPause           | Start/End
Activity | B    | onCreate          | Start
Fragment | BF   | Constructor       | Start/End
Fragment | BF   | onAttach          | Start/End
Fragment | BF   | onCreate          | Start/End
Fragment | BF   | onCreateView      | Start/End
Activity | B    | onCreate          | End
Fragment | BF   | onActivityCreated | Start/End
Fragment | BF   | onStart           | Start/End
Activity | B    | onStart           | Start/End
Activity | B    | onResume          | Start/End
Fragment | BF   | onResume          | Start/End
Fragment | AF   | onStop            | Start/End
Activity | A    | onStop            | Start/End


### Pause Activity w/Fragment

Type     | Method            |
---------|-------------------|------
Fragment | onPause           | Start/end
Activity | onPause           | Start/end


### Resume Activity after Pause w/Fragment

Type     | Method            |
---------|-------------------|------
Activity | onResume          | Start/end
Fragment | onResume          | Start/end


### Stop Activity w/Fragment

Type     | Method            |
---------|-------------------|------
Fragment | onPause           | Start/End
Activity | onPause           | Start/End
Fragment | onStop            | Start/End
Activity | onStop            | Start/End


### Restart Activity after Stop w/Fragment

Type     | Method            |
---------|-------------------|------
Activity | onRestart         | Start/End
Fragment | onRestart         | Start/End
Activity | onStart           | Start/End
Activity | onResume          | Start/End
Fragment | onResume          | Start/End


## Additional reading

- https://github.com/xxv/android-lifecycle is an excellent repo that shows the Activity and Fragment
  lifecycles in extreme detail. This is an good resource if you'd like more detail than what is
  provided in this repo.
