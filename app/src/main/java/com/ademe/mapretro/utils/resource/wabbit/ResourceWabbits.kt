package com.ademe.mapretro.utils.resource.wabbit

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceWabbits = listOf(
    MarkerRes(
        R.string.wabbits_ile,
        23,
        -4,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 4
        )
    ),
    MarkerRes(
        R.string.wabbits_ile,
        22,
        -5,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 3
        )
    ),
    MarkerRes(
        R.string.wabbits_ile,
        23,
        -9,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 8
        )
    ),
    MarkerRes(
        R.string.wabbits_chateau,
        24,
        -14,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 1,
            MarkerTypeResource.ORCHIDEE to 2
        )
    ),
    MarkerRes(
        R.string.wabbits_ilot,
        28,
        -13,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1
        )
    ),
    MarkerRes(
        R.string.wabbits_squelette,
        22,
        -12,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 1,
            MarkerTypeResource.ORCHIDEE to 2
        )
    )
)