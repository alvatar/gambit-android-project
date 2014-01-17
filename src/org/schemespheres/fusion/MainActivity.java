package org.schemespheres.fusion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.os.Handler;

/**
 *
 * @author SChapel
 */
public class MainActivity extends Activity
{
    protected TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);

        tv.setBackgroundColor(Color.WHITE);
        tv.setTextColor(Color.BLACK);

        tv.append("Running Gambit Scheme:\n\n");
        setContentView(tv);
        tv.setMovementMethod(new ScrollingMovementMethod());

        startGambitThread();
    }

    private void startGambitThread() {
        Handler handler = getWindow().getDecorView().getHandler();
        GambitRunnable gambitRunnable = GambitRunnable.getInstance();
        gambitRunnable.link(this, tv);
        new Thread(gambitRunnable).start();
    }

    static
    {
        System.loadLibrary("fusion-sphere");
    }

}

class GambitRunnable implements Runnable {
    private static GambitRunnable uniqInstance;
    protected Activity parentActivity;
    protected TextView tv;

    private GambitRunnable () {}

    public static synchronized GambitRunnable getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new GambitRunnable();
        }
        return uniqInstance;
    }

    public Activity getParentActivity() {
        return parentActivity;
    }

    public TextView getUiTextView() {
        return tv;
    }
    
    public void link(Activity activity, TextView itv) {
        parentActivity = activity;
        tv = itv;
    }

    public void run() {
        initGambit();
        schemeMain();
    }

    static public void printFromScheme(final String s) {
        getInstance().getParentActivity().runOnUiThread(new Runnable() {
            public void run() {
                getInstance().getUiTextView().append(s);
            }
        });
    }

    public native void initGambit();

    public native void schemeMain();
}

