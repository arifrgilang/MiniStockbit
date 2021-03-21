package com.arifrgilang.domain

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class WebSocketUseCase<Results, Params>(
    private val jobScheduler: Scheduler = Schedulers.io(),
    private val postScheduler: Scheduler = AndroidSchedulers.mainThread()
) {
    private var disposables = CompositeDisposable()

    abstract fun buildFlowableUseCase(params: Params): Flowable<Results>

    fun execute(params: Params, onSuccess: (Results) -> Unit, onError: (Throwable) -> Unit){
        disposables.add(
            buildFlowableUseCase(params)
                .subscribeOn(jobScheduler)
                .observeOn(postScheduler)
                .doOnError{ it.printStackTrace() }
                .subscribe(
                    { onSuccess(it) },
                    { onError(it) }
                )
        )
    }

    open fun dispose(){
        if(!disposables.isDisposed){
            disposables.dispose()
        }
    }

    class None
}