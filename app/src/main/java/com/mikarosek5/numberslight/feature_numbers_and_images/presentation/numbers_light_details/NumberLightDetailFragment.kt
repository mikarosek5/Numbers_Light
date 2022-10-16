package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mikarosek5.numberslight.R
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NumberLightDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel:NumberLightDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Toast.makeText(this.context,this.arguments?.getString("id"),Toast.LENGTH_LONG).show()
        this.arguments?.let {
            val id = it.getString("id")
            if (id != null) {
                Toast.makeText(this.context,it.toString(),Toast.LENGTH_LONG).show() //todo remove
                viewModel.getDetail(id)
            }
            else{
                Toast.makeText(this.context,"bundle is empty",Toast.LENGTH_LONG).show()
            }


        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.detail.observe(this.viewLifecycleOwner){
            view?.apply {
                findViewById<TextView>(R.id.id_tv)?.text = it.id
                findViewById<TextView>(R.id.word)?.text = it.word
                Picasso.get().load(it.imageUrl).into(findViewById<ImageView>(R.id.detail_image))
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number_light_detail, container, false)
    }

}