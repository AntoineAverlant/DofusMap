package com.ademe.mapretro.utils.marker

import com.ademe.mapretro.R

fun <T> concatenate(vararg lists: List<T>): MutableList<T> {
    return object : ArrayList<T>() {
        init {
            for (list in lists) {
                addAll(list)
            }
        }
    }
}

fun getBitmapRes(markerType: MarkerTypeResource): Int = when (markerType) {
    MarkerTypeResource.MANGANESE -> R.drawable.manganese
    MarkerTypeResource.PIERRE_CUIVREE -> R.drawable.cuivre
    MarkerTypeResource.ARGENT -> R.drawable.argent
    MarkerTypeResource.SILICATE -> R.drawable.silicate
    MarkerTypeResource.ETAIN -> R.drawable.etain
    MarkerTypeResource.FER -> R.drawable.fer
    MarkerTypeResource.DOLOMITE -> R.drawable.dolomite
    MarkerTypeResource.PIERRE_KOBALTE -> R.drawable.kobalte
    MarkerTypeResource.BRONZE -> R.drawable.bronze
    MarkerTypeResource.PIERRE_BAUXITE -> R.drawable.bauxite
    MarkerTypeResource.OR -> R.drawable.or
    MarkerTypeResource.RIZ -> R.drawable.riz
    MarkerTypeResource.ORGE -> R.drawable.orge
    MarkerTypeResource.MALT -> R.drawable.malt
    MarkerTypeResource.LIN -> R.drawable.lin
    MarkerTypeResource.CHANVRE -> R.drawable.chanvre
    MarkerTypeResource.HOUBLON -> R.drawable.houblon
    MarkerTypeResource.AVOINE -> R.drawable.avoine
    MarkerTypeResource.BLE -> R.drawable.ble
    MarkerTypeResource.SEIGLE -> R.drawable.seigle
    MarkerTypeResource.KALIPTUS -> R.drawable.kaliptus
    MarkerTypeResource.BOMBU -> R.drawable.bombu
    MarkerTypeResource.ERABLE -> R.drawable.erable
    MarkerTypeResource.FRENE -> R.drawable.frene
    MarkerTypeResource.BAMBOU_SACRE -> R.drawable.bambou_sacre
    MarkerTypeResource.BAMBOU_SOMBRE -> R.drawable.bambou_sombre
    MarkerTypeResource.BAMBOU -> R.drawable.bambou
    MarkerTypeResource.OLIVIOLET -> R.drawable.oliviolet
    MarkerTypeResource.MERISIER -> R.drawable.merisier
    MarkerTypeResource.NOYER -> R.drawable.noyer
    MarkerTypeResource.CHATAIGNIER -> R.drawable.chataignier
    MarkerTypeResource.CHARME -> R.drawable.charme
    MarkerTypeResource.ORME -> R.drawable.orme
    MarkerTypeResource.EBENE -> R.drawable.ebene
    MarkerTypeResource.IF -> R.drawable.iif
    MarkerTypeResource.CHENE -> R.drawable.chene
    MarkerTypeResource.PANDOUILLE -> R.drawable.pandouille
    MarkerTypeResource.ORCHIDEE -> R.drawable.orchidee
    MarkerTypeResource.TREFLE -> R.drawable.trefle
    MarkerTypeResource.MENTHE -> R.drawable.menthe
    MarkerTypeResource.EDELWEISS -> R.drawable.edelweiss
    MarkerTypeResource.POISS_GEANT_MER -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_GEANT_RIV -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_GROS_MER -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_GROS_RIV -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_MER -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_RIV -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_PETIT_MER -> R.drawable.zaap // TODO
    MarkerTypeResource.POISS_PETIT_RIV -> R.drawable.zaap // TODO
}

