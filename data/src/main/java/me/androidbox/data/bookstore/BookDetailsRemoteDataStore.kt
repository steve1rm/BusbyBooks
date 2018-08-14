package me.androidbox.data.bookstore

import io.reactivex.Completable
import io.reactivex.Observable
import me.androidbox.data.entites.BookDetailsEntity
import me.androidbox.data.respository.BookDetailsDataStore
import me.androidbox.data.respository.BookDetailsRemote
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class BookDetailsRemoteDataStore @Inject constructor(
        private val bookDetailsRemote: BookDetailsRemote)
    : BookDetailsDataStore {

    override fun getBookDetails(): Observable<MutableList<BookDetailsEntity>> {
        return bookDetailsRemote.getBookDetails()
    }

    override fun saveBookDetails(bookDetails: MutableList<BookDetailsEntity>): Completable {
        throw UnsupportedOperationException("Saving book details is not supported")
    }

    override fun clearBookDetails(): Completable {
        throw UnsupportedOperationException("clearing books details is not supported")
    }
}
