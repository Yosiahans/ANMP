package com.ubaya.studentapp.viewmodel

import android.app.Application
import android.nfc.Tag
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.studentapp.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okio.HashingSource


class DetailViewModel(application: Application,savedStateHandle: SavedStateHandle):
    AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null
    fun fetch(id:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=${id}"

        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val sType = object :TypeToken<Student>() {}.type
                val result = Gson().fromJson<Student>(it,sType)
                val student1 = result as Student

                studentLD.value = student1

            }, {}
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)


//        val student1 = Student("16055", "Nonie","1998/03/28","5718444778", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//
//        studentLD.value = student1
    }
}