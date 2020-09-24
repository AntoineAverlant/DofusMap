package com.ademe.mapretro.utils.resource.abra

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAbra = listOf(
    MarkerRes(
        R.string.abraknyde_oree,
        -4,
        -10,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.CHARME to 1,
            MarkerTypeResource.IF to 1,
            MarkerTypeResource.MENTHE to 2
        )
    ),
    MarkerRes(
        R.string.abraknyde_oree,
        -4,
        -12,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EBENE to 2,
            MarkerTypeResource.ORME to 1,
            MarkerTypeResource.TREFLE to 11,
            MarkerTypeResource.ORCHIDEE to 11
        )
    ),
    MarkerRes(
        R.string.abraknyde_foret,
        -9,
        -12,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.ARGENT to 4
        )
    ),
    MarkerRes(
        R.string.abraknyde_foret,
        -11,
        -16,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.ARGENT to 4
        )
    )
)