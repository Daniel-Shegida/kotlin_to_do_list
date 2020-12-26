package com.example.kotlin_to_do_list.fragments.list2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_to_do_list.R

class ListFragment : Fragment() {

//    private var _binding: DialogDashboardBinding? = null
//    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {


       // _binding = DialogDashboardBinding.inflate(inflater,container,false)

//        binding.floatingActionButton2.setOnClickListener {
//            findNavController().navigate(R.id.action_listFragment_to_addFragment)
//        }


        //return binding.root
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }

}