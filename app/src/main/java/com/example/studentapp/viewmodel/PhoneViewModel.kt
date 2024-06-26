package com.example.studentapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.studentapp.model.Phone
import com.example.studentapp.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhoneViewModel(application: Application):AndroidViewModel(application) {
    val studentsLD = MutableLiveData<ArrayList<Phone>>()
    val loadingLD = MutableLiveData<Boolean>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun refresh(){
//        studentsLD.value = arrayListOf(
//            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100" +
//                    ".jpg/cc0000/ffffff"),
//            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100" +
//                    ".jpg/5fa2dd/ffffff"),
//            Student("11204","Dinny","1994/10/07","6827808747",
//                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
//        )

        studentLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/phone/phone.json"

        val stringRequest = StringRequest(Request.Method.GET,url,{
            val sType = object : TypeToken<List<Phone>>(){}.type
            val result = Gson().fromJson<List<Phone>>(it, sType)
            studentsLD.value = result as ArrayList<Phone>?
            loadingLD.value=false
            Log.d("showvoley",it)


        },{
            Log.d("showvoley", it.toString())
            studentLoadErrorLD.value = false
            loadingLD.value = false

        })
        stringRequest.tag=TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}