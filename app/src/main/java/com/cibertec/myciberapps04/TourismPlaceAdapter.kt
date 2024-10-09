package com.cibertec.myciberapps04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.myciberapps04.databinding.ItemTourismBinding

class TourismPlaceAdapter(private val places: List<TourismPlace>) :
    RecyclerView.Adapter<TourismPlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourismPlaceViewHolder {
        val binding = ItemTourismBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TourismPlaceViewHolder(binding)
    }

    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: TourismPlaceViewHolder, position: Int) {
        val itemPlace = places[position]
        holder.bind(itemPlace)
    }


}

class TourismPlaceViewHolder(private val binding: ItemTourismBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TourismPlace) {
        binding.tvTitle.text = item.name
    }

}