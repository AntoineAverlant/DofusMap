package com.ademe.mapretro.utils.map

import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.google.android.gms.maps.model.Marker

class ListMapMarker {
    private val listMarkerDonjons: MutableList<Marker> =
        mutableListOf()
    private val listMarkerMines: MutableList<Marker> =
        mutableListOf()
    private val listMarkerAtelierHdv: MutableList<Marker> =
        mutableListOf()
    private val listMarkerDivers: MutableList<Marker> =
        mutableListOf()
    private val listMarkerClasses: MutableList<Marker> =
        mutableListOf()
    private val listMarkerZaaps: MutableList<Marker> =
        mutableListOf()
    private val listMarkerEmote: MutableList<Marker> =
        mutableListOf()

    val mapMarkerRes: HashMap<Marker, MarkerRes> =
        hashMapOf()

    fun addResMarker(markerRes: MarkerRes, marker: Marker) {
        mapMarkerRes[marker] = markerRes
    }

    fun addMapMarker(type: MarkerMapType, marker: Marker) {
        when (type) {
            MarkerMapType.DONJONS -> listMarkerDonjons.add(marker)
            MarkerMapType.MINES -> listMarkerMines.add(marker)
            MarkerMapType.ZAAPS -> listMarkerZaaps.add(marker)
            MarkerMapType.ATELIER_HDV -> listMarkerAtelierHdv.add(marker)
            MarkerMapType.DIVERS -> listMarkerDivers.add(marker)
            MarkerMapType.CLASSES -> listMarkerClasses.add(marker)
            MarkerMapType.EMOTE -> listMarkerEmote.add(marker)
        }
    }

    fun clearListMarker(type: MarkerMapType) {
        when (type) {
            MarkerMapType.DONJONS -> clearList(listMarkerDonjons)
            MarkerMapType.MINES -> clearList(listMarkerMines)
            MarkerMapType.ZAAPS -> clearList(listMarkerZaaps)
            MarkerMapType.ATELIER_HDV -> clearList(listMarkerAtelierHdv)
            MarkerMapType.DIVERS -> clearList(listMarkerDivers)
            MarkerMapType.CLASSES -> clearList(listMarkerClasses)
            MarkerMapType.EMOTE -> clearList(listMarkerEmote)
        }
    }

    private fun clearList(listMarker: MutableList<Marker>) {
        listMarker.forEach {
            it.remove()
        }
        listMarker.clear()
    }
}