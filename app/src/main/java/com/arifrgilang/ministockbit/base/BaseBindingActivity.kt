package com.arifrgilang.ministockbit.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<T : ViewDataBinding> : AppCompatActivity(){

    @LayoutRes
    protected abstract fun contentView(): Int
    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun setupView()
    protected lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, contentView())
        setupData(savedInstanceState)
        setupView()
    }
}