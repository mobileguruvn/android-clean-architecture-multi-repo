package com.brian.ridertrackingapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.auth_contract.AuthNavigator
import com.brian.tracking_contract.TrackingNavigator
import com.brian.trip_contract.TripNavigator

@Composable
fun AppNavigation(
    authNavigator: AuthNavigator,
    tripNavigator: TripNavigator,
    trackingNavigator: TrackingNavigator,
    contentPaddingValues: PaddingValues
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        with(authNavigator.authGraph {
            navController.navigate("trip-list")
        }) { this() }

        with(tripNavigator.tripGraph {
            navController.navigate("tracking")
        }) { this() }

        with(trackingNavigator.trackingGraph()) {
            this()
        }

        composable("done") {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(contentPaddingValues)) {
                Text("Navigation Done!")
            }
        }
    }
}