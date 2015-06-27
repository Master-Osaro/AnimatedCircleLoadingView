package com.jlmd.android.circularloadinganimation.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.jlmd.android.circularloadinganimation.R;
import com.jlmd.android.circularloadinganimation.view.animator.AnimationState;

/**
 * @author jlmd
 */
public class RightCircleView extends ComponentViewAnimation {

  public RightCircleView(Context context, int parentWidth) {
    super(context, parentWidth);
  }

  public RightCircleView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public RightCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    drawCircle(canvas);
  }

  public void drawCircle(Canvas canvas) {
    Paint paint = new Paint();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(getResources().getColor(R.color.secondary_circle));
    canvas.drawCircle(getWidth() - 150, parentCenter - 50, circleRadius, paint);
  }

  public void startSecondaryCircleAnimation() {
    TranslateAnimation translateAnimation =
        new TranslateAnimation(getX(), getX(), getY(), getY() + 260);
    translateAnimation.setStartOffset(200l);
    translateAnimation.setDuration(1000l);

    AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
    alphaAnimation.setStartOffset(1300l);
    alphaAnimation.setDuration(200l);

    AnimationSet animationSet = new AnimationSet(true);
    animationSet.addAnimation(translateAnimation);
    animationSet.addAnimation(alphaAnimation);
    animationSet.setFillAfter(true);
    animationSet.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
        // Empty
      }

      @Override
      public void onAnimationEnd(Animation animation) {
        setState(AnimationState.SECONDARY_CIRCLE_FINISHED);
      }

      @Override
      public void onAnimationRepeat(Animation animation) {
        // Empty
      }
    });

    startAnimation(animationSet);
  }
}
