package com.example.studentapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentStudentDetailBinding
import com.example.studentapp.databinding.FragmentStudentListBinding


class StudentDetailFragment : Fragment() {
private lateinit var binding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }


}