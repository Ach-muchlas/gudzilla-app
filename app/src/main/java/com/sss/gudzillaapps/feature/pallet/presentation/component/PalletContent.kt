package com.sss.gudzillaapps.feature.pallet.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import com.sss.gudzillaapps.feature.pallet.presentation.PalletViewModel

@Composable
fun PalletContent(
    viewModel: PalletViewModel,
    onBackButtonClicked: () -> Unit,
) {

    val menuItems by viewModel.menuPalletItems.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLayout)
            .padding(Dimens.MediumMargin),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        CustomTopBar(
            title = "Menu Pallet",
            onBackClick = onBackButtonClicked
        )

        PalletMenu(
            items = menuItems,
            onClickedMenu = viewModel::onMenuClicked,
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun PalletMenu(items: List<MenuData>, onClickedMenu: (MenuData) -> Unit, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin),
        contentPadding = PaddingValues(
            top = Dimens.MediumMargin,
            bottom = Dimens.MediumMargin
        ),
    ) {
        items(items) { item ->
            MenuListCard(menuData = item, onClick = onClickedMenu)
        }
    }
}


// TODO : beranda (pallet), dan pallet (detail pallete, inbound, outbound), inbound ( tombol tambah untuk header),
// TODO : FORM TAMBAH HEADER : pilih po (tambah po)