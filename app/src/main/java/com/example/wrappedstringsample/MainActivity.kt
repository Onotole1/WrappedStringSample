package com.example.wrappedstringsample

import android.widget.TextView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    init {
        moxyPresenter {
            MainPresenter()
        }
    }

    private val buggyString: TextView by lazy {
        findViewById(R.id.buggyString)
    }

    private val wrappedString: TextView by lazy {
        findViewById(R.id.wrappedString)
    }

    override fun setState(state: MainScreenState) {
        buggyString.text = state.string
        wrappedString.setText(state.wrappedString)
    }
}