package com.ademe.mapretro.view.fragment_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.*
import com.ademe.mapretro.view.SelectionListener
import kotlinx.android.synthetic.main.fragment_fleurs.*

class FragmentSelectionFleurs(private var listener: SelectionListener): Fragment() {
    private var pandouilleActivated = true
    private var orchActivated = true
    private var trefleActivated = true
    private var mentheActivated = true
    private var edelActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fleurs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        pandButton.setOnClickListener {
            pandouilleActivated = pandouilleActivated.not()
            setImageButton(pandouilleActivated, pandButton)
            listener.onResSelected(MarkerTypeResource.PANDOUILLE, pandouilleActivated)
        }
        orchButton.setOnClickListener {
            orchActivated = orchActivated.not()
            setImageButton(orchActivated, orchButton)
            listener.onResSelected(MarkerTypeResource.ORCHIDEE, orchActivated)
        }
        trefleButton.setOnClickListener {
            trefleActivated = trefleActivated.not()
            setImageButton(trefleActivated, trefleButton)
            listener.onResSelected(MarkerTypeResource.TREFLE, trefleActivated)
        }
        mentheButton.setOnClickListener {
            mentheActivated = mentheActivated.not()
            setImageButton(mentheActivated, mentheButton)
            listener.onResSelected(MarkerTypeResource.MENTHE, mentheActivated)
        }
        edelButton.setOnClickListener {
            edelActivated = edelActivated.not()
            setImageButton(edelActivated, edelButton)
            listener.onResSelected(MarkerTypeResource.EDELWEISS, edelActivated)
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