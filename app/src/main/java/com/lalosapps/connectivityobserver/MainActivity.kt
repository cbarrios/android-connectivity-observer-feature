package com.lalosapps.connectivityobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lalosapps.connectivityobserver.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityObserver: ConnectivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        lifecycleScope.launch {
            connectivityObserver.observeStatus()
                .flowWithLifecycle(lifecycle)
                .collect {
                    binding.networkStatus.text = it.name
                }
        }
    }
}