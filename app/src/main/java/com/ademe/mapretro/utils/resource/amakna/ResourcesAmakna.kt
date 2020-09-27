package com.ademe.mapretro.utils.resource.amakna

import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource


val resourceAmaknaOree =  listOf(
    MarkerRes(
        R.string.amakna_oree,
        1,
        4,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 5
        )
    ),
    MarkerRes(
        R.string.amakna_oree,
        4,
        4,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.FRENE to 1
        )
    )
)

val resourceAmaknaCampagne =  listOf(
    MarkerRes(
        R.string.amakna_campagne,
        7,
        2,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.TREFLE to 3
        )
    ),
    MarkerRes(
        R.string.amakna_campagne,
        5,
        0,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.CHATAIGNIER to 1
        )
    )
)

val resourceAmaknaVillage =  listOf(
    MarkerRes(
        R.string.amakna_village,
        1,
        2,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.CHATAIGNIER to 6
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        2,
        2,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.MENTHE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        4,
        2,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.ORCHIDEE to 1,
            MarkerTypeResource.MENTHE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        4,
        1,
        listOf(MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.ARGENT to 4
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        5,
        1,
        listOf(MarkerTypeRes.CEREAL),
        hashMapOf(
            MarkerTypeResource.SEIGLE to 1
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        -4,
        0,
        listOf(MarkerTypeRes.BOIS),
        hashMapOf(
            MarkerTypeResource.IF to 1
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        -3,
        -1,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1,
            MarkerTypeResource.MENTHE to 4
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        0,
        -3,
        listOf(MarkerTypeRes.BOIS, MarkerTypeRes.MINERAI),
        hashMapOf(
            MarkerTypeResource.CHARME to 1,
            MarkerTypeResource.FER to 25,
            MarkerTypeResource.ETAIN to 1
        )
    ),
    MarkerRes(
        R.string.amakna_village,
        0,
        -4,
        listOf(MarkerTypeRes.FLEURS),
        hashMapOf(
            MarkerTypeResource.EDELWEISS to 1
        )
    )

)