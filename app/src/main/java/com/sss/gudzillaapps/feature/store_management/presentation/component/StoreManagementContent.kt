package com.sss.gudzillaapps.feature.store_management.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sss.gudzillaapps.common.component.CustomFilterChip
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.store_management.presentation.component.section.TotalCardSection
import com.sss.gudzillaapps.feature.store_management.presentation.component.section.TotalPalletActiveSection

@Composable
fun StoreManagementContent() {
    val dummyPallet = listOf("A1", "A2", "A3", "B1", "B2", "C1", "C2", "C3", "D1")
    val dummyZones = listOf("Zona 1", "Zona 2", "Zona 3", "Zona Floor")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumMargin)
            .background(BackgroundLayout)
    ) {
        CustomTopBar("Store Management", onBackClick = {})
        Spacer(Modifier.height(Dimens.SmallMargin))

        Column(
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin)
        ) {
            TotalPalletActiveSection()
            TotalCardSection()
        }

        Spacer(modifier = Modifier.height(Dimens.LargeMargin))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.ExtraExtraSmallCornerRadius)
        ) {
            items(dummyZones) { item ->
                CustomFilterChip(
                    text = item, selected = true, onClick = {})
            }
        }

        Spacer(modifier = Modifier.height(Dimens.MediumMargin))

        LocationCard(pallet = dummyPallet)
    }


}