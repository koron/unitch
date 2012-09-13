package net.kaoriya.unitch;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Unitch extends Activity
{
    public final static String TAG = "Unitch";

    private class UnitchTask extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... args)
        {
            Log.v(TAG, "enter");
            while (!isCancelled())
            {
                // TODO:
            }
            Log.v(TAG, "leave");
            return null;
        }

        @Override
        protected void onPreExecute()
        {
            Log.v(TAG, "start");
            findViewById(R.id.start).setEnabled(false);
            findViewById(R.id.stop).setEnabled(true);
        }

        @Override
        protected void onPostExecute(Void result) { stop(); }

        @Override
        protected void onCancelled() { stop(); }

        private void stop()
        {
            Log.v(TAG, "stop");
            findViewById(R.id.stop).setEnabled(false);
            findViewById(R.id.start).setEnabled(true);
        }
    }

    private UnitchTask task = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick_start(View view)
    {
        this.task = new UnitchTask();
        this.task.execute();
    }

    public void onClick_stop(View view)
    {
        if (this.task != null) {
            this.task.cancel(true);
            this.task = null;
        }
    }

}
