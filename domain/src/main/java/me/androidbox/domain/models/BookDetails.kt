package me.androidbox.domain.models

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class BookDetails @ParcelConstructor constructor(val title: String,
                                                      val description: String,
                                                      val author: String,
                                                      val price: Int)
