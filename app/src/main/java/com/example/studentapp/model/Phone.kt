package com.example.studentapp.model

data class Phone(
    val id:String?,
    val brand:String?,
    val model:String?,
    val year:String?,
    val colors:List<String>?,
    val manufacturer:PhoneManufacturer?,
)
data class PhoneManufacturer(val name:String?,val country:String?)

