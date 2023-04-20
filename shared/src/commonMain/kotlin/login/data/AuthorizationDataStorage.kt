package login.data

import nanit.mobile.coreNetwork.common.authorization.AuthorizationDataStorage

open class AuthorizationDataStorageImpl: AuthorizationDataStorage {
    override suspend fun getAccessToken(userId: Long) = null

    override suspend fun getCurrentAccessToken() = null

    override suspend fun getRefreshToken(userId: Long) = null

    override suspend fun removeTokensAndUserData() = Unit

    override suspend fun storeTokens(
        userId: Long,
        token: String,
        accessToken: String,
        refreshToken: String,
    ) = Unit

}