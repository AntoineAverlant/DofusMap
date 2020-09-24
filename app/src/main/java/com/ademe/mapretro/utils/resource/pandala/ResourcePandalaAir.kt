package com.ademe.mapretro.utils.resource.pandala

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource

val resourcePandalaAir = listOf(
    MarkerRes(
        R.string.pandala_air,
        16,
        -35,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.POISSON),
        hashMapOf(
            MarkerTypeResource.POISS_PETIT_MER to 5,
            MarkerTypeResource.POISS_GROS_MER to 4,
            MarkerTypeResource.POISS_GEANT_MER to 3,
            MarkerTypeResource.BAMBOU to 3
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        15,
        -34,
        listOf(MarkerTypeRes.POISSON),
        hashMapOf(
            MarkerTypeResource.POISS_GROS_MER to 2
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        15,
        -33,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.POISSON),
        hashMapOf(
            MarkerTypeResource.POISS_MER to 9,
            MarkerTypeResource.POISS_GROS_MER to 4,
            MarkerTypeResource.BAMBOU to 2
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        17,
        -35,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        17,
        -34,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        16,
        -33,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 4
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        17,
        -33,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3,
            MarkerTypeResource.BAMBOU_SACRE to 1
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        18,
        -33,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 2
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        16,
        -32,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 2
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        17,
        -32,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        18,
        -32,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3
        )
    ),
    MarkerRes(
        R.string.pandala_air,
        17,
        -31,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.BAMBOU to 3
        )
    )
)

