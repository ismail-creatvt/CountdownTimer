package com.ismail.creatvt.countdowntimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ismail.creatvt.countdowntimer.CountDownService.Companion.ACTION_START
import com.ismail.creatvt.countdowntimer.CountDownService.Companion.MINS_VALUE
import com.ismail.creatvt.countdowntimer.CountDownService.Companion.SECS_VALUE
import com.ismail.creatvt.countdowntimer.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mins = MutableLiveData(0)
    private var sec = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Lifecycle owner is necessary for observing
        binding.lifecycleOwner = this

        binding.mins = mins
        binding.secs = sec

        //Adding increment operations

        mins_plus.setOnClickListener{
            if(mins.value?:0 < 59){
                mins.value = (mins.value?:0).inc()
            }
        }

        sec_plus.setOnClickListener{
            if(sec.value?:0 < 59){
                sec.value = (sec.value?:0).inc()
            }
        }

        mins_plus_10.setOnClickListener{
            if(mins.value?:0 < 50){
                mins.value = (mins.value?:0).plus(10)
            }
        }

        sec_plus_10.setOnClickListener{
            if(sec.value?:0 < 50){
                sec.value = (sec.value?:0).plus(10)
            }
        }



        //Adding decrement operations

        mins_minus.setOnClickListener{
            if(mins.value?:0 > 0){
                mins.value = (mins.value?:0).dec()
            }
        }

        sec_minus.setOnClickListener{
            if(sec.value?:0 > 0){
                sec.value = (sec.value?:0).dec()
            }
        }

        mins_minus_10.setOnClickListener{
            if(mins.value?:0 >= 10){
                mins.value = (mins.value?:0).minus(10)
            }
        }

        sec_minus_10.setOnClickListener{
            if(sec.value?:0 >= 10){
                sec.value = (sec.value?:0).minus(10)
            }
        }



        start_timer.setOnClickListener {
            timer_input_group.visibility = View.GONE
            val data = Intent(this, CountDownService::class.java)
            data.action = ACTION_START
            data.putExtra(MINS_VALUE, mins.value)
            data.putExtra(SECS_VALUE, sec.value)
            ContextCompat.startForegroundService(this, data)
        }
    }
}