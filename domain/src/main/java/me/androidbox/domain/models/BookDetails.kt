package me.androidbox.domain.models

import org.parceler.Parcel
import org.parceler.ParcelConstructor

//@Parcel(Parcel.Serialization.BEAN)
class BookDetails(
        val title: String,
        val description: String,
        val author: String,
        val price: Float)