fun getTitle(markerType: MarkerTypeResource, qte: Int): String = when (markerType) {
    MarkerTypeResource.MANGANESE -> "Manganèse ($qte)"
    MarkerTypeResource.PIERRE_CUIVREE -> "Pierre cuivrée ($qte)"
    MarkerTypeResource.ARGENT -> "Argent ($qte)"
    MarkerTypeResource.SILICATE -> "Silicate ($qte)"
    MarkerTypeResource.ETAIN -> "Etain ($qte)"
    MarkerTypeResource.FER -> "Fer ($qte)"
    MarkerTypeResource.DOLOMITE -> "Dolomite ($qte)"
    MarkerTypeResource.PIERRE_KOBALTE -> "Pierre de Kobalte ($qte)"
    MarkerTypeResource.BRONZE -> "Bronze ($qte)"
    MarkerTypeResource.PIERRE_BAUXITE -> "Pierre de Bauxite ($qte)"
    MarkerTypeResource.OR -> "Or ($qte)"
    MarkerTypeResource.RIZ -> "Riz ($qte)"
    MarkerTypeResource.ORGE -> "Orge ($qte)"
    MarkerTypeResource.MALT -> "Malt ($qte)"
    MarkerTypeResource.LIN -> "Lin ($qte)"
    MarkerTypeResource.CHANVRE -> "Chanvre ($qte)"
    MarkerTypeResource.HOUBLON -> "Houblon ($qte)"
    MarkerTypeResource.AVOINE -> "Avoine ($qte)"
    MarkerTypeResource.BLE -> "Blé ($qte)"
    MarkerTypeResource.SEIGLE -> "Seigle ($qte)"
    MarkerTypeResource.KALIPTUS -> "Kaliptus ($qte)"
    MarkerTypeResource.BOMBU -> "Bombu ($qte)"
    MarkerTypeResource.ERABLE -> "Erable ($qte)"
    MarkerTypeResource.FRENE -> "Frêne ($qte)"
    MarkerTypeResource.BAMBOU_SACRE -> "Bambou sacré ($qte)"
    MarkerTypeResource.BAMBOU_SOMBRE -> "Bambou sombre ($qte)"
    MarkerTypeResource.BAMBOU -> "Bambou sombre ($qte)"
    MarkerTypeResource.OLIVIOLET -> "Oliviolet ($qte)"
    MarkerTypeResource.MERISIER -> "Merisier ($qte)"
    MarkerTypeResource.NOYER -> "Noyer ($qte)"
    MarkerTypeResource.CHATAIGNIER -> "Châtaigner ($qte)"
    MarkerTypeResource.CHARME -> "Charme ($qte)"
    MarkerTypeResource.ORME -> "Orme ($qte)"
    MarkerTypeResource.EBENE -> "Ebène ($qte)"
    MarkerTypeResource.IF -> "If ($qte)"
    MarkerTypeResource.CHENE -> "Chêne ($qte)"
    MarkerTypeResource.PANDOUILLE -> "Pandouille ($qte)"
    MarkerTypeResource.ORCHIDEE -> "Orchidée Freyesque ($qte)"
    MarkerTypeResource.TREFLE -> "Trèfle à 5 feuilles ($qte)"
    MarkerTypeResource.MENTHE -> "Menthes Sauvage ($qte)"
    MarkerTypeResource.EDELWEISS -> "Edelweiss ($qte)"
    MarkerTypeResource.POISS_GEANT_MER -> "Poissons géants mer ($qte)"
    MarkerTypeResource.POISS_GEANT_RIV -> "Poissons géants rivière ($qte)"
    MarkerTypeResource.POISS_GROS_MER -> "Gros poissons mer ($qte)"
    MarkerTypeResource.POISS_GROS_RIV -> "Gros poissons rivière ($qte)"
    MarkerTypeResource.POISS_MER -> "Poissons mer ($qte)"
    MarkerTypeResource.POISS_RIV -> "Poissons rivière ($qte)"
    MarkerTypeResource.POISS_PETIT_MER -> "Petits poissons mer ($qte)"
    MarkerTypeResource.POISS_PETIT_RIV -> "Petits poissons rivière ($qte)"
}