package be.ecam.startgame;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;


public class GameScreen extends Activity {

    private View decorView;
    private Handler frameHandler;
    private static final int FRAME_RATE = 20; //50 frames per second
    private GameView mGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //no title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        decorView = getWindow().getDecorView();
        frameHandler = new Handler();

        setContentView(R.layout.activity_game_screen);
        mGameView = ((GameView)findViewById(R.id.the_canvas));

        //first call to frame();
        frame();
    }

    //hide system UI
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    //Runnable that call the frame() method
    private Runnable frameUpdate = new Runnable() {
        @Override
        public void run() {
            frame();
        }
    };

    private void frame() {
        mGameView.next();

        //make a new frame() call in FRAME_RATE millisecond
        frameHandler.postDelayed(frameUpdate, FRAME_RATE);
    }

}
