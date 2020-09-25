package com.ademe.mapretro.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.*
import kotlinx.android.synthetic.main.fragment_lieu.*

class FragmentSelectionLieu(private var listener: SelectionListener): Fragment() {
    private lateinit var mView: View

    private var zaapActivated = true
    private var diversActivated = true
    private var minesActivated = true
    private var atelierActivated = true
    private var classeActivated = true
    private var emoteActivated = true
    private var donjonActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lieu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        zaapButton.setOnClickListener {
            zaapActivated = zaapActivated.not()
            setImageButton(zaapActivated, zaapButton)
            listener.onLieuSelected(markerZaaps, zaapActivated)
        }
        diversButton.setOnClickListener {
            diversActivated = diversActivated.not()
            setImageButton(diversActivated, diversButton)
            listener.onLieuSelected(markerDivers, diversActivated)
        }
        mineButton.setOnClickListener {
            minesActivated = minesActivated.not()
            setImageButton(minesActivated, mineButton)
            listener.onLieuSelected(markerMines, minesActivated)
        }
        atelierButton.setOnClickListener {
            atelierActivated = atelierActivated.not()
            setImageButton(atelierActivated, atelierButton)
            listener.onLieuSelected(markerAtelierHdv, atelierActivated)
        }
        classeButton.setOnClickListener {
            classeActivated = classeActivated.not()
            setImageButton(classeActivated, classeButton)
            listener.onLieuSelected(markerClasses, classeActivated)
        }
        emoteButton.setOnClickListener {
            emoteActivated = emoteActivated.not()
            setImageButton(emoteActivated, emoteButton)
            listener.onLieuSelected(markerEmotes, emoteActivated)
        }
        donjonButton.setOnClickListener {
            donjonActivated = donjonActivated.not()
            setImageButton(donjonActivated, donjonButton)
            listener.onLieuSelected(markerDonjons, donjonActivated)
        }
    }

    private fun setImageButton(activated: Boolean, imageButton: ImageButton) {
        if (activated) {
            imageButton.clearColorFilter()
        } else {
            context?.let {
                imageButton.setColorFilter(
                    it.getColor(R.color.colorTint),
                    android.graphics.PorterDuff.Mode.MULTIPLY
                )
            }
        }
    }
}