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
import kotlinx.android.synthetic.main.fragment_poisson.*

class FragmentSelectionPoisson(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

    private var pRivActivated = true
    private var rivActivated = true
    private var grRivActivated = true
    private var gRivActivated = true
    private var pMerActivated = true
    private var merActivated = true
    private var grMerActivated = true
    private var gMerActivated = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poisson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(pRivActivated, pRivButton)
        setImageButton(rivActivated, rivButton)
        setImageButton(grRivActivated, grRivButton)
        setImageButton(gRivActivated, gRivButton)
        setImageButton(pMerActivated, pMerButton)
        setImageButton(merActivated, merButton)
        setImageButton(grMerActivated, grMerButton)
        setImageButton(gMerActivated, gMerButton)

        pRivButton.setOnClickListener {
            pRivActivated = select(pRivActivated, pRivButton, MarkerTypeResource.POISS_PETIT_RIV)
            checkAllSelected()
        }
        rivButton.setOnClickListener {
            rivActivated = select(rivActivated, rivButton, MarkerTypeResource.POISS_RIV)
            checkAllSelected()
        }
        grRivButton.setOnClickListener {
            grRivActivated = select(grRivActivated, grRivButton, MarkerTypeResource.POISS_GROS_RIV)
            checkAllSelected()
        }
        gRivButton.setOnClickListener {
            gRivActivated = select(gRivActivated, gRivButton, MarkerTypeResource.POISS_GEANT_RIV)
            checkAllSelected()
        }
        pMerButton.setOnClickListener {
            pMerActivated = select(pMerActivated, pMerButton, MarkerTypeResource.POISS_PETIT_MER)
            checkAllSelected()
        }
        merButton.setOnClickListener {
            merActivated = select(merActivated, merButton, MarkerTypeResource.POISS_MER)
            checkAllSelected()
        }
        grMerButton.setOnClickListener {
            grMerActivated = select(grMerActivated, grMerButton, MarkerTypeResource.POISS_GROS_RIV)
            checkAllSelected()
        }
        gMerButton.setOnClickListener {
            gMerActivated = select(gMerActivated, gMerButton, MarkerTypeResource.POISS_GEANT_MER)
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
        listener.onResSelected(MarkerTypeRes.POISSON, type, activate)
        return activate
    }

    private fun setSelectAll(boolean: Boolean) {
        if (pRivActivated == boolean)
            pRivActivated = select(boolean, pRivButton, MarkerTypeResource.POISS_PETIT_RIV)

        if (rivActivated == boolean)
            rivActivated = select(boolean, rivButton, MarkerTypeResource.POISS_RIV)

        if (grRivActivated == boolean)
            grRivActivated = select(boolean, grRivButton, MarkerTypeResource.POISS_GROS_RIV)

        if (gRivActivated == boolean)
            gRivActivated = select(boolean, gRivButton, MarkerTypeResource.POISS_GEANT_RIV)

        if (pMerActivated == boolean)
            pMerActivated = select(boolean, pMerButton, MarkerTypeResource.POISS_PETIT_MER)

        if (merActivated == boolean)
            merActivated = select(boolean, merButton, MarkerTypeResource.POISS_MER)

        if (grMerActivated == boolean)
            grMerActivated = select(boolean, grMerButton, MarkerTypeResource.POISS_GROS_RIV)

        if (gMerActivated == boolean)
            gMerActivated = select(boolean, gMerButton, MarkerTypeResource.POISS_GEANT_MER)

        checkAllSelected()
    }

    private fun checkAllSelected() {
        isAllSelected =
            (pRivActivated && rivActivated && grRivActivated && gRivActivated && pMerActivated
                    && merActivated && grMerActivated && gMerActivated)
    }
}