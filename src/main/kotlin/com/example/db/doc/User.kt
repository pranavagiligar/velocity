package com.example.db.doc

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User(@Id var id: String?, @Indexed var username: String, var fullname: String, var password: String, var authority: String)