package com.brian.ridertrackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.brian.auth_contract.AuthNavigator
import com.brian.ridertrackingapp.navigation.AppNavigation
import com.brian.ridertrackingapp.ui.theme.RiderTrackingAppTheme
import com.brian.tracking_contract.TrackingNavigator
import com.brian.trip_contract.TripNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authNavigator: AuthNavigator

    @Inject
    lateinit var tripNavigator: TripNavigator

    @Inject
    lateinit var trackingNavigator: TrackingNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RiderTrackingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        authNavigator = authNavigator,
                        tripNavigator = tripNavigator,
                        trackingNavigator = trackingNavigator,
                        contentPaddingValues = innerPadding
                    )
                }
            }
        }
    }
}
