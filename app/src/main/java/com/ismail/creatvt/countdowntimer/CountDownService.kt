package com.ismail.creatvt.countdowntimer

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CountDownService : Service() {

    companion object{
        const val MINS_VALUE = "MinsValue"
        const val SECS_VALUE = "SecsValue"

        const val ACTION_START = "countdowntimer.intent.action.START"
        const val ACTION_STOP = "countdowntimer.intent.action.STOP"
        const val ACTION_PAUSE = "countdowntimer.intent.action.PAUSE"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        val mins = intent?.getIntExtra(MINS_VALUE, 0)?:0
        val sec = intent?.getIntExtra(SECS_VALUE, 0)?:0

        when(action){
            ACTION_START -> onStartTimer(mins, sec)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun onStartTimer(mins: Int, sec: Int) {

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
