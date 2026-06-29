package com.sss.gudzillaapps.common.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sss.gudzillaapps.common.navigation.Routes.CONNECTION
import com.sss.gudzillaapps.common.navigation.Routes.CREATE_INBOUND
import com.sss.gudzillaapps.common.navigation.Routes.HOME
import com.sss.gudzillaapps.common.navigation.Routes.INBOUND
import com.sss.gudzillaapps.common.navigation.Routes.LOGIN
import com.sss.gudzillaapps.common.navigation.Routes.PALLET
import com.sss.gudzillaapps.feature.connection.presentation.ConnectionScreen
import com.sss.gudzillaapps.feature.home.presentation.HomeScreen
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.CreateInboundScreen
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.ListInboundScreen
import com.sss.gudzillaapps.feature.login.presentation.LoginScreen
import com.sss.gudzillaapps.feature.pallet.presentation.PalletScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
//    val session = remember { SessionManager.getInstance() }

//    val startDestination = remember {
//        if (session.isFirstTime()) {
//            CONNECTION
//        } else {
//            if (session.isUserLogin()) HOME else LOGIN
//        }
//    }
    val startDestination = LOGIN

    NavHost(navController = navController, startDestination = startDestination) {

        composable(LOGIN) {
            LoginScreen(
                onSettingConnection = { navController.navigateToDestination(RouteDestination.LoginToConnection) },
                onSuccessLogin = { navController.navigateToDestination(RouteDestination.LoginToHome) })
        }

        composable(CONNECTION) {
            ConnectionScreen()
        }

        composable(HOME) {
            HomeScreen(onNavigate = { destination ->
                navController.navigateToDestination(destination)
            })
        }

        composable(PALLET) {
            PalletScreen(
                onNavigate = { destination -> navController.navigateToDestination(destination) },
                navBack = { navController.popBackStack() })
        }

        composable(INBOUND) {
            ListInboundScreen(
                navBack = { navController.popBackStack() },
                navOnCreateHeader = { navController.navigateToDestination(RouteDestination.ListInboundPalletToCreateInbound) })
        }

        composable(CREATE_INBOUND) {
            CreateInboundScreen()
        }
    }
}