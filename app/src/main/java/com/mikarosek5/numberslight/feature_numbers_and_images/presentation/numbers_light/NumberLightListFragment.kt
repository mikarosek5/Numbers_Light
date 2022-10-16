package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikarosek5.numberslight.R
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details.NumberLightDetailFragment
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.utils.OnListClickListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NumberLightListFragment : Fragment(), OnListClickListener {

    @Inject
    lateinit var viewModel: NumberLightListViewModel

    private var callback: FragmentListener? = null


    override fun onResume() {
        super.onResume()
        viewModel.list.observe(this) { list ->
            view?.let { view ->
                val adapter = NumberLightAdapter(list,this)
                val myRecycler = view.findViewById<RecyclerView>(R.id.list_view)
                myRecycler.adapter = adapter
                myRecycler.layoutManager = LinearLayoutManager(this@NumberLightListFragment.context)


            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as FragmentListener
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number_light_list, container, false)
    }


    override fun onClick(id: String) {
        callback?.onClick(id)
    }
    interface FragmentListener{
        fun onClick(id:String)
    }
}