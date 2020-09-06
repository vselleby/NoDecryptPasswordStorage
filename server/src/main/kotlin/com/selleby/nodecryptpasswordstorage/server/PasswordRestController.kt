package com.selleby.nodecryptpasswordstorage.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordRestController {

    @Autowired
    lateinit var repository: PasswordRepository

    @RequestMapping("/dummy")
    fun createDummyEntry() : String {
        repository.save(PasswordEntity(getUserName(), "testService", "dummyUser", "blub", 5, false))
        return "Dummy entry created"
    }

    @RequestMapping("/services")
    fun getServices() : List<String> {
        val serviceList = ArrayList<String>()

        repository.findByLoggedInUser(getUserName()).forEach{ serviceList.add(it.service) }
        return serviceList
    }



    private fun getUserName() : String {
        val principal = SecurityContextHolder.getContext().authentication.principal
        return if (principal is UserDetails) {
            principal.username
        }
        else {
            principal.toString()
        }
    }
}