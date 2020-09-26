package com.ademe.mapretro.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.*
import com.ademe.mapretro.view.fragment_selection.*

class MenuSelection(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet), SelectionListener {

    private var tmpMarkerLieu = markerLieuMenu

    private var tmpMarkerRes = markerResources.toMutableList()
    private val fragmentLieu =
        FragmentSelectionLieu(this)
    private val fragmentBois =
        FragmentSelectionBois(this)
    private val fragmentMinerais =
        FragmentSelectionMinerais(this)
    private val fragmentCereal =
        FragmentSelectionCereal(this)
    private val fragmentFleurs =
        FragmentSelectionFleurs(this)
    private val fragmentPoisson =
        FragmentSelectionPoisson(this)

    private var isExpanded = false

    private var isLieuEnabled = true
    private var isBoisEnabled = true
    private var isMineraisEnabled = true
    private var isCerealEnabled = true
    private var isFleursEnabled = true
    private var isPoissonEnabled = true

    private var fragmentContainer: FrameLayout
    private var lieuButton: ImageButton
    private var boisButton: ImageButton
    private var mineraisButton: ImageButton
    private var cerealButton: ImageButton
    private var fleursButton: ImageButton
    private var poissonButton: ImageButton
    private var toggle: ImageButton

    private lateinit var supportFragmentManager: FragmentManager

    var onLieuMenuClick: (List<MarkerLieu>, Boolean) -> Unit = { _, _ -> }

    var onResMenuClick: (List<MarkerRes>, Boolean) -> Unit = { _, _ -> }

    init {
        View.inflate(
            context,
            R.layout.menu_selection, this
        )

        fragmentContainer = findViewById(R.id.fragmentContainer)
        lieuButton = findViewById(R.id.lieuButton)
        boisButton = findViewById(R.id.boisButton)
        mineraisButton = findViewById(R.id.mineraisButton)
        cerealButton = findViewById(R.id.cerealButton)
        fleursButton = findViewById(R.id.fleursButton)
        poissonButton = findViewById(R.id.poissonButton)
        toggle = findViewById(R.id.toggle)

        toggle.setOnClickListener {
            isExpanded = isExpanded.not()
            if (isExpanded) {
                toggle.rotation = 0F
                fragmentContainer.visibility = View.VISIBLE
            } else {
                toggle.rotation = 180F
                fragmentContainer.visibility = View.GONE
            }
        }

        lieuButton.setOnClickListener {
            isLieuEnabled = onLieuButtonClick(isLieuEnabled, tmpMarkerLieu, fragmentLieu)
            setView(isLieuEnabled, lieuButton)
        }

        boisButton.setOnClickListener {
            isBoisEnabled = onResButtonClick(isBoisEnabled, MarkerTypeRes.BOIS, fragmentBois)
            setView(isBoisEnabled, boisButton)
        }
        mineraisButton.setOnClickListener {
            isMineraisEnabled =
                onResButtonClick(isMineraisEnabled, MarkerTypeRes.MINERAI, fragmentMinerais)
            setView(isMineraisEnabled, mineraisButton)
        }
        cerealButton.setOnClickListener {
            isCerealEnabled =
                onResButtonClick(isCerealEnabled, MarkerTypeRes.CEREAL, fragmentCereal)
            setView(isCerealEnabled, cerealButton)
        }
        fleursButton.setOnClickListener {
            isFleursEnabled =
                onResButtonClick(isFleursEnabled, MarkerTypeRes.FLEURS, fragmentFleurs)
            setView(isFleursEnabled, fleursButton)
        }
        poissonButton.setOnClickListener {
            isPoissonEnabled =
                onResButtonClick(isPoissonEnabled, MarkerTypeRes.POISSON, fragmentPoisson)
            setView(isPoissonEnabled, poissonButton)
        }
    }


    fun init(supportFragmentManager: FragmentManager) {
        this.supportFragmentManager = supportFragmentManager
        setFragment(fragmentLieu)
    }


    private fun onLieuButtonClick(
        isEnabled: Boolean,
        list: List<MarkerLieu>,
        fragment: BaseFragment
    ): Boolean {
        var isEnable = isEnabled

        if (isExpanded && supportFragmentManager.findFragmentById(R.id.fragmentContainer) != fragment) {
            setFragment(fragment)
        } else if (isExpanded && isEnable) {
            fragment.selectAll()
        } else {
            isEnable = isEnabled.not()
            onLieuMenuClick(list, isEnable)
        }
        return isEnable
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }

    private fun setView(activated: Boolean, imageButton: ImageButton) {
        if (activated) {
            imageButton.clearColorFilter()
        } else {
            imageButton.setColorFilter(
                context.getColor(R.color.colorTint),
                android.graphics.PorterDuff.Mode.MULTIPLY
            )
        }
    }

    override fun onLieuSelected(list: List<MarkerLieu>, enabled: Boolean) {
        if (enabled) {
            tmpMarkerLieu.addAll(list)
        } else {
            tmpMarkerLieu.removeAll(list)
        }
        if (isLieuEnabled) {
            onLieuMenuClick(list, enabled)
        }
    }

