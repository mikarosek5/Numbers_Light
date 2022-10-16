package com.mikarosek5.numberslight.feature_numbers_and_images.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.mikarosek5.numberslight.R
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.connectivity_observer.ConnectivityObserver
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.connectivity_observer.NetworkConnectivityObserver
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light.NumberLightListFragment
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details.NumberLightDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

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