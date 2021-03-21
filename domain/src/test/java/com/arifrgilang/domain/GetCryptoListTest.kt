package com.arifrgilang.domain

import androidx.lifecycle.LiveData
import com.arifrgilang.domain.model.*
import com.arifrgilang.domain.usecase.GetCryptoList
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.just
import org.junit.Before
import org.junit.Test

class GetCryptoListTest {
    @RelaxedMockK
    private lateinit var mockGetCryptoList: GetCryptoList
    private lateinit var requestParam: CryptoRequestParam

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        requestParam = CryptoRequestParam(1,50,"USD")
    }

    @Test
    fun givenRequestParam_whenFetchingCryptoList_shouldRun() {
        every { mockGetCryptoList.execute(requestParam, {}, {}) } just Runs
         mockGetCryptoList.execute(requestParam, {}, {})
    }
}