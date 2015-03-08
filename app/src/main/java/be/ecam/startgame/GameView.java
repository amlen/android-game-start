package be.ecam.startgame;

import android.graphics.Canvas;
import android.view.View;
import android.graphics.Paint;
import android.content.Context;
import android.util.AttributeSet;


/**
 * Created by qlurkin on 8/03/15.
 */
public class GameView extends View {

    private Paint mPaint;
    private Ball mBall;

    public GameView(Context context, AttributeSet aSet) {
        super(context, aSet);

        mPaint = new Paint();
        mBall = new Ball(20, 20, 10, 10, 10);
    }

    public void next() {
        if(mBall.x+mBall.radius > getWidth() || mBall.x-mBall.radius < 0)
            mBall.verticalHit();
        if(mBall.y+mBall.radius > getHeight() || mBall.y-mBall.radius < 0)
            mBall.horizontalHit();
        mBall.next();
        invalidate();
    }

    @Override
    synchronized public void onDraw(Canvas canvas) {
        canvas.drawCircle(mBall.x, mBall.y, mBall.radius, mPaint);
    }

}
