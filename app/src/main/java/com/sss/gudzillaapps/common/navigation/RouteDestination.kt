package com.sss.gudzillaapps.common.navigation

sealed class RouteDestination {
    data object LoginToHome : RouteDestination()
    data object LoginToConnection : RouteDestination()

    // Home Navigation
    data object HomeToMenuPallet : RouteDestination()
    data object HomeToStoreManagement : RouteDestination()


    // Menu pallet navigation
    data object PalletToInbound : RouteDestination()

    data object ListInboundPalletToCreateInbound : RouteDestination()
    data object CreateHeaderInboundToListPurchaseOrder : RouteDestination()

    data object ListPurchaseOrderToAddItemPurchaseOrder : RouteDestination()
}