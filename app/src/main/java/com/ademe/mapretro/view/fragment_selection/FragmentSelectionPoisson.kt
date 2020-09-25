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
import kotlinx.android.synthetic.main.fragment_poisson.*

class FragmentSelectionPoisson(private var listener: SelectionListener): Fragment() {
    private var pRivActivated = true
    private var rivActivated = true
    private var grRivActivated = true
    private var gRivActivated = true
    private var pMerActivated = true
    private var merActivated = true
    private var grMerActivated = true
    private var gMerActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_poisson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        pRivButton.setOnClickListener {
            pRivActivated = pRivActivated.not()
            setImageButton(pRivActivated, pRivButton)
            listener.onResSelected(MarkerTypeResource.POISS_PETIT_RIV, pRivActivated)
        }
        rivButton.setOnClickListener {
            rivActivated = rivActivated.not()
            setImageButton(rivActivated, rivButton)
            listener.onResSelected(MarkerTypeResource.POISS_RIV, rivActivated)
        }
        grRivButton.setOnClickListener {
            grRivActivated = grRivActivated.not()
            setImageButton(grRivActivated, grRivButton)
            listener.onResSelected(MarkerTypeResource.POISS_GROS_RIV, grRivActivated)
        }
        gRivButton.setOnClickListener {
            gRivActivated = gRivActivated.not()
            setImageButton(gRivActivated, gRivButton)
            listener.onResSelected(MarkerTypeResource.POISS_GEANT_RIV, gRivActivated)
        }
        pMerButton.setOnClickListener {
            pMerActivated = pMerActivated.not()
            setImageButton(pMerActivated, pMerButton)
            listener.onResSelected(MarkerTypeResource.POISS_PETIT_MER, pMerActivated)
        }
        merButton.setOnClickListener {
            merActivated = merActivated.not()
            setImageButton(merActivated, merButton)
            listener.onResSelected(MarkerTypeResource.POISS_MER, merActivated)
        }
        grMerButton.setOnClickListener {
            grMerActivated = grMerActivated.not()
            setImageButton(grMerActivated, grMerButton)
            listener.onResSelected(MarkerTypeResource.POISS_GROS_RIV, grMerActivated)
        }
        gMerButton.setOnClickListener {
            gMerActivated = gMerActivated.not()
            setImageButton(gMerActivated, gMerButton)
            listener.onResSelected(MarkerTypeResource.POISS_GEANT_MER, gMerActivated)
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