package com.edon.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edon.mvvm_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bnd: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bnd.root)
    }
}