package com.ademe.mapretro.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ademe.mapretro.utils.map.MarkerMapType

class MapActivityViewModel : ViewModel() {
    private var _mapReady: MutableLiveData<Boolean> = MutableLiveData(false)
    val mapReady: LiveData<Boolean> = _mapReady

    private var _markerDonjonEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerDonjonEnabled: LiveData<Boolean> = _markerDonjonEnabled

    private var _markerMinesEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerMinesEnabled: LiveData<Boolean> = _markerMinesEnabled

    private var _markerZaapsEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerZaapsEnabled: LiveData<Boolean> = _markerZaapsEnabled

    private var _markerAtelierHdvEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerAtelierHdvEnabled: LiveData<Boolean> = _markerAtelierHdvEnabled

    private var _markerDiversEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerDiversEnabled: LiveData<Boolean> = _markerDiversEnabled

    private var _markerClassesEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerClassesEnabled: LiveData<Boolean> = _markerClassesEnabled

    private var _markerEmoteEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val markerEmoteEnabled: LiveData<Boolean> = _markerEmoteEnabled

    fun setMapReady(value: Boolean) {
        _mapReady.value = value
    }

    fun setStartingMarkers () {
        _markerDiversEnabled.value = true
        _markerZaapsEnabled.value = true
        _markerClassesEnabled.value = true
        _markerAtelierHdvEnabled.value = true
    }

    fun setMarkerMap(markerMapType: MarkerMapType, boolean: Boolean) {
        when(markerMapType) {
            MarkerMapType.DONJONS -> _markerDonjonEnabled.value = boolean
            MarkerMapType.MINES -> _markerMinesEnabled.value = boolean
            MarkerMapType.ZAAPS -> _markerZaapsEnabled.value = boolean
            MarkerMapType.ATELIER_HDV -> _markerAtelierHdvEnabled.value = boolean
            MarkerMapType.DIVERS -> _markerDiversEnabled.value = boolean
            MarkerMapType.CLASSES -> _markerClassesEnabled.value = boolean
            MarkerMapType.EMOTE -> _markerEmoteEnabled.value = boolean
        }
    }
}