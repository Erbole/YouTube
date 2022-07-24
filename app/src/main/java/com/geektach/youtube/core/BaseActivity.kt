package com.geektach.youtube.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        chekInternet()
        initViewModel()
        setUI()
        initClick()
    }

    abstract fun chekInternet()

    abstract fun initViewModel()

    abstract fun setUI()

    abstract fun initClick()
}