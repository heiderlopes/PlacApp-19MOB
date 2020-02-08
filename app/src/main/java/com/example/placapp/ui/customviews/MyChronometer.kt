package com.example.placapp.ui.customviews

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer

class MyChronometer : Chronometer {

    private var lastPause: Long = 0

    init {
        lastPause = SystemClock.elapsedRealtime()
    }
    var isRunning = false
        private set

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun start() {
        super.start()
        this.base = this.base + SystemClock.elapsedRealtime() - lastPause
        isRunning = true
    }

    override fun stop() {
        super.stop()
        lastPause = SystemClock.elapsedRealtime()
        isRunning = false
    }

}