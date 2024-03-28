package com.example.studentapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentPhoneListBinding
import com.example.studentapp.databinding.FragmentStudentListBinding
import com.example.studentapp.viewmodel.CarViewModel
import com.example.studentapp.viewmodel.ListViewModel
import com.example.studentapp.viewmodel.PhoneViewModel


class PhoneListFragment : Fragment() {
    private lateinit var viewModel:PhoneViewModel
    private val phoneListAdapter = PhoneListAdapter(arrayListOf())
    private lateinit var binding:FragmentPhoneListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneListBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PhoneViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = phoneListAdapter

        observeViewModel()

//        binding.refreshLayout.setOnRefreshListener {
//            binding.recView.visibility = View.GONE
//            binding .txtError.visibility = View.GONE
//            binding.progressLoad.visibility = View.VISIBLE
//            viewModel.refresh()
//            binding.refreshLayout.isRefreshing = false
//        }
    }
    fun observeViewModel(){
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            phoneListAdapter.UpdatePhoneList((it))
        })
//        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
//            if(it==true){
//                binding.txtError?.visibility = View.VISIBLE
//            }
//            else{
//                binding.txtError?.visibility=View.GONE
//            }
//        })
//        viewModel.loadingLD.observe(viewLifecycleOwner,Observer{
//            if(it==true){
//                binding.recView.visibility = View.GONE
//            }
//            else{
//                binding.recView.visibility = View.VISIBLE
//                binding.progressLoad.visibility = View.GONE
//            }
//        })
    }



}