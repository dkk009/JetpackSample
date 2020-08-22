package com.example.androidjetpacksamples.feature.fragmenttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.evrencoskun.tableview.TableView
import com.example.androidjetpacksamples.R

class FragmentTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        init()
    }

    private fun init() {
        addFragment(FragmentList(), true)
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        supportFragmentManager.executePendingTransactions()
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.anim_screen_from_bottom_to_top,
            R.anim.anim_screen_from_top_to_bottom,
            R.anim.anim_screen_from_bottom_to_top,
            R.anim.anim_screen_from_top_to_bottom
        )
            .add(R.id.container, fragment, fragment::class.java.simpleName).apply {
                if (addToBackStack) {
                    addToBackStack(fragment::class.java.simpleName)
                }

            }
            .commitAllowingStateLoss()
    }


    fun removeSecondFragment() {
        supportFragmentManager.executePendingTransactions()
        val fragmentList = supportFragmentManager.fragments
        val subList = fragmentList.filterIsInstance<FragmentTwo>()
        if (subList.isNotEmpty()) {
            val fragmentTwo = subList.first()
            supportFragmentManager.beginTransaction().remove(fragmentTwo).commitAllowingStateLoss()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1 && getCurrentFragment() !is FragmentOne) {
            supportFragmentManager.executePendingTransactions()
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    fun getCurrentFragment(): Fragment? {
        supportFragmentManager.let {
            return supportFragmentManager.findFragmentById(R.id.container)
        }

        return null
    }
}