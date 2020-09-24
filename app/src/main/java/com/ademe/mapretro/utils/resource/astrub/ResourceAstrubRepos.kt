package com.ademe.mapretro.utils.resource.astrub

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAstrubRepos = listOf(
    MarkerRes(
        R.string.astrub_repos,
        1,
        -11,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 1,
            MarkerTypeResource.CHATAIGNIER to 2,
            MarkerTypeResource.NOYER to 1
        )
    ),
    MarkerRes(
        R.string.astrub_repos,
        1,
        -10,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 2,
            MarkerTypeResource.CHATAIGNIER to 1
        )
    ),
    MarkerRes(
        R.string.astrub_repos,
        0,
        -10,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.NOYER to 1
        )
    ),
    MarkerRes(
        R.string.astrub_repos,
        4,
        -9,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.CHATAIGNIER to 1,
            MarkerTypeResource.IF to 1
        )
    )
)