package net.kaoriya.unitch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Unitch extends Activity
{
    public final static String TAG = "Unitch";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick_start(View view)
    {
        Log.v(TAG, "start");
        findViewById(R.id.start).setEnabled(false);
        findViewById(R.id.stop).setEnabled(true);
    }

    public void onClick_stop(View view)
    {
        Log.v(TAG, "stop");
        findViewById(R.id.stop).setEnabled(false);
        findViewById(R.id.start).setEnabled(true);
    }

}
