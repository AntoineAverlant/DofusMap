package com.ademe.mapretro.utils.resource.cania

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceCania =  listOf(
    MarkerRes(
        R.string.cania,
        -24,
        -61,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 2,
            MarkerTypeResource.IF to 1,
            MarkerTypeResource.CHARME to 2
        )
    ),
    MarkerRes(
        R.string.cania,
        -24,
        -59,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.CHENE to 2,
            MarkerTypeResource.ERABLE to 2
        )
    ),
    MarkerRes(
        R.string.cania,
        -24,
        -58,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.ERABLE to 2,
            MarkerTypeResource.NOYER to 2
        )
    ),
    MarkerRes(
        R.string.cania,
        -20,
        -61,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.EBENE to 2
        )
    )
)

val resourceCaniaCimetiere =  listOf(
    MarkerRes(
        R.string.cania_cimetiere,
        -9,
        -58,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 5
        )
    )
)

val resourceCaniaPlaine =  listOf(
    MarkerRes(
        R.string.cania_rocheuse,
        -15,
        -48,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.OR to 8
        )
    )
)