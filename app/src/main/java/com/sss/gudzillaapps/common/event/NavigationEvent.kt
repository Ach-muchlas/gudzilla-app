package com.sss.gudzillaapps.common.event

import com.sss.gudzillaapps.common.navigation.RouteDestination

sealed class NavigationEvent {
    data class Navigate(val destination: RouteDestination) : NavigationEvent()
    data class Blocked(val message: String) : NavigationEvent()
}