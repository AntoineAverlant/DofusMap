package com.ademe.mapretro.utils.marker

import com.ademe.mapretro.utils.classes.*
import com.ademe.mapretro.utils.divers.*
import com.ademe.mapretro.utils.places.*
import com.ademe.mapretro.utils.resource.abra.resourceAbra
import com.ademe.mapretro.utils.resource.astrub.*
import com.ademe.mapretro.utils.resource.brakmar.resourceBrakmar
import com.ademe.mapretro.utils.resource.koalak.resourceKoalak
import com.ademe.mapretro.utils.resource.nowell.resourceNowell
import com.ademe.mapretro.utils.resource.pandala.resourcePandalaAir
import com.ademe.mapretro.utils.resource.pandala.resourcePandalaEau
import com.ademe.mapretro.utils.resource.pandala.resourcePandalaFeu
import com.ademe.mapretro.utils.resource.pandala.resourcePandalaTerre
import com.ademe.mapretro.utils.resource.sidimote.resourceSidimote
import com.ademe.mapretro.utils.resource.tainela.resourceTainela
import com.ademe.mapretro.utils.resource.wabbit.resourceWabbits

val markerDonjons = concatenate(markerDonjon)
val markerZaaps = concatenate(markerZaap)
val markerMines = concatenate(markerMine)
val markerEmotes = concatenate(markerEmote)

val markerAtelierHdv = concatenate(
    markerAtelierBouclier,
    markerAtelierBucheron,
    markerAtelierPaysan,
    markerAtelierTailleurs,
    markerAtelierCordo,
    markerAtelierSculpteur,
    markerAtelierForgerons,
    markerAtelierAlchi,
    markerAtelierMineurs,
    markerAtelierPecheur,
    markerAtelierBoulangers,
    markerAtelierBijou,
    markerAtelierBoucher,
    markerAtelierForgemage,
    markerAtelierBrico,
    markerAtelierFeeArti,
    markerHdvBouclier,
    markerHdvBucheron,
    markerHdvPaysan,
    markerHdvTailleurs,
    markerHdvParch,
    markerHdvAnimaux,
    markerHdvDocuments,
    markerHdvResource,
    markerHdvFeeArti,
    markerHdvBoucher,
    markerHdvBijou,
    markerHdvAmes,
    markerHdvBoulangers,
    markerHdvPecheur,
    markerHdvMineurs,
    markerHdvAlchi,
    markerHdvForgerons,
    markerHdvSculpteur,
    markerHdvCordo
)

val markerDivers = concatenate(
    markerArene,
    markerBanque,
    markerBateau,
    markerBibliotheque,
    markerCanon,
    markerChanil,
    markerDojo,
    markerEglise,
    markerEgouts,
    markerEnclos,
    markerGuilde,
    markerHotelMetier,
    markerKanojedo,
    markerMilice,
    markerPhenix,
    markerMarchande,
    markerTaverne,
    markerTour,
    markerTransporteurBrig
)

val markerClasses = concatenate(
    markerTempleEca,
    markerStatueEca,
    markerTempleFeca,
    markerStatueFeca,
    markerTempleSacri,
    markerStatueSacri,
    markerTempleOsa,
    markerStatueOsa,
    markerTempleIop,
    markerStatueIop,
    markerTempleSadi,
    markerStatueSadi,
    markerTempleXelor,
    markerStatueXelor,
    markerTempleCra,
    markerStatueCra,
    markerTempleEni,
    markerStatueEni,
    markerTempleSram,
    markerStatueSram,
    markerTempleEnu,
    markerStatueEnu,
    markerTemplePanda,
    markerStatuePanda
)

val markerLieuMenu = concatenate(markerClasses, markerDivers, markerAtelierHdv, markerEmotes, markerMines, markerZaaps, markerDonjons)

val markerResources = concatenate(
    resourceAbra,
    resourceAstrubChamp,
    resourceAstrubCite,
    resourceAstrubContour,
    resourceAstrubForet,
    resourceAstrubMine,
    resourceAstrubRepos,
    resourceKoalak,
    resourceBrakmar,
    resourcePandalaAir,
    resourcePandalaEau,
    resourcePandalaFeu,
    resourcePandalaTerre,
    resourceNowell,
    resourceTainela,
    resourceSidimote,
    resourceWabbits
)

var listTypeMarkerRes = mutableListOf(
    MarkerTypeRes.BOIS,
    MarkerTypeRes.MINERAI,
    MarkerTypeRes.FLEURS,
    MarkerTypeRes.POISSON,
    MarkerTypeRes.CEREAL
)
var listTypeMarkerResource = mutableListOf(
    MarkerTypeResource.PANDOUILLE,
    MarkerTypeResource.ORCHIDEE,
    MarkerTypeResource.TREFLE,
    MarkerTypeResource.MENTHE,
    MarkerTypeResource.EDELWEISS,
    MarkerTypeResource.POISS_GEANT_MER,
    MarkerTypeResource.POISS_GEANT_RIV,
    MarkerTypeResource.POISS_GROS_MER,
    MarkerTypeResource.POISS_GROS_RIV,
    MarkerTypeResource.POISS_MER,
    MarkerTypeResource.POISS_RIV,
    MarkerTypeResource.POISS_PETIT_MER,
    MarkerTypeResource.POISS_PETIT_RIV,
    MarkerTypeResource.RIZ,
    MarkerTypeResource.ORGE,
    MarkerTypeResource.MALT,
    MarkerTypeResource.LIN,
    MarkerTypeResource.CHANVRE,
    MarkerTypeResource.HOUBLON,
    MarkerTypeResource.AVOINE,
    MarkerTypeResource.BLE,
    MarkerTypeResource.SEIGLE,
    MarkerTypeResource.MANGANESE,
    MarkerTypeResource.PIERRE_CUIVREE,
    MarkerTypeResource.ARGENT,
    MarkerTypeResource.SILICATE,
    MarkerTypeResource.ETAIN,
    MarkerTypeResource.FER,
    MarkerTypeResource.DOLOMITE,
    MarkerTypeResource.PIERRE_KOBALTE,
    MarkerTypeResource.BRONZE,
    MarkerTypeResource.PIERRE_BAUXITE,
    MarkerTypeResource.OR,
    MarkerTypeResource.KALIPTUS,
    MarkerTypeResource.BOMBU,
    MarkerTypeResource.ERABLE,
    MarkerTypeResource.FRENE,
    MarkerTypeResource.BAMBOU_SACRE,
    MarkerTypeResource.BAMBOU_SOMBRE,
    MarkerTypeResource.BAMBOU,
    MarkerTypeResource.OLIVIOLET,
    MarkerTypeResource.MERISIER,
    MarkerTypeResource.NOYER,
    MarkerTypeResource.CHATAIGNIER,
    MarkerTypeResource.CHARME,
    MarkerTypeResource.ORME,
    MarkerTypeResource.EBENE,
    MarkerTypeResource.IF,
    MarkerTypeResource.CHENE
)