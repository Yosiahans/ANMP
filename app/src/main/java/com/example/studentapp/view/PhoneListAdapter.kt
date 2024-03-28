package com.example.studentapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.PhoneListItemBinding
import com.example.studentapp.databinding.StudentListItemBinding
import com.example.studentapp.model.Phone
import com.example.studentapp.model.Student

class PhoneListAdapter(val phoneList:ArrayList<Phone>):
    RecyclerView.Adapter<PhoneListAdapter.PhoneViewHolder>(){
    class PhoneViewHolder(var binding:PhoneListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        var binding = PhoneListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhoneViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  phoneList.size
    }


    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
    holder.binding.txtID.text = phoneList[position].id
        holder.binding.txtName.text = phoneList[position].model
        holder.binding.txtManu .text = phoneList[position].manufacturer?.name
        holder.binding.btnDetail.setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
//    fun updateStudentList(newStudentList:ArrayList<Student>){
//        phoneList.clear()
//        phoneList.addAll(newStudentList)
//        notifyDataSetChanged()
//    }
}

