package com.ademe.mapretro.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ademe.mapretro.utils.marker.MarkerLieu
import com.ademe.mapretro.utils.marker.markerLieuMenu

class MapActivityViewModel : ViewModel() {
    private var _mapReady: MutableLiveData<Boolean> = MutableLiveData(false)
    val mapReady: LiveData<Boolean> = _mapReady

    private var _listMarkerLieu: MutableLiveData<Pair<List<MarkerLieu>, Boolean>> = MutableLiveData()
    val listMarkerLieu: LiveData<Pair<List<MarkerLieu>, Boolean>> = _listMarkerLieu

    fun setMapReady(value: Boolean) {
        _mapReady.value = value
    }

    fun setStartingMarkers(){
        _listMarkerLieu.value = Pair(markerLieuMenu, true)
    }

    fun setMarkerLieu(listMarkerMenu: List<MarkerLieu>, activated: Boolean) {
        _listMarkerLieu.value = Pair(listMarkerMenu, activated)
    }

    /*
    when(markerMapType) {
     fun setMarkerMap(markerMapType: MarkerMapType, boolean: Boolean) {
        _markerActivated.value = Pair(markerMapType, boolean)
    }
            MarkerMapType.DONJONS -> _markerDonjonEnabled.value = boolean
            MarkerMapType.MINES -> _markerMinesEnabled.value = boolean
            MarkerMapType.ZAAPS -> _markerZaapsEnabled.value = boolean
            MarkerMapType.ATELIER_HDV -> _markerAtelierHdvEnabled.value = boolean
            MarkerMapType.DIVERS -> _markerDiversEnabled.value = boolean
            MarkerMapType.CLASSES -> _markerClassesEnabled.value = boolean
            MarkerMapType.EMOTE -> _markerEmoteEnabled.value = boolean
            MarkerMapType.DIVERS_MENU -> {
                _markerDonjonEnabled.value = boolean
                _markerMinesEnabled.value = boolean
                _markerZaapsEnabled.value = boolean
                _markerAtelierHdvEnabled.value = boolean
                _markerDiversEnabled.value = boolean
                _markerClassesEnabled.value = boolean
                _markerEmoteEnabled.value = boolean
            }
            MarkerMapType.BOIS_MENU -> {

            }
            MarkerMapType.MINERAIS_MENU -> {}
            MarkerMapType.FLEURS_MENU -> {}
            MarkerMapType.CEREAL_MENU -> {}
            MarkerMapType.POISSON_MENU -> {}
        }
     */
}