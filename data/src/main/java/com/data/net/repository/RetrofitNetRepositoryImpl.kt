package com.data.net.repository

import com.data.net.pojo.User
import com.data.net.repository.datasource.NetDataSource
import com.data.net.transformers.user.UserToUserDtoTransformer
import com.domain.models.UserDto
import com.domain.repository.NetRepository
import io.reactivex.Flowable

class RetrofitNetRepositoryImpl(netDataSource: NetDataSource) : NetRepository {

    private val mNetDataSource: NetDataSource = netDataSource
    private val mResponseHelper: BaseResponseHelper = BaseResponseHelper()
    private val mUserTransformer: UserToUserDtoTransformer = UserToUserDtoTransformer()

    override fun register(): Flowable<UserDto?> {
        return mResponseHelper.unwrapBaseResponse(
                mResponseHelper.validateFlowable(mNetDataSource.register()))
                .flatMap { user: User? ->
                    Flowable.just(mUserTransformer.transform(user))
                }
    }
}
