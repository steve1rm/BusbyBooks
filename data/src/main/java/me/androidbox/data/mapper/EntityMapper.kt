package me.androidbox.data.mapper

interface EntityMapper<E, D> {
    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}