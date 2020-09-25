package com.ademe.mapretro.utils.map

import com.ademe.mapretro.utils.marker.*
import com.google.android.gms.maps.model.Marker

class ListMapMarker {
    private val mapMarkerLieu: HashMap<MarkerLieu, Marker> =
        hashMapOf()

    private val mapMarkerRes: HashMap<MarkerRes, Marker> =
        hashMapOf()
    val mapResMarker: HashMap<Marker, MarkerRes> =
        hashMapOf()

    fun addResMarker(markerRes: MarkerRes, marker: Marker) {
        mapMarkerRes[markerRes] = marker
        mapResMarker[marker] = markerRes
    }

    fun addLieuMarker(markerLieu: MarkerLieu, marker: Marker) {
        mapMarkerLieu[markerLieu] = marker
    }

    fun clearLieuMarker(markerLieu: List<MarkerLieu>) {
        markerLieu.forEach {
            mapMarkerLieu[it]?.remove()
            mapMarkerLieu.remove(it)
        }
    }

    private fun clearListRes(listMarker: List<MarkerRes>) {
        listMarker.forEach {
            mapMarkerRes[it]?.remove()
            mapMarkerRes.remove(it)
        }
    }

    private fun clearList(listMarker: MutableList<Marker>) {
        listMarker.forEach {
            it.remove()
        }
        listMarker.clear()
    }
}