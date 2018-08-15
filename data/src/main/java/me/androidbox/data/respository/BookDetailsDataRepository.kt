package me.androidbox.data.respository

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import me.androidbox.data.bookstore.BookDetailsDataStoreFactory
import me.androidbox.data.mapper.BookDetailMapper
import me.androidbox.domain.models.BookDetails
import me.androidbox.domain.repository.BooksRepository
import javax.inject.Inject

class BookDetailsDataRepository @Inject constructor(
        private val mapper: BookDetailMapper,
        private val cache: BookDetailsCache,
        private val factory: BookDetailsDataStoreFactory) : BooksRepository {

    override fun getBooksDetails(): Observable<MutableList<BookDetails>> {
        return Observable.zip(
                cache.areBookDetailsCached().toObservable(),
                cache.isBookDetailsCacheExpired().toObservable(),
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> {
                    areCached, isExpired -> Pair(areCached, isExpired)
                })
                .flatMap {
                    factory.getDataStore(it.first, it.second).getBookDetails()
                }
                .flatMap {
                    bookDetails -> factory.getCachedDataStore()
                        .saveBookDetails(bookDetails)
                        .andThen(Observable.just(bookDetails))
                }
                .map { result ->
                    result.map {
                        mapper.fromEntity(it)
                    }.toMutableList()
                }
    }
}
