package com.gelu.insider.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.gelu.insider.R
import com.gelu.insider.model.event.EventModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_popular.view.*

data class EventCategoryAdapter(
    private val context: Context,
    private val popularEventList: ArrayList<EventModel>
) :
    RecyclerView.Adapter<EventCategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_popular, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return popularEventList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val eventModel: EventModel = popularEventList[position]

        if (eventModel.category_id.name.isNotEmpty()) {
            holder.tvCategory.text = eventModel.category_id.name
        }
        if (eventModel.name.isNotEmpty()) {
            holder.tvEventTitle.text = eventModel.name
        }
        if (eventModel.horizontal_cover_image.isNotEmpty()) {
            Picasso.get().load(eventModel.horizontal_cover_image).into(holder.ivCover)
        }
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvEventTitle: AppCompatTextView = v.tvEventTitle
        val tvCategory: AppCompatTextView = v.tvCategory
        val ivCover: AppCompatImageView = v.ivCover
    }

}