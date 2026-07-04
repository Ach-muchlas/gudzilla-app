package com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.component

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.component.CustomFloatingActionButton
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.inbound.data.model.HeaderTransactionPallet
import com.sss.gudzillaapps.feature.inbound.data.model.listHeaderTransaction
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.ShowAlertOptionScanOrManual

@Composable
fun ListInboundContent(
    onBackButtonClicked: () -> Unit,
    onAddButtonClicked : () -> Unit
) {
    var isAlertVisible by remember { mutableStateOf(false) }

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
                onBackClick = onBackButtonClicked,
            )

            ListInboundMenu(
                items = listHeaderTransaction,
                onClicked = {},
                modifier = Modifier.weight(1f)
            )
        }

        CustomFloatingActionButton(
            onClick = onAddButtonClicked,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 20.dp, bottom = 20.dp
                )
        )
    }
}

@Composable
fun ListInboundMenu(
    items: List<HeaderTransactionPallet>,
    onClicked: () -> Unit,
    modifier: Modifier,
) {
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