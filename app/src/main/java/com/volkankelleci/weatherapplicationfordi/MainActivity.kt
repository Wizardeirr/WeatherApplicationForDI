package com.volkankelleci.weatherapplicationfordi

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.volkankelleci.weatherapplicationfordi.fragments.HomeFragment
import com.volkankelleci.weatherapplicationfordi.fragments.NotifyFragment
import com.volkankelleci.weatherapplicationfordi.fragments.SearchFragment
import com.volkankelleci.weatherapplicationfordi.fragments.SettingsFragment


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
                    val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
                    findViewById<FrameLayout>(R.id.fragmentContainerView).startAnimation(animation)
                    true
                }
                R.id.search_menu ->{
                    jumpFragment(SearchFragment())
                    val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
                    findViewById<FrameLayout>(R.id.fragmentContainerView).startAnimation(animation)
                    true
                }
                R.id.notify_menu ->{
                    jumpFragment(NotifyFragment())
                    val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
                    findViewById<FrameLayout>(R.id.fragmentContainerView).startAnimation(animation)
                    true
                }
                R.id.settings_menu ->{
                    jumpFragment(SettingsFragment())
                    val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
                    findViewById<FrameLayout>(R.id.fragmentContainerView).startAnimation(animation)
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
