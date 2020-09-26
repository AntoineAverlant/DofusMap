package com.ademe.mapretro.utils.resource.amakna

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourceAmaknaMontagne =  listOf(
    MarkerRes(
        R.string.amakna_montagne,
        -3,
        -7,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.ORME to 1,
            MarkerTypeResource.MERISIER to 1
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -3,
        -6,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1,
            MarkerTypeResource.MENTHE to 2
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -3,
        -5,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 2
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -3,
        -4,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1,
            MarkerTypeResource.MENTHE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -3,
        -3,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1,
            MarkerTypeResource.MENTHE to 2
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -2,
        -7,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 2,
            MarkerTypeResource.MENTHE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -2,
        -6,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.ARGENT to 4,
            MarkerTypeResource.OR to 2
        )
    ),
    MarkerRes(
        R.string.amakna_montagne,
        -2,
        -5,
        listOf(MarkerTypeRes.MINERAI, MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 2,
            MarkerTypeResource.OR to 11,
            MarkerTypeResource.PIERRE_BAUXITE to 19
        )
    )
)