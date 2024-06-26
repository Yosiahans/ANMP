package com.example.studentapp.model

import com.google.gson.annotations.SerializedName

data class Student( //tidak semua data member kita serialize kan
    var id:String?,
    @SerializedName("student_name")
    var name:String?,
    @SerializedName("birth_of_date")
    var dob:String?,
    var phone:String?,
    @SerializedName("photo_url")
    var photoUrl:String?
)