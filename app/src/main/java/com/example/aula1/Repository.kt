package com.example.aula1

val User.formattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "UNknown"
            }
        } else {
            firstName ?: "Unknown"
        }
    }

fun List<Any>.hasFiveElements(): Boolean {
    return size == 5
}

class Repository private constructor() {
    private var _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

    val formattedUserNames: List<String>
        get() {
            return users.map { user -> user.formattedName }
        }

    companion object {
        private var INSTANCE: Repository? = null
        val instance: Repository?
            get() {
                if (INSTANCE == null) {
                    synchronized(Repository::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = Repository()
                        }
                    }
                }
                return INSTANCE
            }
    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John")
        val user3 = User("Anne", "Doe")
        _users.apply {
            add(user1)
            add(user2)
            add(user3)
        }
    }
}