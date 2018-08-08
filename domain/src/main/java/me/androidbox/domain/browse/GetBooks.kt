package me.androidbox.domain.browse

import io.reactivex.Observable
import me.androidbox.domain.executor.PostExecutionThread
import me.androidbox.domain.interactor.ObservableUseCase
import me.androidbox.domain.models.BookDetails
import me.androidbox.domain.repository.BooksRepository
import javax.inject.Inject

class GetBooks @Inject constructor(
        private val booksRepository: BooksRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<BookDetails>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<BookDetails>> {
        return booksRepository.getBooksDetails()
    }
}