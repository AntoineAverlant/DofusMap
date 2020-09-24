package com.ademe.mapretro.utils.marker

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import com.ademe.mapretro.R
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.math.pow

class MarkerRes(
    private val title: Int,
    private val positionLong: Int,
    private val positionLat: Int,
    val type: List<MarkerTypeRes>,
    val hashMapTypeQte: HashMap<MarkerTypeResource, Int>
) {
    private var markerOptions: MarkerOptions? = null
    var tag: String = "$positionLong, $positionLat"

    private fun getLatLong(): LatLng {
        val long = getLong(positionLong.toDouble())

        val lat = getLat(positionLat.toDouble())

        return LatLng(lat, long)
    }


    private fun getLong(positionLong: Double): Double {
        return if (positionLong >= 0) {
            -0.00181624 * positionLong.pow(2) + 2.41816 * positionLong + 7.3
        } else {
            0.0000149125 * positionLong.pow(3) + 0.00126073 * positionLong.pow(2) + 2.3902 * positionLong + 7.3
        }
    }


    private fun getLat(positionLat: Double): Double {
        return if (positionLat >= 0) {
            0.000106674 * positionLat.pow(3) - 0.00447808 * positionLat.pow(2) - 1.29147 * positionLat + 18.5
        } else {
            (-0.0000215618) * positionLat.pow(3) - 0.00913636 * positionLat.pow(2) - 1.33602 * positionLat + 18.5
        }
    }

    fun getMarkerOptions(context: Context): MarkerOptions {
        markerOptions?.let { marker ->
            return marker
        } ?: run {

            markerOptions = MarkerOptions()
                .position(getLatLong())
                .title("$positionLong, $positionLat")
                .snippet(context.getString(title))
                .icon(getBitmap(context))
                .flat(true)
            return markerOptions!!
        }
    }

    fun getTitle(context: Context) = "$positionLong, $positionLat | ${context.getString(title)}"

    private fun getBitmap(context: Context): BitmapDescriptor {
        val markerType = (hashMapTypeQte.maxBy { it.value })?.key
        return BitmapDescriptorFactory.fromBitmap(generateSmallIcon(getBitmapRes(markerType?: MarkerTypeResource.OR), context))
    }

    private fun generateSmallIcon(@DrawableRes id: Int, context: Context): Bitmap {
        val bitmap = BitmapFactory.decodeResource(context.resources, id)
        return Bitmap.createScaledBitmap(bitmap, 75, 75, false)
    }
}