package com.kerboocorp.bb.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

import com.kerboocorp.bb.R;

import java.io.InputStream;

/**
 * Created by cgo on 25/02/2015.
 */
public class AnimatedImageView extends View {

    private Movie movie;
    private long movieStart;

    public AnimatedImageView(Context context) {
        super(context);
        initializeView();
    }

    public AnimatedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public AnimatedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView();
    }

    private void initializeView() {
        //R.drawable.loader - our animated GIF
        InputStream is = getContext().getResources().openRawResource(R.drawable.genevievemorton);
        movie = Movie.decodeStream(is);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        super.onDraw(canvas);
        long now = android.os.SystemClock.uptimeMillis();
        if (movieStart == 0) {
            movieStart = now;
        }
        if (movie != null) {
            int relTime = (int) ((now - movieStart) % movie.duration());
            movie.setTime(relTime);
            movie.draw(canvas, getWidth() - movie.width(), getHeight() - movie.height());
            this.invalidate();
        }
    }
}
