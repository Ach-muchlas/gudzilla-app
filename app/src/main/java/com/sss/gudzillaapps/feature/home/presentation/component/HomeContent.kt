package com.sss.gudzillaapps.feature.home.presentation.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.theme.BodyBitterBold
import com.sss.gudzillaapps.common.theme.BodyBitterMedium
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import com.sss.gudzillaapps.feature.home.presentation.HomeViewModel

@Composable
fun HomeHeader() {
    Column(
        modifier = Modifier.padding(horizontal = Dimens.LargeMargin)
    ) {
        Spacer(Modifier.height(30.dp))

        Row {
            Text("Hello, ", style = BodyBitterBold.copy(fontSize = 25.sp))
            Image(
                painter = painterResource(R.drawable.icon_hello),
                contentDescription = "Icon Hello",
                Modifier.size(28.dp)
            )
        }

        Spacer(Modifier.height(3.dp))

        Row {
            Text(
                "Achmad Muchlasin", style = BodyBitterBold.copy(
                    color = Primary, fontSize = 25.sp, fontWeight = FontWeight.Bold
                )
            )
            Text(
                " !! ", style = BodyBitterBold.copy(color = Primary, fontSize = 25.sp)
            )
            Spacer(Modifier.weight(1f))
        }
        Spacer(Modifier.height(3.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null,
                tint = Primary,
                modifier = Modifier.size(18.dp)
            )

            Spacer(Modifier.width(3.dp))

            Text(
                "Kantor Pusat", style = BodyBitterMedium.copy(color = Gray)
            )

            Spacer(Modifier.width(3.dp))

            Text(
                text = " • ",
                style = BodyBitterMedium.copy(color = Gray) // Mengikuti warna teks atau disesuaikan
            )

            Spacer(Modifier.width(3.dp))

            Text(
                text = " Android Developer",
                style = BodyBitterMedium.copy(color = Gray) // Mengikuti warna teks atau disesuaikan
            )
        }
    }
}


@Composable
fun HomeMenu(menus: List<MenuData>, onMenuClicked: (MenuData) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin),
        horizontalArrangement = Arrangement.spacedBy(Dimens.MediumMargin),
        contentPadding = PaddingValues(
            top = Dimens.MediumMargin, bottom = Dimens.MediumMargin
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumMargin)
    ) {
        items(menus) { item ->
            MenuCard(
                menuData = item, onClick = onMenuClicked
            )
        }
    }
}


@Composable
fun HomeContent(viewModel: HomeViewModel) {

    val menuItems by viewModel.menuItems.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFFBF5), Color(0xFFF7F7F7), Color(0xFFF1F1F1)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding(),
        ) {

            Spacer(Modifier.height(Dimens.ExtraLargeMargin))
            HomeHeader()
            Spacer(Modifier.height(Dimens.SmallMargin))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.LargeMargin),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                StorageMenuCard(
                    percentage = 82,
                    modifier = Modifier.weight(1f),
                    onClick = { /* Handle klik storage */ }
                )

                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(Dimens.SmallMargin))
            HomeMenu(menus = menuItems, onMenuClicked = viewModel::onMenuClicked)
        }
    }
}