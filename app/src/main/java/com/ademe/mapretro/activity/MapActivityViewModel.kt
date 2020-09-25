package com.ademe.mapretro.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ademe.mapretro.utils.marker.MarkerLieu
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.markerLieuMenu
import com.ademe.mapretro.utils.marker.markerResources

class MapActivityViewModel : ViewModel() {
    private var _mapReady: MutableLiveData<Boolean> = MutableLiveData(false)
    val mapReady: LiveData<Boolean> = _mapReady

    private var _listMarkerLieu: MutableLiveData<Pair<List<MarkerLieu>, Boolean>> = MutableLiveData()
    val listMarkerLieu: LiveData<Pair<List<MarkerLieu>, Boolean>> = _listMarkerLieu

    private var _listMarkerRes: MutableLiveData<Pair<List<MarkerRes>, Boolean>> = MutableLiveData()
    val listMarkerRes: LiveData<Pair<List<MarkerRes>, Boolean>> = _listMarkerRes

    fun setMapReady(value: Boolean) {
        _mapReady.value = value
    }

    fun setStartingMarkers(){
        _listMarkerLieu.value = Pair(markerLieuMenu, true)
        _listMarkerRes.value = Pair(markerResources, true)
    }

    fun setMarkerRes(listMarkerMenu: List<MarkerRes>, activated: Boolean) {
        _listMarkerRes.value = Pair(listMarkerMenu, activated)
    }

    fun setMarkerLieu(listMarkerMenu: List<MarkerLieu>, activated: Boolean) {
        _listMarkerLieu.value = Pair(listMarkerMenu, activated)
    }
}