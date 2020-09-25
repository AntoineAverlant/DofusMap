package com.ademe.mapretro.view

import com.ademe.mapretro.utils.marker.MarkerLieu

interface SelectionListener {
    fun onLieuSelected(list: List<MarkerLieu>, enabled: Boolean)
}