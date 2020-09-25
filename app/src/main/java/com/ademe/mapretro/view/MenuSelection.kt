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
            isMineraisEnabled = onResButtonClick(isMineraisEnabled, MarkerTypeRes.MINERAI, fragmentMinerais)
            setView(isMineraisEnabled, mineraisButton)
        }
        cerealButton.setOnClickListener {
            isCerealEnabled = onResButtonClick(isCerealEnabled, MarkerTypeRes.CEREAL, fragmentCereal)
            setView(isCerealEnabled, cerealButton)
        }
        fleursButton.setOnClickListener {
            isFleursEnabled = onResButtonClick(isFleursEnabled, MarkerTypeRes.FLEURS, fragmentFleurs)
            setView(isFleursEnabled, fleursButton)
        }
        poissonButton.setOnClickListener {
            isPoissonEnabled = onResButtonClick(isPoissonEnabled, MarkerTypeRes.POISSON, fragmentPoisson)
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
        fragment: Fragment
    ): Boolean {
        var isEnable = isEnabled
        if (isExpanded && supportFragmentManager.findFragmentById(R.id.fragmentContainer) != fragment) {
            setFragment(fragment)
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
        onLieuMenuClick(list, enabled)
    }

    // RESOURCES

    private fun calculateListRes(markerTypeRes: MarkerTypeRes): List<MarkerRes> {
        return tmpMarkerRes.filter {
            it.type.contains(markerTypeRes) && it.type.intersect(
                listTypeMarkerRes.asIterable()
            ).isEmpty()
        }
    }

    private fun calculateListResource(markerTypeRes: MarkerTypeResource): List<MarkerRes> {
        return markerResources.filter {
            it.hashMapTypeQte.keys.contains(markerTypeRes) && it.hashMapTypeQte.keys.intersect(
                listTypeMarkerResource.asIterable()
            ).isEmpty()
        }
    }

    private fun onResButtonClick(
        isEnabled: Boolean,
        markerTypeRes: MarkerTypeRes,
        fragment: Fragment
    ): Boolean {
        var isEnable = isEnabled
        if (isExpanded && supportFragmentManager.findFragmentById(R.id.fragmentContainer) != fragment) {
            setFragment(fragment)
        } else {
            isEnable = isEnabled.not()
            if (listTypeMarkerRes.contains(markerTypeRes)) {
                listTypeMarkerRes.remove(markerTypeRes)
                onResMenuClick(calculateListRes(markerTypeRes), isEnable)
            } else {
                onResMenuClick(calculateListRes(markerTypeRes), isEnable)
                listTypeMarkerRes.add(markerTypeRes)
            }
        }
        return isEnable
    }

    override fun onResSelected(
        markerTypeResource: MarkerTypeResource,
        enabled: Boolean
    ) {
        if(enabled) {
            val list = calculateListResource(markerTypeResource)
            listTypeMarkerResource.add(markerTypeResource)
            tmpMarkerRes.addAll(list)
            onResMenuClick(list, enabled)
        } else {
            listTypeMarkerResource.remove(markerTypeResource)
            val list = calculateListResource(markerTypeResource)
            tmpMarkerRes.removeAll(list)
            onResMenuClick(list, enabled)
        }
    }
}