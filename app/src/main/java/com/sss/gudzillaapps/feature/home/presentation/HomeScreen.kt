package com.sss.gudzillaapps.feature.home.presentation

import androidx.compose.runtime.Composable
import com.sss.gudzillaapps.common.navigation.RouteDestination
import com.sss.gudzillaapps.feature.home.presentation.component.HomeContent
import com.sss.gudzillaapps.feature.home.presentation.event.HomeNavEventHandler
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigate: (RouteDestination) -> Unit,
) {
    HomeNavEventHandler(viewModel, onNavigate)
    HomeContent(viewModel)
}

