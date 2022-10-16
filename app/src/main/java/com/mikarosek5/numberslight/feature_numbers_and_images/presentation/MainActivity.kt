package com.mikarosek5.numberslight.feature_numbers_and_images.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.mikarosek5.numberslight.R
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light.NumberLightListFragment
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details.NumberLightDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NumberLightListFragment.FragmentListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_view,
            NumberLightListFragment()
        ).setReorderingAllowed(false).commit()
    }


    override fun onClick(id: String) {
        val containerViewDetail =
            findViewById<FragmentContainerView>(R.id.fragment_container_view_detail)
        if (containerViewDetail == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_view,
                NumberLightDetailFragment().apply {
                    arguments = Bundle().apply { putString("id", id) }
                }
            ).setReorderingAllowed(true).addToBackStack("main").commit()
        } else {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_view_detail,
                NumberLightDetailFragment().apply {
                    arguments = Bundle().apply { putString("id", id) }
                }
            ).setReorderingAllowed(true).addToBackStack("main").commit()
        }

    }
}