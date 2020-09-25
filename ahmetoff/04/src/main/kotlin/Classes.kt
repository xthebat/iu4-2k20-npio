package ru.bmstu.iu4

import java.util.*

data class Persons (
    var persons: List<Info>
)

data class Info(
    var _id: String,
    var index: Int,
    var guid: String,
    var isActive: Boolean,
    var balance: String,
    var picture: String,
    var age: Int,
    var eyeColor: String,
    var name: String,
    var gender: String,
    var company: String,
    var email: String,
    var phone: String,
    var address: String,
    var about: String,
    var registered: String,
    var latitude: Float,
    var longitude: Float,
    var tags: List<String>,
    var friends: List<Friend>,
    var greeting: String,
    var favoriteFruit: String
)

data class Friend (
    var id: Int,
    var name: String
)