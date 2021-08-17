package com.example.aula1

import com.example.aula1.Repository.Companion.instance

class Test internal constructor() {
    init {
        instance!!.users.run {  }
        instance!!.users.apply {  }
        instance!!.users.also {  }
        instance!!.users.let { users ->
            println("Users é null ${users.size}")
        }
    }
}