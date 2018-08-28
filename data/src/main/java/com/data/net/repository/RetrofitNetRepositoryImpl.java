package com.data.net.repository;

import com.data.net.repository.datasource.NetDataSource;
import com.domain.repository.NetRepository;

public class RetrofitNetRepositoryImpl implements NetRepository {

    private NetDataSource mRetrofitNetDataSource;

    public RetrofitNetRepositoryImpl(NetDataSource netDataSource) {
        mRetrofitNetDataSource = netDataSource;
    }

}
