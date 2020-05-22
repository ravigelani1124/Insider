package com.gelu.insider.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gelu.insider.R
import com.gelu.insider.model.event.EventTypeModel
import kotlinx.android.synthetic.main.list_event.view.*

data class EventAdapter(
    private val context: Context,
    private val eventTypeList: ArrayList<EventTypeModel>
) :
    RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_event, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return eventTypeList.size
    }

    override fun onBindViewHolder(holder: EventAdapter.MyViewHolder, position: Int) {
        val eventTypeModel = eventTypeList[position]

        if (eventTypeModel.eventList.isNotEmpty() && eventTypeModel.eventList.size > 0) {

            if (eventTypeModel.eventName.isNotEmpty()) {
                holder.tvEventTitle.text = eventTypeModel.eventName
            }
            val eventCategoryAdapter = EventCategoryAdapter(context, eventTypeModel.eventList)
            holder.rvEvents.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            holder.rvEvents.adapter = eventCategoryAdapter
        }

    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvEventTitle: AppCompatTextView = v.tvEventType
        val rvEvents: RecyclerView = v.rvEvents
    }

}