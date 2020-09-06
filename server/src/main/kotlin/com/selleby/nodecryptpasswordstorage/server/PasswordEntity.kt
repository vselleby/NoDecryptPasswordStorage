package com.selleby.nodecryptpasswordstorage.server

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PasswordEntity(
        val loggedInUser: String,
        val service: String,
        val serviceUsername: String,
        val servicePassword: String,
        val passwordLength: Int,
        val useSpecialCharacters: Boolean,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
) {
        constructor() : this("", "", "", "", 0, false)
}