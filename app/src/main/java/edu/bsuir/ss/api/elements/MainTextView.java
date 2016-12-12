package edu.bsuir.ss.api.elements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Antony on 04.12.2016.
 */
public class MainTextView extends TextView {
    public MainTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Bungee-Regular.ttf"));

    }
}
