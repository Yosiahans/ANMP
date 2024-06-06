package com.example.studentapp.view

//import android.database.Observable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentStudentDetailBinding
import com.example.studentapp.databinding.FragmentStudentListBinding
import com.example.studentapp.model.Student
import com.squareup.picasso.Picasso
import com.ubaya.studentapp.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
//import { of, timer, concatMap } from 'rxjs';


class StudentDetailFragment : Fragment() {
private lateinit var binding: FragmentStudentDetailBinding
private lateinit var viewModel:DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container,false)
        return binding.root
//        observeViewModel()
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.student = Student("","","","",
            "https://randomwordgenerator.com/img/picture-generator/55e3d1464356a514f1dc8460962e33791c3ad6e04e507441722973d59745c5_640.jpg")

        if(arguments!=null){
            val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.fetch(id)
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            Picasso.get().load()
//            binding.imageView2.setImageURI(viewModel.studentLD.value?.photoUrl)
//            binding.txtID.setText((viewModel.studentLD.value?.id))
//            binding.txtName.setText((viewModel.studentLD.value?.name))
//            binding.txtBOD.setText((viewModel.studentLD.value?.dob))
//            binding.txtPhone.setText((viewModel.studentLD.value?.phone))
//
//            var student= it
//
//            binding.btnUpdate?.setOnClickListener{
//                Log.d("Messages", "testtt")
//
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_launcher_background)
//                    }
//
//            }
            binding.student = it
        }
        )
    }


}