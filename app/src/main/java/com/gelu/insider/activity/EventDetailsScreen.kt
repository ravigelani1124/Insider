package com.gelu.insider.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gelu.insider.R
import com.gelu.insider.model.event.EventModel
import com.gelu.insider.utility.TinyDb
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_details_screen.*

class EventDetailsScreen : AppCompatActivity(), View.OnClickListener {

    lateinit var eventModel: EventModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details_screen)

        initUI()
    }


    private fun initUI() {

        ivBack.setOnClickListener(this)
        eventModel =
            Gson().fromJson(intent.getStringExtra(TinyDb.eventModel), EventModel::class.java)

        if (eventModel.horizontal_cover_image.isNotEmpty()) {
            Picasso.get().load(eventModel.horizontal_cover_image)
                .into(ivEvent)
        }

        if (eventModel.is_rsvp) {
            tvRsvp.text = resources.getString(R.string.str_rsvp_on)
        } else {
            tvRsvp.text = resources.getString(R.string.str_rsvp_cosed)
        }

        if (eventModel.name.isNotEmpty()) {
            tvEventName.text = eventModel.name
        }

        if (eventModel.venue_date_string.isNotEmpty()) {
            tvEventDate.text = eventModel.venue_date_string
        }
        if (eventModel.price_display_string.isNotEmpty()) {
            tvEventPrice.text =
                resources.getString(R.string.str_rupee) + eventModel.price_display_string
        }

        if (eventModel.venue_name.isNotEmpty()) {
            val eventVenue = eventModel.venue_name + " | " + eventModel.city
            tvEventVenue.text = eventVenue
        }
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.ivBack -> {
                finish()
            }
        }
    }
}
