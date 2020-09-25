package com.ademe.mapretro.view.fragment_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerTypeRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource
import com.ademe.mapretro.view.SelectionListener
import kotlinx.android.synthetic.main.fragment_minerais.*

class FragmentSelectionMinerais(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_minerais, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(mangaActivated, mangaButton)
        setImageButton(cuivreActivated, cuivreButton)
        setImageButton(argentActivated, argentButton)
        setImageButton(silicateActivated, silicateButton)
        setImageButton(etainActivated, etainButton)
        setImageButton(ferActivated, ferButton)
        setImageButton(doloActivated, doloButton)
        setImageButton(kobalteActivated, kobaButton)
        setImageButton(bronzeActivated, bronzeButton)
        setImageButton(bauxiteActivated, bauxiteButton)
        setImageButton(orActivated, orButton)

        mangaButton.setOnClickListener {
            mangaActivated = select(mangaActivated, mangaButton, MarkerTypeResource.MANGANESE)
            checkAllSelected()
        }
        cuivreButton.setOnClickListener {
            cuivreActivated =
                select(cuivreActivated, cuivreButton, MarkerTypeResource.PIERRE_CUIVREE)
            checkAllSelected()
        }
        argentButton.setOnClickListener {
            argentActivated = select(argentActivated, argentButton, MarkerTypeResource.ARGENT)
            checkAllSelected()
        }
        silicateButton.setOnClickListener {
            silicateActivated =
                select(silicateActivated, silicateButton, MarkerTypeResource.SILICATE)
            checkAllSelected()
        }
        etainButton.setOnClickListener {
            etainActivated = select(etainActivated, etainButton, MarkerTypeResource.ETAIN)
            checkAllSelected()
        }
        ferButton.setOnClickListener {
            ferActivated = select(ferActivated, ferButton, MarkerTypeResource.FER)
            checkAllSelected()
        }
        doloButton.setOnClickListener {
            doloActivated = select(doloActivated, doloButton, MarkerTypeResource.DOLOMITE)
            checkAllSelected()
        }
        kobaButton.setOnClickListener {
            kobalteActivated =
                select(kobalteActivated, kobaButton, MarkerTypeResource.PIERRE_KOBALTE)
            checkAllSelected()
        }
        bronzeButton.setOnClickListener {
            bronzeActivated = select(bronzeActivated, bronzeButton, MarkerTypeResource.BRONZE)
            checkAllSelected()
        }
        bauxiteButton.setOnClickListener {
            bauxiteActivated =
                select(bauxiteActivated, bauxiteButton, MarkerTypeResource.PIERRE_BAUXITE)
            checkAllSelected()
        }
        orButton.setOnClickListener {
            orActivated = select(orActivated, orButton, MarkerTypeResource.OR)
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

    private fun select(activated: Boolean, button: ImageButton, type: MarkerTypeResource): Boolean {
        val activate = activated.not()
        setImageButton(activate, button)
        listener.onResSelected(MarkerTypeRes.MINERAI, type, activate)
        return activate
    }

    private fun setSelectAll(boolean: Boolean) {
        if (mangaActivated == boolean)
            mangaActivated = select(boolean, mangaButton, MarkerTypeResource.MANGANESE)

        if (cuivreActivated == boolean)
            cuivreActivated = select(boolean, cuivreButton, MarkerTypeResource.PIERRE_CUIVREE)

        if (argentActivated == boolean)
            argentActivated = select(boolean, argentButton, MarkerTypeResource.ARGENT)

        if (silicateActivated == boolean)
            silicateActivated = select(boolean, silicateButton, MarkerTypeResource.SILICATE)

        if (etainActivated == boolean)
            etainActivated = select(boolean, etainButton, MarkerTypeResource.ETAIN)

        if (ferActivated == boolean)
            ferActivated = select(boolean, ferButton, MarkerTypeResource.FER)

        if (doloActivated == boolean)
            doloActivated = select(boolean, doloButton, MarkerTypeResource.DOLOMITE)

        if (kobalteActivated == boolean)
            kobalteActivated = select(boolean, kobaButton, MarkerTypeResource.PIERRE_KOBALTE)

        if (bronzeActivated == boolean)
            bronzeActivated = select(boolean, bronzeButton, MarkerTypeResource.BRONZE)

        if (bauxiteActivated == boolean)
            bauxiteActivated = select(boolean, bauxiteButton, MarkerTypeResource.PIERRE_BAUXITE)

        if (orActivated == boolean)
            orActivated = select(boolean, orButton, MarkerTypeResource.OR)

        checkAllSelected()
    }

    private fun checkAllSelected() {
        isAllSelected =
            (mangaActivated && cuivreActivated && argentActivated && silicateActivated && etainActivated
                    && ferActivated && doloActivated && kobalteActivated && bronzeActivated && bauxiteActivated
                    && orActivated)
    }
}