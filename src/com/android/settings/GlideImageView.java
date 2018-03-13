package com.android.settings;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class GlideImageView extends ImageView
{

    private int imageRes = 0;

    /**
     * @param context
     */
    public GlideImageView(Context context)
    {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public GlideImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

	TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GlideImageView, 0, 0);
        try {
             this.imageRes = ta.getResourceId(R.styleable.GlideImageView_source, 0);
        } finally {
            ta.recycle();
	}
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public GlideImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
	if(imageRes != 0)
		Glide.with(this.getContext()).load(imageRes).asGif().crossFade().into(this);
    }
}
