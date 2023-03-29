package com.volkankelleci.weatherapplicationfordi

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        //Choiced start fragment which fragment will start
        jumpFragment(HomeFragment())

        //Defined bottom navigation view
        bottomNav= findViewById(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {MenuItem->
            when(MenuItem.itemId){
                R.id.home_menu ->{
                    jumpFragment(HomeFragment())
                    true
                }
                R.id.search_menu ->{
                    jumpFragment(SearchFragment())
                    true
                }
                R.id.notify_menu ->{
                    jumpFragment(NotifyFragment())
                    true
                }
                R.id.settings_menu ->{
                    jumpFragment(SettingsFragment())
                    true
                }

                else -> {false}
            }

        }
    }

    // Load fragment to Container
    private fun jumpFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}
