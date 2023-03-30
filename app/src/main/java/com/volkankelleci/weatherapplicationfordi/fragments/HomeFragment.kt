package com.volkankelleci.weatherapplicationfordi.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.volkankelleci.weatherapplicationfordi.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private  var _binding:FragmentHomeBinding?=null
    private  val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

}