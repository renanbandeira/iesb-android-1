package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.CountryItemBinding
import com.example.myapplication.model.Country

class CountryAdapter(private val items: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemBinding = CountryItemBinding.bind(view)

        fun bind(country: Country) {
            itemBinding.countryNameTextView.text = country.name
        }
    }

    fun update(countries: List<Country>) {
        items.clear()
        items.addAll(countries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}