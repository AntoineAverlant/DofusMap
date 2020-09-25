package com.ademe.mapretro.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.*

class ViewPagerSelection(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet), SelectionListener {

    private var tmpMarkerLieu = markerLieuMenu
    private val fragmentLieu = FragmentSelectionLieu(this)
    private var isExpanded = false
    private var isLieuEnabled = true

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

    init {
        View.inflate(
            context,
            R.layout.viewpager_selection, this
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
            setView()
        }
    }


    fun init(supportFragmentManager: FragmentManager) {
        this.supportFragmentManager = supportFragmentManager
        setView()
        setFragment(fragmentLieu)
    }

    private fun onLieuButtonClick(isEnabled: Boolean, list: List<MarkerLieu>, fragment: Fragment):Boolean {
        var isEnable = isEnabled
        if (isExpanded) {
            setFragment(fragment)
        } else {
            isEnable = isEnabled.not()
            onLieuMenuClick(list, isEnable)
        }
        return isEnable
    }

    private fun setView() {
        setView(isLieuEnabled, lieuButton)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
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
        if(enabled) {
            tmpMarkerLieu.addAll(list)
        } else {
            tmpMarkerLieu.removeAll(list)
        }
        onLieuMenuClick(list, enabled)
    }

}

/*
boisButton.setOnClickListener {
            if (isExpanded) {
                setFragment(fragmentDivers)
            } else {
                boisActivated = boisActivated.not()
                setView()
                onMenuClick(MarkerMenuMapType.BOIS_MENU, boisActivated)
            }
        }
        mineraisButton.setOnClickListener {
            if (isExpanded) {
                setFragment(fragmentDivers)
            } else {
                mineraisActivated = mineraisActivated.not()
                setView()
                onMenuClick(MarkerMenuMapType.MINERAIS_MENU, mineraisActivated)
            }
        }
        cerealButton.setOnClickListener {
            if (isExpanded) {
                setFragment(fragmentDivers)
            } else {
                cerealActivated = cerealActivated.not()
                setView()
                onMenuClick(MarkerMenuMapType.CEREAL_MENU, cerealActivated)
            }
        }
        fleursButton.setOnClickListener {
            if (isExpanded) {
                setFragment(fragmentDivers)
            } else {
                fleursActivated = fleursActivated.not()
                setView()
                onMenuClick(MarkerMenuMapType.FLEURS_MENU, fleursActivated)
            }
        }
        poissonButton.setOnClickListener {
            if (isExpanded) {
                setFragment(fragmentDivers)
            } else {
                poissonsActivated = poissonsActivated.not()
                setView()
                onMenuClick(MarkerMenuMapType.POISSONS_MENU, poissonsActivated)
            }
        }
 */