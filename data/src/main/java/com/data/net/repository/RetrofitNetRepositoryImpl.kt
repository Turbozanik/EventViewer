package com.data.net.repository

import com.data.net.datasource.NetDataSource
import com.data.net.pojo.User
import com.data.transformers.user.UserToUserDtoTransformer
import com.domain.models.UserDto
import com.domain.repository.NetRepository
import io.reactivex.Flowable

class RetrofitNetRepositoryImpl(netDataSource: NetDataSource) : NetRepository {

	private val mNetDataSource: NetDataSource = netDataSource
	private val mResponseHelper: BaseResponseHelper = BaseResponseHelper()
	private val mUserTransformer: UserToUserDtoTransformer = UserToUserDtoTransformer()

	override fun register(body: Map<String, String?>): Flowable<UserDto> {
		return mResponseHelper.unwrapBaseResponse(
				mResponseHelper.validateFlowable(mNetDataSource.register(body)))
				.flatMap { user: User ->
					Flowable.just(mUserTransformer.transform(user))
				}
	}

	override fun login(body: Map<String, String?>): Flowable<UserDto> {
		return mResponseHelper.unwrapBaseResponse(
				mResponseHelper.validateFlowable(mNetDataSource.login(body)))
				.flatMap { user: User -> Flowable.just(mUserTransformer.transform(user)) }
	}

}
