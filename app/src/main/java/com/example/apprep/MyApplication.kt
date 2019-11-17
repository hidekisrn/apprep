package com.example.apprep

import android.app.Application
import io.paperdb.Paper

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Paper.init(this)

    }
}