package com.example.pc02_moviles_22200125_22200111.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pc02_moviles_22200125_22200111.ui.team_list.TeamListScreen
import com.example.pc02_moviles_22200125_22200111.ui.team_registration.TeamRegistrationScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "team_list") {
        composable("team_list") {
            TeamListScreen(onAddTeam = { navController.navigate("team_registration") })
        }
        composable("team_registration") {
            TeamRegistrationScreen(onTeamRegistered = {
                navController.popBackStack()
            })
        }
    }
}