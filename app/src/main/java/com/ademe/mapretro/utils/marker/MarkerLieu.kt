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

class MarkerLieu(
    private val title: Int,
    private val snippet: Int,
    private val positionLong: Int,
    private val positionLat: Int,
    private val type: MarkerType
) {
    private var markerOptions: MarkerOptions? = null

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
                .icon(getBitmap(context))
                .title("${context.getString(title)} | $positionLong, $positionLat")
                .snippet(context.getString(snippet))
                .flat(true)
            return markerOptions!!
        }
    }

    private fun getBitmap(context: Context): BitmapDescriptor =
        BitmapDescriptorFactory.fromBitmap(generateSmallIcon(getDrawableRes(), context))


    private fun generateSmallIcon(@DrawableRes id: Int, context: Context): Bitmap {
        val heightWidth = getSize()
        val bitmap = BitmapFactory.decodeResource(context.resources, id)
        return Bitmap.createScaledBitmap(bitmap, heightWidth, heightWidth, false)
    }

    private fun getSize(): Int = when (type) {
        MarkerType.EMOTE, MarkerType.PHENIX -> 60
        else -> 75
    }


    private fun getDrawableRes(): Int = when (type) {
        MarkerType.ZAAP -> R.drawable.zaap
        MarkerType.BANQUE -> R.drawable.banque
        MarkerType.TAVERNE -> R.drawable.taverne
        MarkerType.MILICE -> R.drawable.milice
        MarkerType.ARENE -> R.drawable.coliseum
        MarkerType.PLACE_MARCHANDE -> R.drawable.place_marchande
        MarkerType.TRANSPO_BRIG -> R.drawable.balloon
        MarkerType.KANOJEDO -> R.drawable.kanojedo
        MarkerType.DOJO -> R.drawable.dojo
        MarkerType.BIBLIOTHEQUE -> R.drawable.biblio
        MarkerType.HOTEL_METIER -> R.drawable.job
        MarkerType.TOUR -> R.drawable.tour
        MarkerType.EGLISE -> R.drawable.eglise
        MarkerType.GUILDE -> R.drawable.guilde
        MarkerType.BATEAU -> R.drawable.ship
        MarkerType.CANON -> R.drawable.canon
        MarkerType.ENCLOS -> R.drawable.fence
        MarkerType.CHANIL -> R.drawable.chanil
        MarkerType.EMOTE -> R.drawable.emote
        MarkerType.EGOUTS -> R.drawable.ladder
        MarkerType.PHENIX -> R.drawable.phenix
        MarkerType.MINES -> R.drawable.mine
        MarkerType.DONJON -> R.drawable.donjon

        MarkerType.PANDA -> R.drawable.pandawa
        MarkerType.ENUTROF -> R.drawable.enutrof
        MarkerType.SRAM -> R.drawable.sram
        MarkerType.ENIRIPSA -> R.drawable.eniripsa
        MarkerType.CRA -> R.drawable.cra
        MarkerType.XELOR -> R.drawable.xelor
        MarkerType.SADIDA -> R.drawable.sadida
        MarkerType.IOP -> R.drawable.iop
        MarkerType.FECA -> R.drawable.feca
        MarkerType.ECA -> R.drawable.ecaflip
        MarkerType.SACRI -> R.drawable.sacrieur
        MarkerType.OSAMODAS -> R.drawable.osamodas

        MarkerType.ATELIER_BOUBOU -> R.drawable.atelier_bou
        MarkerType.ATELIER_BUCHERON -> R.drawable.atelier_buche
        MarkerType.ATELIER_PAYSAN -> R.drawable.atelier_paysan
        MarkerType.ATELIER_TAILLEUR -> R.drawable.atelier_tailleur
        MarkerType.ATELIER_CORDO -> R.drawable.atelier_cordo
        MarkerType.ATELIER_SCULPTEUR -> R.drawable.atelier_sculteur
        MarkerType.ATELIER_FORGERONS -> R.drawable.atelier_forge
        MarkerType.ATELIER_ALCHI -> R.drawable.atelier_alchi
        MarkerType.ATELIER_MINEUR -> R.drawable.atelier_mineur
        MarkerType.ATELIER_PECHEUR -> R.drawable.atelier_poiss
        MarkerType.ATELIER_BOULANGER -> R.drawable.atelier_boulanger
        MarkerType.ATELIER_BIJOU -> R.drawable.atelier_bijou
        MarkerType.ATELIER_BOUCHER -> R.drawable.atelier_boucher
        MarkerType.ATELIER_FORGEMAGE -> R.drawable.atelier_fm
        MarkerType.ATELIER_BRICO -> R.drawable.atelier_brico
        MarkerType.ATELIER_FEE_ARTI -> R.drawable.atelier_fee

        MarkerType.HDV_BOUBOU -> R.drawable.hdv_bou
        MarkerType.HDV_BUCHERON -> R.drawable.hdv_buche
        MarkerType.HDV_PAYSAN -> R.drawable.hdv_paysan
        MarkerType.HDV_TAILLEUR -> R.drawable.hdv_tailleur
        MarkerType.HDV_CORDO -> R.drawable.hdv_cordo
        MarkerType.HDV_SCULPTEUR -> R.drawable.hdv_cordo
        MarkerType.HDV_FORGERONS -> R.drawable.hdv_forge
        MarkerType.HDV_ALCHI -> R.drawable.hdv_alchi
        MarkerType.HDV_MINEUR -> R.drawable.hdv_mineur
        MarkerType.HDV_PECHEUR -> R.drawable.hdv_poiss
        MarkerType.HDV_BOULANGER -> R.drawable.hdv_boulanger
        MarkerType.HDV_BIJOU -> R.drawable.hdv_bijou
        MarkerType.HDV_BOUCHER -> R.drawable.hdv_boucher
        MarkerType.HDV_AMES -> R.drawable.hdv_ame
        MarkerType.HDV_FEE_ARTI -> R.drawable.hdv_fee
        MarkerType.HDV_RESOURCE -> R.drawable.hdv_res
        MarkerType.HDV_DOC -> R.drawable.hdv_doc
        MarkerType.HDV_ANIMAUX -> R.drawable.hdv_animaux
        MarkerType.HDV_PARCH -> R.drawable.hdv_parch
    }
}