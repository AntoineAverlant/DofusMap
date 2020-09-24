package com.ademe.mapretro.utils.resource.brakmar

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceBrakmar = listOf(
    MarkerRes(
        R.string.brakmar,
        -22,
        32,
        listOf(MarkerTypeRes.MINERAI, MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 3,
            MarkerTypeResource.MENTHE to 2,
            MarkerTypeResource.TREFLE to 4,
            MarkerTypeResource.ARGENT to 5,
            MarkerTypeResource.OR to 19,
            MarkerTypeResource.PIERRE_BAUXITE to 6,
            MarkerTypeResource.PIERRE_KOBALTE to 9,
            MarkerTypeResource.ETAIN to 3,
            MarkerTypeResource.PIERRE_CUIVREE to 5,
            MarkerTypeResource.BRONZE to 3,
            MarkerTypeResource.MANGANESE to 16
        )
    ),
    MarkerRes(
        R.string.brakmar_bordure,
        -25,
        46,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.ARGENT to 3,
            MarkerTypeResource.OR to 9,
            MarkerTypeResource.PIERRE_BAUXITE to 24,
            MarkerTypeResource.PIERRE_KOBALTE to 10,
            MarkerTypeResource.ETAIN to 4,
            MarkerTypeResource.PIERRE_CUIVREE to 4,
            MarkerTypeResource.BRONZE to 26,
            MarkerTypeResource.MANGANESE to 20
        )
    )
)