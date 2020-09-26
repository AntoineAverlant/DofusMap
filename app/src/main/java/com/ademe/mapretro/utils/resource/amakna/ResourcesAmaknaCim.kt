package com.ademe.mapretro.utils.resource.amakna

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAmaknaCim =  listOf(
    MarkerRes(
        R.string.amakna_cimetiere,
        8,
        16,
        listOf(MarkerTypeRes.POISSON, MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.POISS_PETIT_MER to 3,
            MarkerTypeResource.POISS_RIV to 2,
            MarkerTypeResource.ORCHIDEE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        9,
        15,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 2,
            MarkerTypeResource.ORCHIDEE to 6
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        9,
        16,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 6,
            MarkerTypeResource.ORCHIDEE to 4
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        10,
        15,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.ORCHIDEE to 5
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        10,
        16,
        listOf(MarkerTypeRes.CEREAL),
        hashMapOf(
            MarkerTypeResource.LIN to 1
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        11,
        16,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 3,
            MarkerTypeResource.ORCHIDEE to 4
        )
    ),
    MarkerRes(
        R.string.amakna_cimetiere,
        11,
        17,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.ORCHIDEE to 2
        )
    )
)