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

val markerBois = markerResources.filter { it -> it.type.contains(MarkerTypeRes.BOIS) }
val markerMinerais = markerResources.filter { it -> it.type.contains(MarkerTypeRes.MINERAI) }
val markerCereal = markerResources.filter { it -> it.type.contains(MarkerTypeRes.CEREAL) }
val markerFleurs = markerResources.filter { it -> it.type.contains(MarkerTypeRes.FLEURS) }
val markerPoisson = markerResources.filter { it -> it.type.contains(MarkerTypeRes.POISSON) }