package com.termux.view.support;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;

public class TypefaceData {
    /** The width of a single mono spaced character obtained by {@link Paint#measureText(String)} on a single 'X'. */
    public final float mFontWidth;
    /** The {@link Paint#getFontSpacing()}. See http://www.fampennings.nl/maarten/android/08numgrid/font.png */
    public final int mFontLineSpacing;
    /** The {@link Paint#ascent()}. See http://www.fampennings.nl/maarten/android/08numgrid/font.png */
    public final int mFontAscent;
    /** The {@link #mFontLineSpacing} + {@link #mFontAscent}. */
    public final int mFontLineSpacingAndAscent;
    public final float[] asciiMeasures = new float[127];

    public TypefaceData(Paint textPaint, int textSize) {
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(textSize);

        mFontLineSpacing = (int) Math.ceil(textPaint.getFontSpacing());
        mFontAscent = (int) Math.ceil(textPaint.ascent());
        mFontLineSpacingAndAscent = mFontLineSpacing + mFontAscent;
        mFontWidth = textPaint.measureText("X");

        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < asciiMeasures.length; i++) {
            sb.setCharAt(0, (char) i);
            asciiMeasures[i] = textPaint.measureText(sb, 0, 1);
        }
    }

}
