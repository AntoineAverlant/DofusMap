package com.ademe.mapretro.utils.resource.amakna

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAmaknaBord =  listOf(
    MarkerRes(
        R.string.amakna_bord,
        -2,
        14,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 1,
            MarkerTypeResource.ORCHIDEE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_bord,
        1,
        14,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 2
        )
    ),
    MarkerRes(
        R.string.amakna_bord,
        1,
        16,
        listOf(MarkerTypeRes.FLEURS, MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 3,
            MarkerTypeResource.TREFLE to 4,
            MarkerTypeResource.ORCHIDEE to 1,
            MarkerTypeResource.ERABLE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_bord,
        1,
        19,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 3
        )
    ),
    MarkerRes(
        R.string.amakna_bord,
        2,
        15,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.MERISIER to 2
        )
    ),
    MarkerRes(
        R.string.amakna_bord,
        2,
        16,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 6
        )
    )
)