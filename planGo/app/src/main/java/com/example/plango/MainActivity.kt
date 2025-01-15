package com.example.plango

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.plango.ui.screen.AddTripScreen
import com.example.plango.ui.screen.HomeScreen
import com.example.plango.ui.screen.SettingsScreen
import com.example.plango.ui.screen.SplashScreen
import com.example.plango.ui.screen.TripDetailsScreen
import com.example.plango.ui.screen.WelcomeScreen
import com.example.plango.ui.screen.route.Routes
import com.example.plango.ui.theme.PlanGoTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            PlanGoTheme(darkTheme = themeViewModel.isDarkMode.value){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.Splash
                ) {
                    composable(Routes.Splash) {
                        SplashScreen(onNavigateToWelcome = { navController.navigate(Routes.Welcome) })
                    }
                    composable(Routes.Welcome) {
                        WelcomeScreen(onNavigateToHome = { navController.navigate(Routes.Home) })
                    }
                    composable(Routes.Home) {
                        HomeScreen(
                            onNavigateToAddTrip = { navController.navigate(Routes.AddTrip) },
                            onNavigateToTripDetails = { selectedTrip ->
                                navController.navigate("trip_details/${selectedTrip.id}")
                            },
                            onNavigateToSettings = { navController.navigate(Routes.Settings) }
                        )
                    }
                    composable(Routes.AddTrip) {
                        AddTripScreen(onNavigateToHome = { navController.navigate(Routes.Home) })
                    }
                    composable(
                        route = Routes.TripDetails,
                        arguments = listOf(navArgument("tripId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val tripId = backStackEntry.arguments?.getString("tripId")
                        TripDetailsScreen(
                            tripId = tripId,
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable(Routes.Settings) {
                        SettingsScreen(
                            themeViewModel = themeViewModel,
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}