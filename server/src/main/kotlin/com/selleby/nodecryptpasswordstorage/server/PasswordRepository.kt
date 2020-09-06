package com.selleby.nodecryptpasswordstorage.server

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PasswordRepository : CrudRepository<PasswordEntity, Long> {
    fun findByLoggedInUser(loggedInUser: String): Iterable<PasswordEntity>

    fun findByLoggedInUserAndService(loggedInUser: String, service: String): Iterable<PasswordEntity>
}