package com.pythoncat.h5.base;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by pythonCat on 2016/11/27 0027.
 * @apiNote base activity
 */

public class BaseActivity extends AppCompatActivity {

    protected void bindBufferKnife2Self() {
        ButterKnife.bind(this);
    }

    protected AppCompatActivity get() {
        return this;
    }
}
