package com.velocity.db.doc

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("events")
data class Event(
    @Id val id: String?,
    val name: String?,
    val description: String?,
    @Indexed val type: String,
    val location: String,
    val data: Any?
)