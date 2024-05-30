package com.example.aqua_care

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.Navigation.Navigation
import com.example.aqua_care.ViewModel.DataStoreViewModel

class MainActivity : ComponentActivity() {
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!hasRequiredPermission()) {
            ActivityCompat.requestPermissions(this, CAMERAX_PERMISSION, 0)
        }
        super.onCreate(savedInstanceState)
        userPreferences = UserPreferences(applicationContext)
        val viewModel: DataStoreViewModel by viewModels {
            MainViewModelFactory(userPreferences)
        }
        installSplashScreen()
        setContent {
            Navigation(context = applicationContext, viewModel = viewModel)
        }
    }

    private fun hasRequiredPermission(): Boolean {
        return CAMERAX_PERMISSION.all {
            ContextCompat.checkSelfPermission(applicationContext, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private val CAMERAX_PERMISSION = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
        )
        internal const val REQUEST_CODE_PERMISSIONS = 10
    }
}
