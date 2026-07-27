package com.sss.gudzillaapps.feature.store_management.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.component.textfield.CustomFilterChip
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.store_management.presentation.component.section.TotalCardSection
import com.sss.gudzillaapps.feature.store_management.presentation.component.section.TotalPalletActiveSection

@Composable
fun StoreManagementContent() {
    val dummyPallet = listOf(
        "A-01-A",
        "A-01-B",
        "A-01-C",
        "B-02-A",
        "B-02-B",
        "C-03-A",
        "C-03-B",
        "C-03-C",
        "D-04-A"
    )
    val dummyZones = listOf("Zona 1", "Zona 2", "Zona 3", "Zona Floor")

    // State untuk mengontrol scroll vertikal halaman
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumMargin)
            .background(BackgroundLayout)
    ) {
        // TopBar tetap ditaruh di luar scroll agar posisinya 'Sticky' (tidak ikut tenggelam saat di-scroll)
        CustomTopBar("Store Management", onBackClick = {})

        // Kontainer yang menampung seluruh konten yang bisa di-scroll ke bawah
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState) // KUNCI UTAMA: Mengaktifkan scroll vertikal halaman
        ) {
            Spacer(Modifier.height(Dimens.SmallMargin))

            Column(
                verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin)
            ) {
                TotalPalletActiveSection()
                TotalCardSection()
            }

            Spacer(modifier = Modifier.height(30.dp))

            // LazyRow untuk filter chip zona (tetap bisa di-scroll horizontal secara independen)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Dimens.ExtraExtraSmallCornerRadius),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(dummyZones) { item ->
                    CustomFilterChip(
                        text = item,
                        selected = true,
                        onClick = {}
                    )
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            // Komponen LocationCard premium Gudzilla Anda
            LocationCard(
                pallet = dummyPallet,
                isFull = true,
                availableText = "Available Space 20/250 Pallets",
                onManageZoneClick = {
                    // Aksi navigasi ke manage zone
                }
            )

            // Memberikan sedikit ruang kosong di paling bawah agar tidak terlalu mepet dengan ujung layar HP
            Spacer(modifier = Modifier.height(Dimens.MediumMargin))
        }
    }
}