package com.ademe.mapretro.utils.resource.astrub

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAstrubMine = listOf(
    MarkerRes(
        R.string.astrub_mine,
        9,
        -23,
        listOf(MarkerTypeRes.FLEURS, MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.FER to 11,
            MarkerTypeResource.ETAIN to 11,
            MarkerTypeResource.PIERRE_CUIVREE to 7,
            MarkerTypeResource.BRONZE to 5,
            MarkerTypeResource.MENTHE to 2
        )
    ),
    MarkerRes(
        R.string.astrub_mine,
        8,
        -24,
        listOf(MarkerTypeRes.CEREAL),
        hashMapOf(
            MarkerTypeResource.BLE to 9
        )
    ),
    MarkerRes(
        R.string.astrub_mine,
        9,
        -24,
        listOf(MarkerTypeRes.CEREAL),
        hashMapOf(
            MarkerTypeResource.BLE to 9,
            MarkerTypeResource.HOUBLON to 4
        )
    ),
    MarkerRes(
        R.string.astrub_mine,
        10,
        -24,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.FER to 1,
            MarkerTypeResource.ARGENT to 4,
            MarkerTypeResource.OR to 1,
            MarkerTypeResource.PIERRE_CUIVREE to 1
        )
    )
)