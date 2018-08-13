package me.androidbox.data.respository

import io.reactivex.Completable
import io.reactivex.Observable
import me.androidbox.data.entites.BookDetailsEntity
import javax.inject.Inject

class BookDetailsCacheDataStore @Inject constructor(
        private val bookDetailsCache: BookDetailsCache) : BookDetailsDataStore {
    override fun getBookDetails(): Observable<MutableList<BookDetailsEntity>> {
        bookDetailsCache.getBookDetails()
    }

    override fun saveBookDetails(bookDetails: MutableList<BookDetailsEntity>): Completable {
        bookDetailsCache.saveBookDetails()
    }

    override fun clearBookDetails(): Completable {
        bookDetailsCache.clearBookDetailsCache()
    }
}