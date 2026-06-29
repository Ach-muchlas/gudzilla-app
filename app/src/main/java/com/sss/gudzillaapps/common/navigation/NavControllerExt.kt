package com.sss.gudzillaapps.common.navigation

import androidx.navigation.NavController

fun NavController.navigateToDestination(destination: RouteDestination) {
    when (destination) {
        RouteDestination.LoginToHome -> {
            navigate(Routes.HOME) {
                popUpTo(0) { inclusive = true }
                launchSingleTop = true
            }
        }

        RouteDestination.LoginToConnection -> {
            navigate(Routes.LOGIN) {
                popUpTo(Routes.CONNECTION) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }

        RouteDestination.HomeToMenuPallet -> {
            navigate(Routes.PALLET) {
                launchSingleTop = true
            }
        }

        RouteDestination.PalletToInbound -> {
            navigate(Routes.INBOUND) {
                launchSingleTop = true
            }
        }

        RouteDestination.ListInboundPalletToCreateInbound -> {
            navigate(Routes.CREATE_INBOUND){
                launchSingleTop = true
            }
        }
    }
}