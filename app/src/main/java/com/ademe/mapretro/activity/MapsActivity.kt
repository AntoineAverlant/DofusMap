package com.ademe.mapretro.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.map.ListMapMarker
import com.ademe.mapretro.utils.map.LocalTileProvider
import com.ademe.mapretro.utils.map.MarkerMapType
import com.ademe.mapretro.utils.marker.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.TileOverlay
import com.google.android.gms.maps.model.TileOverlayOptions
import kotlinx.android.synthetic.main.activity_maps.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var vm: MapActivityViewModel
    private lateinit var mMap: GoogleMap
    private lateinit var tiles: TileOverlay

    // lists marker
    private val listMapMarker = ListMapMarker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        vm = ViewModelProvider(this).get<MapActivityViewModel>(
            MapActivityViewModel::class.java)
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)

        menuSelection.init(
            zaapActivated = true,
            diversActivated = true,
            classeActivated = true,
            atelierActivated = true
        )

        menuSelection.onMenuClick = { markerMapType, enabled ->
            vm.setMarkerMap(markerMapType, enabled)
        }

        setObservables()
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map

        mMap.apply {
            mapType = GoogleMap.MAP_TYPE_NONE
            uiSettings.apply {
                isMapToolbarEnabled = false
                isMyLocationButtonEnabled = false
            }
            setLatLngBoundsForCameraTarget(LatLngBounds(LatLng(-25.0, -144.0), LatLng(90.0, 90.0)))
            setMaxZoomPreference(5F)
            setMinZoomPreference(0F)
            //animateCamera(CameraUpdateFactory.zoomTo(4.5F), 2000, null)
        }

        tiles =
            mMap.addTileOverlay(TileOverlayOptions().tileProvider(
                LocalTileProvider(
                    resources.assets
                )
            ))
        tiles.fadeIn = true

        Handler().postDelayed({
            vm.setMapReady(true)
        }, 50)
    }

    private fun setObservables() {
        vm.mapReady.observe(this, Observer { isMapReady ->
            if (isMapReady) {
                vm.setStartingMarkers()
                Handler().postDelayed({
                    loader.visibility = View.GONE
                }, 50)
                vm.setMapReady(false)
            }
        })

        vm.markerDonjonEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                 addListMarker(markerDonjons, MarkerMapType.DONJONS)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.DONJONS)
            }
        })

        vm.markerMinesEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerMines, MarkerMapType.MINES)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.MINES)
            }
        })

        vm.markerZaapsEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerZaaps, MarkerMapType.ZAAPS)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.ZAAPS)
            }
        })
        vm.markerAtelierHdvEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerAtelierHdv, MarkerMapType.ATELIER_HDV)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.ATELIER_HDV)
            }
        })
        vm.markerDiversEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerDivers, MarkerMapType.DIVERS)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.DIVERS)
            }
        })
        vm.markerClassesEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerClasses, MarkerMapType.CLASSES)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.CLASSES)
            }
        })
        vm.markerEmoteEnabled.observe(this, Observer { isMarkerEnabled ->
            if (isMarkerEnabled) {
                addListMarker(markerEmotes, MarkerMapType.EMOTE)
            } else {
                listMapMarker.clearListMarker(MarkerMapType.EMOTE)
            }
        })
    }

    private fun addListMarker(markerList: List<List<Marker>>, type: MarkerMapType) {
        markerList.forEach { list ->
            list.forEach {
                listMapMarker.addMapMarker(type, mMap.addMarker(it.getMarkerOptions(this)))
            }
        }
    }
}