package com.kuaidao.logger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.core.liblogger.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         Logger.d("123123123")

         Logger.d(Throwable("throwable"))


    }
}