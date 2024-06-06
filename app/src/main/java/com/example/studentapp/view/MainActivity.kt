package com.example.studentapp.view

import androidx.appcompat.app.AppCompatActivity
import android.Manifest
import android.content.ClipDescription
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.studentapp.R
import com.example.studentapp.databinding.ActivityMainBinding
import com.example.studentapp.util.createNotifChannel

class MainActivity : AppCompatActivity() {
    init {
        instance=this
    }
    companion object{
        private var instance:MainActivity ?= null
        fun showNotification(title:String, content:String,icon:Int){
            val channelId = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"

            val builder = NotificationCompat.Builder(instance!!.applicationContext,channelId)
                .apply {
                    setSmallIcon(icon)
                    setContentText(title)
                    setContentText(content)
                    setStyle(NotificationCompat.BigTextStyle())
                    priority = NotificationCompat.PRIORITY_DEFAULT
                    setAutoCancel(true)
                }
            val manager = NotificationManagerCompat.from(instance!!.applicationContext)
            if(ActivityCompat.checkSelfPermission(instance!!.applicationContext,Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(instance!!, arrayOf(Manifest.permission.POST_NOTIFICATIONS),1)
                return
            }
            manager.notify(1001,builder.build())
        }

    }

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotifChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT,false,getString(R.string.app_name),"App Notification Channel")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1 -> {
                if(grantResults.isNotEmpty()&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Log.d("permission","granted")
                    //create notif channel
                    createNotifChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT,false,getString(R.string.app_name),"App Notification Channel")

                }else{
                    Log.d("permission","deny")

                }

            }
        }


    }


}