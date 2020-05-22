package com.gelu.insider.model.event

data class EventModel(
    val _id: String,
    val applicable_filters: ArrayList<String>,
    val category_id: CategoryId,
    val city: String,
    val communication_strategy: String,
    val event_state: String,
    val group_id: GroupId,
    val horizontal_cover_image: String,
    val is_rsvp: Boolean,
    val min_price: String,
    val min_show_start_time: Long,
    val model: String,
    val name: String,
    val popularity_score: String,
    val price_display_string: String,
    val purchase_visibility: String,
    val slug: String,
    val tags: ArrayList<Tag>,
    val type: String,
    val venue_date_string: String,
    val venue_geolocation: VenueGeolocation,
    val venue_id: String,
    val venue_name: String
)