package com.sss.gudzillaapps.network.constanta

import com.sss.gudzillaapps.common.manager.ServerManager

object UrlConstant {
    fun urlDomain () : String = ServerManager.getInstance().getServerAddress().trimEnd('/') + "/dashboard_api/public/"
}