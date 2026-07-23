package com.sss.gudzillaapps.feature.add_item_purchase_order.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.sss.gudzillaapps.common.component.CustomDropdownTextField
import com.sss.gudzillaapps.common.component.CustomTextField
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Dimens.TitleAppBar
import com.sss.gudzillaapps.common.theme.Primary

@Composable
fun AddItemPurchaseOrderForm(
    focusManager: FocusManager
) {

    val listItem = listOf("Luwak", "Mie burung dara", "zenlatte")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumMargin)
    ) {
        Text(
            text = "Form Tambah Item",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = BodyPopBold.copy(color = Primary, fontSize = TitleAppBar)
        )

        Spacer(modifier = Modifier.height(Dimens.LargeMargin))

        // item name and item id
        Text(
            text = "Item",
            style = BodyPopBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.ExtraExtraSmallCornerRadius)
        )
        Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

        CustomDropdownTextField(
            label = "Pilih Item",
            items = listItem,
            selectedItem = "",
            enabled = true,
            onItemSelected = {},
            itemText = { it }
        )

        Text(
            text = "Qty",
            style = BodyPopBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.ExtraExtraSmallCornerRadius)
        )

        Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

        CustomTextField(
            value = "",
            onValueChange = {},
            hint = "Masukkan quantity",
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
        )
    }

}