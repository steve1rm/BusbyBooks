package me.androidbox.data.respository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import me.androidbox.data.entites.BookDetailsEntity

interface BookDetailsCache {
    fun clearBookDetailsCache(): Completable

    fun saveBookDetails(bookDetailsEntity: MutableList<BookDetailsEntity>): Completable

    fun getBookDetails(): Observable<MutableList<BookDetailsEntity>>

    fun areBookDetailsCached(): Single<Boolean>

    fun setLastCacheTime(lastCache: Long): Completable

    fun isBookDetailsCacheExpired(): Single<Boolean>
}