    // RESOURCES

    private fun calculateListRes(markerTypeRes: MarkerTypeRes): List<MarkerRes> {
        return tmpMarkerRes.filter {
            it.type.contains(markerTypeRes) && it.hashMapTypeQte.keys.intersect(
                listTypeMarkerResource.asIterable()
            ).isEmpty()
        }
    }

    private fun calculateListResource(
        markerTypeRes: MarkerTypeRes,
        markerTypeResource: MarkerTypeResource
    ): List<MarkerRes> {
        return markerResources.filter {
            it.hashMapTypeQte.keys.contains(markerTypeResource) && it.hashMapTypeQte.keys.intersect(
                listTypeMarkerResource.asIterable()
            ).isEmpty()
        }
    }

    private fun onResButtonClick(
        isEnabled: Boolean,
        markerTypeRes: MarkerTypeRes,
        fragment: BaseFragment
    ): Boolean {
        var isEnable = isEnabled
        if (isExpanded && supportFragmentManager.findFragmentById(R.id.fragmentContainer) != fragment) {
            setFragment(fragment)
        } else if (isExpanded && isEnable) {
            fragment.selectAll()
        } else {
            isEnable = isEnabled.not()

            if(isEnable) {
                onResMenuClick(calculateListRes(markerTypeRes), isEnable)
                when (markerTypeRes) {
                    MarkerTypeRes.MINERAI -> listTypeMarkerResource.addAll(listTypeMarkerMinerais)
                    MarkerTypeRes.CEREAL -> listTypeMarkerResource.addAll(listTypeMarkerCereal)
                    MarkerTypeRes.BOIS -> listTypeMarkerResource.addAll(listTypeMarkerBois)
                    MarkerTypeRes.FLEURS -> listTypeMarkerResource.addAll(listTypeMarkerFleur)
                    MarkerTypeRes.POISSON -> listTypeMarkerResource.addAll(listTypeMarkerPoisson)
                }
            } else {
                when (markerTypeRes) {
                    MarkerTypeRes.MINERAI -> listTypeMarkerResource.removeAll(listTypeMarkerMinerais)
                    MarkerTypeRes.CEREAL -> listTypeMarkerResource.removeAll(listTypeMarkerCereal)
                    MarkerTypeRes.BOIS -> listTypeMarkerResource.removeAll(listTypeMarkerBois)
                    MarkerTypeRes.FLEURS -> listTypeMarkerResource.removeAll(listTypeMarkerFleur)
                    MarkerTypeRes.POISSON -> listTypeMarkerResource.removeAll(listTypeMarkerPoisson)
                }
                onResMenuClick(calculateListRes(markerTypeRes), isEnable)
            }
        }
        return isEnable
    }

    override fun onResSelected(
        markerTypeRes: MarkerTypeRes,
        markerTypeResource: MarkerTypeResource,
        enabled: Boolean
    ) {
        val list = if (enabled) {
            val list = calculateListResource(markerTypeRes, markerTypeResource)
            listTypeMarkerResource.add(markerTypeResource)
            tmpMarkerRes.addAll(list)

            when (markerTypeRes) {
                MarkerTypeRes.MINERAI -> listTypeMarkerMinerais.add(markerTypeResource)
                MarkerTypeRes.CEREAL -> listTypeMarkerCereal.add(markerTypeResource)
                MarkerTypeRes.BOIS -> listTypeMarkerBois.add(markerTypeResource)
                MarkerTypeRes.FLEURS -> listTypeMarkerFleur.add(markerTypeResource)
                MarkerTypeRes.POISSON -> listTypeMarkerPoisson.add(markerTypeResource)
            }

            list
        } else {
            listTypeMarkerResource.remove(markerTypeResource)

            when (markerTypeRes) {
                MarkerTypeRes.MINERAI -> listTypeMarkerMinerais.remove(markerTypeResource)
                MarkerTypeRes.CEREAL -> listTypeMarkerCereal.remove(markerTypeResource)
                MarkerTypeRes.BOIS -> listTypeMarkerBois.remove(markerTypeResource)
                MarkerTypeRes.FLEURS -> listTypeMarkerFleur.remove(markerTypeResource)
                MarkerTypeRes.POISSON -> listTypeMarkerPoisson.remove(markerTypeResource)
            }

            val list = calculateListResource(markerTypeRes, markerTypeResource)
            tmpMarkerRes.removeAll(list)

            list
        }
        val isActivate = when (markerTypeRes) {
            MarkerTypeRes.MINERAI -> isMineraisEnabled
            MarkerTypeRes.CEREAL -> isCerealEnabled
            MarkerTypeRes.BOIS -> isBoisEnabled
            MarkerTypeRes.FLEURS -> isFleursEnabled
            MarkerTypeRes.POISSON -> isPoissonEnabled
        }
        if (isActivate) {
            onResMenuClick(list, enabled)
        }
    }
}