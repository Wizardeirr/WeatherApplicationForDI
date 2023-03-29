package com.volkankelleci.weatherapplicationfordi

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.volkankelleci.weatherapplicationfordi.databinding.FragmentHomeBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class HomeFragment : Fragment() {
    private  var _binding:FragmentHomeBinding?=null
    private  val binding get()=_binding!!

    lateinit var bottomNav : BottomNavigationView

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
        setHasOptionsMenu(true)

        //BottomNav. Define
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.search_menu -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.notify_menu -> {
                    loadFragment(NotifyFragment())
                    true
                }
                R.id.settings_menu -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

     fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        // Do stuff...
    }

    fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // Do stuff...
        return false
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container,fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

}