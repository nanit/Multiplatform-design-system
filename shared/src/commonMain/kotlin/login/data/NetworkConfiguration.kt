package login.data

import nanit.mobile.coreNetwork.common.logging.NetworkLogLevel
import nanit.mobile.coreNetwork.config.NetworkClientConfiguration


class NetworkConfiguration : NetworkClientConfiguration {
    override val appVersion = "1.0"
    override val baseUrl = "https://api-staging.nanit.com/"
    override val coralogixLogLevel = NetworkLogLevel.INFO
    override val deviceModel = "pixel 4"
    override val logLevel = NetworkLogLevel.ALL
    override val userAgent = ""
}