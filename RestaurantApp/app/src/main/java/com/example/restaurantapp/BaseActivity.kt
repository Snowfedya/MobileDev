
package com.example.restaurantapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "${javaClass.simpleName} - onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "${javaClass.simpleName} - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "${javaClass.simpleName} - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "${javaClass.simpleName} - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "${javaClass.simpleName} - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "${javaClass.simpleName} - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "${javaClass.simpleName} - onDestroy")
    }
}
