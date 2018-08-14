package me.androidbox.data.bookstore

import me.androidbox.data.respository.BookDetailsDataStore
import javax.inject.Inject

class BookDetailsDataStoreFactory @Inject constructor(
        private val bookDetailsCacheDataStore: BookDetailsCacheDataStore,
        private val bookDetailsRemoteDataStore: BookDetailsRemoteDataStore) {

    fun getDataStore(isBookDetailsCached: Boolean, hasCacheExpired: Boolean): BookDetailsDataStore {
        return if (isBookDetailsCached && !hasCacheExpired) {
            return bookDetailsCacheDataStore
        }
        else {
            bookDetailsRemoteDataStore
        }
    }

    fun getCachedDataStore(): BookDetailsDataStore {
        return bookDetailsCacheDataStore
    }
}
