package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikarosek5.numberslight.R
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.utils.OnListClickListener
import com.squareup.picasso.Picasso

class NumberLightAdapter(
    private val numbersLights: List<NumberLight>,
    private val onListClickListener: OnListClickListener
) :
    RecyclerView.Adapter<NumberLightAdapter.NumberLightViewHolder>() {

    inner class NumberLightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberLightViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,
            false
        )
        return NumberLightViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberLightViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.textView).text = numbersLights[position].id
            Picasso.get()
                .load(numbersLights[position].imageUrl)
                .into(findViewById<ImageView>(R.id.imageView))
            setOnClickListener { onListClickListener.onClick(numbersLights[position].id) }
        }
    }

    override fun getItemCount(): Int {
        return numbersLights.size
    }
}