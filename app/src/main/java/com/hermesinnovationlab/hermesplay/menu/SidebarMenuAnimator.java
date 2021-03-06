/*===============================================================================
Copyright (c) 2016 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.hermesinnovationlab.hermesplay.menu;

import android.animation.Animator;
import android.animation.ValueAnimator;


public class SidebarMenuAnimator extends ValueAnimator implements
    ValueAnimator.AnimatorUpdateListener, ValueAnimator.AnimatorListener
{
    
    private static long MENU_ANIMATION_DURATION = 300;
    private SidebarMenu mSidebarMenu;
    private float mMaxX;
    private float mEndX;
    
    
    public SidebarMenuAnimator(SidebarMenu menu)
    {
        mSidebarMenu = menu;
        setDuration(MENU_ANIMATION_DURATION);
        addUpdateListener(this);
        addListener(this);
    }
    
    
    @Override
    public void onAnimationUpdate(ValueAnimator animation)
    {
        Float f = (Float) animation.getAnimatedValue();
        mSidebarMenu.setAnimationX(f.floatValue());
    }
    
    
    @Override
    public void onAnimationCancel(Animator animation)
    {
    }
    
    
    @Override
    public void onAnimationEnd(Animator animation)
    {
        mSidebarMenu.setDockMenu(mEndX == mMaxX);
        if (mEndX == 0)
            mSidebarMenu.hide();
    }
    
    
    @Override
    public void onAnimationRepeat(Animator animation)
    {
    }
    
    
    @Override
    public void onAnimationStart(Animator animation)
    {
    }
    
    
    public void setStartEndX(float start, float end)
    {
        mEndX = end;
        setFloatValues(start, end);
        setDuration((int) (MENU_ANIMATION_DURATION * (Math.abs(end - start) / mMaxX)));
    }
    
    
    public void setMaxX(float maxX)
    {
        mMaxX = maxX;
    }
    
}
