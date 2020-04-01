package com.velocity.db.repo

import com.velocity.db.doc.Event
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository: MongoRepository<Event, String> {
}