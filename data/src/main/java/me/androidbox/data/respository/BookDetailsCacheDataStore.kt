package me.androidbox.data.respository

import io.reactivex.Completable
import io.reactivex.Observable
import me.androidbox.data.entites.BookDetailsEntity
import javax.inject.Inject

class BookDetailsCacheDataStore @Inject constructor(
        private val bookDetailsCache: BookDetailsCache) : BookDetailsDataStore {
    override fun getBookDetails(): Observable<MutableList<BookDetailsEntity>> {
        return bookDetailsCache.getBookDetails()
    }

    override fun saveBookDetails(bookDetails: MutableList<BookDetailsEntity>): Completable {
        return bookDetailsCache.saveBookDetails(bookDetails)
                .andThen(bookDetailsCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun clearBookDetails(): Completable {
        return bookDetailsCache.clearBookDetailsCache()
    }
}
