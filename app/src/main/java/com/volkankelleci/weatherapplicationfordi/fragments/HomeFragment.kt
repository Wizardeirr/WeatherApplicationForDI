package com.volkankelleci.weatherapplicationfordi.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.model.CryptoModel
import com.volkankelleci.weatherapplicationfordi.databinding.FragmentHomeBinding
import com.volkankelleci.weatherapplicationfordi.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(),HomeAdapter.Listener {
    private  var _binding:FragmentHomeBinding?=null
    private  val binding get()=_binding!!

    private val viewModel by viewModel<BaseViewModel>()
    private var adapter=HomeAdapter(arrayListOf(),this)

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
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        viewModel.getDataFromAPI()
        observeData()

    }
    fun observeData(){
        viewModel.cryptoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.recyclerView.visibility = View.VISIBLE
                adapter = HomeAdapter(ArrayList(it.data ?: arrayListOf()),this@HomeFragment)
                binding.recyclerView.adapter = adapter
            }
        })
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

    override fun onItemClick(weatherData: CryptoModel) {
        TODO("Not yet implemented")
    }

}