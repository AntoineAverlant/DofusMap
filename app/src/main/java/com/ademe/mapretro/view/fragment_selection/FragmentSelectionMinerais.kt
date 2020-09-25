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
import kotlinx.android.synthetic.main.fragment_minerais.*

class FragmentSelectionMinerais(private var listener: SelectionListener): Fragment() {
    private var mangaActivated = true
    private var cuivreActivated = true
    private var argentActivated = true
    private var silicateActivated = true
    private var etainActivated = true
    private var ferActivated = true
    private var doloActivated = true
    private var kobalteActivated = true
    private var bronzeActivated = true
    private var bauxiteActivated = true
    private var orActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_minerais, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        mangaButton.setOnClickListener {
            mangaActivated = mangaActivated.not()
            setImageButton(mangaActivated, mangaButton)
            listener.onResSelected(MarkerTypeResource.MANGANESE, mangaActivated)
        }
        cuivreButton.setOnClickListener {
            cuivreActivated = cuivreActivated.not()
            setImageButton(cuivreActivated, cuivreButton)
            listener.onResSelected(MarkerTypeResource.PIERRE_CUIVREE, cuivreActivated)
        }
        argentButton.setOnClickListener {
            argentActivated = argentActivated.not()
            setImageButton(argentActivated, argentButton)
            listener.onResSelected(MarkerTypeResource.ARGENT, argentActivated)
        }
        silicateButton.setOnClickListener {
            silicateActivated = silicateActivated.not()
            setImageButton(silicateActivated, silicateButton)
            listener.onResSelected(MarkerTypeResource.SILICATE, silicateActivated)
        }
        etainButton.setOnClickListener {
            etainActivated = etainActivated.not()
            setImageButton(etainActivated, etainButton)
            listener.onResSelected(MarkerTypeResource.ETAIN, etainActivated)
        }
        ferButton.setOnClickListener {
            ferActivated = ferActivated.not()
            setImageButton(ferActivated, etainButton)
            listener.onResSelected(MarkerTypeResource.FER, ferActivated)
        }
        doloButton.setOnClickListener {
            doloActivated = doloActivated.not()
            setImageButton(doloActivated, doloButton)
            listener.onResSelected(MarkerTypeResource.DOLOMITE, doloActivated)
        }
        kobaButton.setOnClickListener {
            kobalteActivated = kobalteActivated.not()
            setImageButton(kobalteActivated, kobaButton)
            listener.onResSelected(MarkerTypeResource.PIERRE_KOBALTE, kobalteActivated)
        }
        bronzeButton.setOnClickListener {
            bronzeActivated = bronzeActivated.not()
            setImageButton(bronzeActivated, bronzeButton)
            listener.onResSelected(MarkerTypeResource.BRONZE, bronzeActivated)
        }
        bauxiteButton.setOnClickListener {
            bauxiteActivated = bauxiteActivated.not()
            setImageButton(bauxiteActivated, bauxiteButton)
            listener.onResSelected(MarkerTypeResource.PIERRE_BAUXITE, bauxiteActivated)
        }
        orButton.setOnClickListener {
            orActivated = orActivated.not()
            setImageButton(orActivated, orButton)
            listener.onResSelected(MarkerTypeResource.OR, orActivated)
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