package com.sss.gudzillaapps.feature.inbound.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.inbound.data.model.HeaderTransactionPallet
import com.sss.gudzillaapps.feature.inbound.data.model.listHeaderTransaction

@Composable
fun InboundContent(
    onBackButtonClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLayout)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.MediumMargin),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            CustomTopBar(
                title = "Menu Pallet",
                showRightIcon = true,
                iconRight = R.drawable.icon_add_rounded,
                onBackClick = onBackButtonClicked,
            )

            InboundMenu(
                items = listHeaderTransaction,
                onClicked = {},
                modifier = Modifier.weight(1f)
            )
        }

    }
}

@Composable
fun InboundMenu(items: List<HeaderTransactionPallet>, onClicked: () -> Unit, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin),
        contentPadding = PaddingValues(
            top = Dimens.MediumMargin,
            bottom = Dimens.MediumMargin
        )
    ) {
        items(items) { item ->
            InboundCard(data = item, onCLick = onClicked)
        }
    }
}