package com.ademe.mapretro.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.map.MarkerMapType

class MenuSelection(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    private var zaapActivated = false
    private var diversActivated = false
    private var minesActivated = false
    private var atelierActivated = false
    private var classeActivated = false
    private var emoteActivated = false
    private var donjonActivated = false

    private var zaapButton: ImageButton
    private var diversButton: ImageButton
    private var mineButton: ImageButton
    private var atelierButton: ImageButton
    private var classeButton: ImageButton
    private var emoteButton: ImageButton
    private var donjonButton: ImageButton

    var onMenuClick: (MarkerMapType, Boolean) -> Unit = { _, _ -> }

    init {
        View.inflate(
            context,
            R.layout.menu_selection, this
        )

        zaapButton = findViewById(R.id.zaapButton)
        diversButton = findViewById(R.id.diversButton)
        mineButton = findViewById(R.id.mineButton)
        atelierButton = findViewById(R.id.atelierButton)
        classeButton = findViewById(R.id.classeButton)
        emoteButton = findViewById(R.id.emoteButton)
        donjonButton = findViewById(R.id.donjonButton)

        zaapButton.setOnClickListener {
            emoteActivated = emoteActivated.not()
            setView()
            onMenuClick(MarkerMapType.EMOTE, emoteActivated)
        }

        zaapButton.setOnClickListener {
            zaapActivated = zaapActivated.not()
            setView()
            onMenuClick(MarkerMapType.ZAAPS, zaapActivated)
        }

        diversButton.setOnClickListener {
            diversActivated = diversActivated.not()
            setView()
            onMenuClick(MarkerMapType.DIVERS, diversActivated)
        }

        mineButton.setOnClickListener {
            minesActivated = minesActivated.not()
            setView()
            onMenuClick(MarkerMapType.MINES, minesActivated)
        }

        atelierButton.setOnClickListener {
            atelierActivated = atelierActivated.not()
            setView()
            onMenuClick(MarkerMapType.ATELIER_HDV, atelierActivated)
        }

        classeButton.setOnClickListener {
            classeActivated = classeActivated.not()
            setView()
            onMenuClick(MarkerMapType.CLASSES, classeActivated)
        }

        emoteButton.setOnClickListener {
            emoteActivated = emoteActivated.not()
            setView()
            onMenuClick(MarkerMapType.EMOTE, emoteActivated)
        }

        donjonButton.setOnClickListener {
            donjonActivated = donjonActivated.not()
            setView()
            onMenuClick(MarkerMapType.DONJONS, donjonActivated)
        }
    }


    fun init(
        zaapActivated: Boolean = false,
        diversActivated: Boolean = false,
        minesActivated: Boolean = false,
        atelierActivated: Boolean = false,
        classeActivated: Boolean = false,
        donjonActivated: Boolean = false,
        emoteActivated: Boolean = false
    ) {
        this.zaapActivated = zaapActivated
        this.diversActivated = diversActivated
        this.minesActivated = minesActivated
        this.atelierActivated = atelierActivated
        this.classeActivated = classeActivated
        this.emoteActivated = emoteActivated
        this.donjonActivated = donjonActivated

        setView()
    }

    private fun setView() {
        setView(zaapActivated, zaapButton)
        setView(diversActivated, diversButton)
        setView(minesActivated, mineButton)
        setView(atelierActivated, atelierButton)
        setView(classeActivated, classeButton)
        setView(emoteActivated, emoteButton)
        setView(donjonActivated, donjonButton)
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
}