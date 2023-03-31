package com.volkankelleci.weatherapplicationfordi.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.volkankelleci.weatherapplicationfordi.databinding.FragmentHomeBinding
import com.volkankelleci.weatherapplicationfordi.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private  var _binding:FragmentHomeBinding?=null
    private  val binding get()=_binding!!

    private val viewModel by viewModel<BaseViewModel>()

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

        println(viewModel.getDataFromAPI())
    }
    fun observeData(){
        viewModel.cryptoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.recyclerView.visibility = View.VISIBLE
                cryptoAdapter = RecyclerViewAdapter(ArrayList(cryptos.data ?: arrayListOf()),this@ListFragment)
                binding.recyclerView.adapter = cryptoAdapter
            }
        })
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

}