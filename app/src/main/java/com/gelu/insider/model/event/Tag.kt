package com.gelu.insider.model.event

data class Tag(
    val _id: String,
    val is_carousel: Boolean,
    val is_featured: Boolean,
    val is_pick: Boolean,
    val is_primary_interest: Boolean,
    val priority: Int,
    val tag_id: String
)