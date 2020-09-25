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
import com.ademe.mapretro.utils.map.MarkerMenuMapType
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
    private val listMapMarker = ListMapMarker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        vm = ViewModelProvider(this).get<MapActivityViewModel>(
            MapActivityViewModel::class.java
        )
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)

        menuSelection.init(supportFragmentManager)

        menuSelection.onLieuMenuClick = { listMarkerLieu, enabled ->
            vm.setMarkerLieu(listMarkerLieu, enabled)
        }

        menuSelection.onResMenuClick = { listMarkerLieu, enabled ->
            vm.setMarkerRes(listMarkerLieu, enabled)
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

            setOnMarkerClickListener {
                val markerRes = listMapMarker.mapResMarker[it]
                markerRes?.let {
                    infoMarker.showInfo(markerRes)
                } ?: infoMarker.hide()
                false
            }
            setOnMapClickListener {
                infoMarker.hide()
            }
        }

        tiles =
            mMap.addTileOverlay(
                TileOverlayOptions().tileProvider(
                    LocalTileProvider(
                        resources.assets
                    )
                )
            )
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

        vm.listMarkerLieu.observe(this, Observer { pairMarkerEnabled ->
            val listMarker = pairMarkerEnabled.first
            val enabled = pairMarkerEnabled.second
            if (enabled) {
                addListMarker(listMarker)
            } else {
                listMapMarker.clearLieuMarker(listMarker)
            }
        })

        vm.listMarkerRes.observe(this, Observer { pairMarkerEnabled ->
            val listMarker = pairMarkerEnabled.first
            val enabled = pairMarkerEnabled.second
            if (enabled) {
                addListMarkerRes(listMarker)
            } else {
                listMapMarker.clearListRes(listMarker)
            }
        })
    }

    private fun addListMarkerRes(markerList: List<MarkerRes>) {
        markerList.forEach {
            listMapMarker.addResMarker(it, mMap.addMarker(it.getMarkerOptions(this)))
        }
    }

    private fun addListMarker(markerList: List<MarkerLieu>) {
        markerList.forEach {
            listMapMarker.addLieuMarker(it, mMap.addMarker(it.getMarkerOptions(this)))
        }
    }
}