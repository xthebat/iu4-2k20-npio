<<<<<<< HEAD
package ru.bmstu.iu4.task03.data

data class Person (
    val _id: String,
    val index: Int,
    val guid: String,
    val isActive: Boolean,
    val balance: String,
    val picture: String,
    val age: Int,
    val eyeColor: String,
    val name: String,
    val gender: String,
    val company: String,
    val email: String,
    val phone: String,
    val address: String,
    val about: String,
    val registered: String,
    val latitude: Float,
    val longitude: Float,
    val tags: List<String>,
    val friends: List<CharacterData>,
    val greeting: String,
    val favoriteFruit: String
)

data class CharacterData (
    val id: Int,
    val name: String
=======
package ru.bmstu.iu4.task03.data

data class Person (
    val _id: String,
    val index: Int,
    val guid: String,
    val isActive: Boolean,
    val balance: String,
    val picture: String,
    val age: Int,
    val eyeColor: String,
    val name: String,
    val gender: String,
    val company: String,
    val email: String,
    val phone: String,
    val address: String,
    val about: String,
    val registered: String,
    val latitude: Float,
    val longitude: Float,
    val tags: List<String>,
    val friends: List<CharacterData>,
    val greeting: String,
    val favoriteFruit: String
)

data class CharacterData (
    val id: Int,
    val name: String
>>>>>>> master
)