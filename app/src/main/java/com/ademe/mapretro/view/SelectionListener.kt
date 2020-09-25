package com.ademe.mapretro.view

import com.ademe.mapretro.utils.marker.MarkerLieu
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

interface SelectionListener {
    fun onLieuSelected(list: List<MarkerLieu>, enabled: Boolean)

    fun onResSelected(markerTypeRes: MarkerTypeRes, markerTypeResource: MarkerTypeResource, enabled: Boolean)
}