package be.ecam.startgame;

/**
 * Created by qlurkin on 8/03/15.
 */

import android.graphics.PointF;

public class Ball extends PointF{
    public float radius;
    private PointF speed;

    public Ball(float x, float y, float radius, float speedX, float speedY) {
        super(x,y);

        this.radius = radius;
        speed = new PointF(speedX,speedY);
    }

    public void next() {
        x += speed.x;
        y += speed.y;
    }

    public void verticalHit() {
        speed.x = -speed.x;
    }

    public void horizontalHit() {
        speed.y = -speed.y;
    }
}
