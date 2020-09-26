package com.ademe.mapretro.utils.resource.amakna

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAmaknaPorco =  listOf(
    MarkerRes(
        R.string.amakna_porcos,
        -1,
        33,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.EBENE to 2
        )
    ),
    MarkerRes(
        R.string.amakna_porcos,
        -1,
        32,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.ERABLE to 7
        )
    ),
    MarkerRes(
        R.string.amakna_porcos,
        0,
        32,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.ERABLE to 8
        )
    ),
    MarkerRes(
        R.string.amakna_porcos,
        0,
        32,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.CHARME to 1,
            MarkerTypeResource.FER to 16,
            MarkerTypeResource.ETAIN to 1,
            MarkerTypeResource.PIERRE_CUIVREE to 2

        )
    ),
    MarkerRes(
        R.string.amakna_porcos,
        1,
        32,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.IF to 2,
            MarkerTypeResource.FER to 16,
            MarkerTypeResource.PIERRE_KOBALTE to 5,
            MarkerTypeResource.ETAIN to 7,
            MarkerTypeResource.PIERRE_CUIVREE to 3,
            MarkerTypeResource.BRONZE to 2

        )
    )
)