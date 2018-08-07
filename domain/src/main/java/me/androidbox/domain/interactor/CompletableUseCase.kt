package me.androidbox.domain.interactor

import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import me.androidbox.domain.executor.PostExecutionThread

abstract class CompletableUseCase<in Params> constructor(
        private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseCompletable(params: Params? = null): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params? = null) {
        val completable = buildUseCaseCompletable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)

        addDisposable(completable.subscribeWith(observer))
    }

    fun dispose() {
        if(!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposableCompletableObserver: DisposableCompletableObserver) {
        disposables.add(disposableCompletableObserver)
    }
}
