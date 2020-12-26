//package com.example.kotlin_to_do_list
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.DialogFragment
//import com.example.kotlin_to_do_list.databinding.DialogDashboardBinding
//import java.util.zip.Inflater
//
//class CDialogFragment : DialogFragment() {
//    private var _binding: DialogDashboardBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ):View {
//        _binding = DialogDashboardBinding.inflate(inflater,container,false)
//
//        binding.cancelButton.setOnClickListener {
//            dismiss()
//        }
//
//        binding.confirmButton.setOnClickListener {
//
//            var text = binding.login1.text.toString()
//
//            Toast.makeText(context,text,Toast.LENGTH_LONG).show()
//
//            dismiss()
//        }
//
//        return binding.root
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//}