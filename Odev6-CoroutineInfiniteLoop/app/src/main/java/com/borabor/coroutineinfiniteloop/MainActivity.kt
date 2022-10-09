package com.borabor.coroutineinfiniteloop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infiniteLoop()
    }

    /**
     * Creates infinite loop
     *
     */
    private fun infiniteLoop() {
        while (true) {
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer)
                }
            }

            count++
            println(count)
        }
    }

    /**
     * Simulates network call with 2 seconds delay
     *
     */
    private suspend fun doNetworkCall(): String {
        delay(2000L)
        return "Network Answer Called"
    }
}