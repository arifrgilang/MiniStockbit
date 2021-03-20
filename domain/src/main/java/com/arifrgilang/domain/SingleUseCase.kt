package com.arifrgilang.domain

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<Results, Params>(
    private val jobScheduler: Scheduler = Schedulers.io(),
    private val postScheduler: Scheduler = AndroidSchedulers.mainThread()
){
    private var disposables = CompositeDisposable()

    abstract fun buildSingleUseCase(params: Params): Single<Results>

    fun execute(params: Params, onSuccess: (Results) -> Unit, onError: (Throwable) -> Unit){
        disposables.add(
            buildSingleUseCase(params)
                .subscribeOn(jobScheduler)
                .observeOn(postScheduler)
                .doOnError{ it.printStackTrace() }
                .onErrorResumeNext{
                    it.printStackTrace()
                    Single.error(it)
                }
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