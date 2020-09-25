package com.ademe.mapretro.view.fragment_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.*
import com.ademe.mapretro.view.SelectionListener
import kotlinx.android.synthetic.main.fragment_lieu.*

class FragmentSelectionLieu(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

    private var zaapActivated = true
    private var diversActivated = true
    private var minesActivated = true
    private var atelierActivated = true
    private var classeActivated = true
    private var emoteActivated = true
    private var donjonActivated = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lieu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(zaapActivated, zaapButton)
        setImageButton(diversActivated, diversButton)
        setImageButton(minesActivated, mineButton)
        setImageButton(atelierActivated, atelierButton)
        setImageButton(classeActivated, classeButton)
        setImageButton(emoteActivated, emoteButton)
        setImageButton(donjonActivated, donjonButton)

        zaapButton.setOnClickListener {
            zaapActivated = select(zaapActivated, zaapButton, markerZaaps)
            checkAllSelected()
        }
        diversButton.setOnClickListener {
            diversActivated = select(diversActivated, diversButton, markerDivers)
            checkAllSelected()
        }
        mineButton.setOnClickListener {
            minesActivated = select(minesActivated, mineButton, markerMines)
            checkAllSelected()
        }
        atelierButton.setOnClickListener {
            atelierActivated = select(atelierActivated, atelierButton, markerAtelierHdv)
            checkAllSelected()
        }
        classeButton.setOnClickListener {
            classeActivated = select(classeActivated, classeButton, markerClasses)
            checkAllSelected()
        }
        emoteButton.setOnClickListener {
            emoteActivated = select(emoteActivated, emoteButton, markerEmotes)
            checkAllSelected()
        }
        donjonButton.setOnClickListener {
            donjonActivated = select(donjonActivated, donjonButton, markerDonjons)
            checkAllSelected()
        }
    }

    override fun selectAll() {
        if (isAllSelected) {
            setSelectAll(true)
        } else {
            setSelectAll(false)
        }
    }

    private fun select(activated: Boolean, button: ImageButton, list: List<MarkerLieu>): Boolean {
        val activate = activated.not()
        setImageButton(activate, button)
        listener.onLieuSelected(list, activate)
        return activate
    }

    private fun checkAllSelected() {
        isAllSelected =
            zaapActivated && diversActivated && minesActivated && atelierActivated && classeActivated && emoteActivated && donjonActivated
    }

    private fun setSelectAll(boolean: Boolean) {
        if (zaapActivated == boolean)
            zaapActivated = select(boolean, zaapButton, markerZaaps)

        if (diversActivated == boolean)
            diversActivated = select(boolean, diversButton, markerDivers)

        if (minesActivated == boolean)
            minesActivated = select(boolean, mineButton, markerMines)

        if (atelierActivated == boolean)
            atelierActivated = select(boolean, atelierButton, markerAtelierHdv)

        if (classeActivated == boolean)
            classeActivated = select(boolean, classeButton, markerClasses)

        if (emoteActivated == boolean)
            emoteActivated = select(boolean, emoteButton, markerEmotes)

        if (donjonActivated == boolean)
            donjonActivated = select(boolean, donjonButton, markerDonjons)
        checkAllSelected()
    }
}