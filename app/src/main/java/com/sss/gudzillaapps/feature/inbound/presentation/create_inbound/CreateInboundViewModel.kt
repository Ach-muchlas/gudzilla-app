package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound

import androidx.lifecycle.ViewModel
import com.sss.gudzillaapps.feature.purchase_order.domain.usecase.InsertPurchaseOrderUseCase

class CreateInboundViewModel(private val insPurchaseOrderUseCase: InsertPurchaseOrderUseCase) :
    ViewModel() {
}