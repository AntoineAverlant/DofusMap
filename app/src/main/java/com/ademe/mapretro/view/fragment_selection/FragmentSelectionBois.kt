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
import kotlinx.android.synthetic.main.fragment_bois.*

class FragmentSelectionBois(private var listener: SelectionListener): Fragment() {

    private var kaliptusActivated = true
    private var bombuActivated = true
    private var erableActivated = true
    private var freneActivated = true
    private var bambouSacreActivated = true
    private var bambouSombreActivated = true
    private var bambouActivated = true
    private var olivioletActivated = true
    private var merisierActivated = true
    private var noyerActivated = true
    private var chataignerActivated = true
    private var ormeActivated = true
    private var ebeneActivated = true
    private var ifActivated = true
    private var cheneActivated = true
    private var charmeActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bois, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        kaliptusButton.setOnClickListener {
            kaliptusActivated = kaliptusActivated.not()
            setImageButton(kaliptusActivated, kaliptusButton)
            listener.onResSelected(MarkerTypeResource.KALIPTUS, kaliptusActivated)
        }
        bombuButton.setOnClickListener {
            bombuActivated = bombuActivated.not()
            setImageButton(bombuActivated, bombuButton)
            listener.onResSelected(MarkerTypeResource.BOMBU, bombuActivated)
        }
        erableButton.setOnClickListener {
            erableActivated = erableActivated.not()
            setImageButton(erableActivated, erableButton)
            listener.onResSelected(MarkerTypeResource.ERABLE, erableActivated)
        }
        freneButton.setOnClickListener {
            freneActivated = freneActivated.not()
            setImageButton(freneActivated, freneButton)
            listener.onResSelected(MarkerTypeResource.FRENE, freneActivated)
        }
        bambouSacreButton.setOnClickListener {
            bambouSacreActivated = bambouSacreActivated.not()
            setImageButton(bambouSacreActivated, bambouSacreButton)
            listener.onResSelected(MarkerTypeResource.BAMBOU_SACRE, bambouSacreActivated)
        }
        bambouSombreButton.setOnClickListener {
            bambouSombreActivated = bambouSombreActivated.not()
            setImageButton(bambouSombreActivated, bambouSombreButton)
            listener.onResSelected(MarkerTypeResource.BAMBOU_SOMBRE, bambouSombreActivated)
        }
        bambouButton.setOnClickListener {
            bambouActivated = bambouActivated.not()
            setImageButton(bambouActivated, bambouButton)
            listener.onResSelected(MarkerTypeResource.BAMBOU, bambouActivated)
        }
        olivioletButton.setOnClickListener {
            olivioletActivated = olivioletActivated.not()
            setImageButton(olivioletActivated, olivioletButton)
            listener.onResSelected(MarkerTypeResource.OLIVIOLET, olivioletActivated)
        }
        merisierButton.setOnClickListener {
            merisierActivated = merisierActivated.not()
            setImageButton(merisierActivated, merisierButton)
            listener.onResSelected(MarkerTypeResource.MERISIER, merisierActivated)
        }
        noyerButton.setOnClickListener {
            noyerActivated = noyerActivated.not()
            setImageButton(noyerActivated, noyerButton)
            listener.onResSelected(MarkerTypeResource.NOYER, noyerActivated)
        }
        kobaButton.setOnClickListener {
            chataignerActivated = chataignerActivated.not()
            setImageButton(chataignerActivated, kobaButton)
            listener.onResSelected(MarkerTypeResource.CHATAIGNIER, chataignerActivated)
        }
        ormeButton.setOnClickListener {
            ormeActivated = ormeActivated.not()
            setImageButton(ormeActivated, ormeButton)
            listener.onResSelected(MarkerTypeResource.ORME, ormeActivated)
        }
        ebeneButton.setOnClickListener {
            ebeneActivated = ebeneActivated.not()
            setImageButton(ebeneActivated, ebeneButton)
            listener.onResSelected(MarkerTypeResource.EBENE, ebeneActivated)
        }
        ifButton.setOnClickListener {
            ifActivated = ifActivated.not()
            setImageButton(ifActivated, ifButton)
            listener.onResSelected(MarkerTypeResource.IF, ifActivated)
        }
        cheneButton.setOnClickListener {
            cheneActivated = cheneActivated.not()
            setImageButton(cheneActivated, cheneButton)
            listener.onResSelected(MarkerTypeResource.CHENE, cheneActivated)
        }
        bauxiteButton.setOnClickListener {
            charmeActivated = charmeActivated.not()
            setImageButton(charmeActivated, bauxiteButton)
            listener.onResSelected(MarkerTypeResource.CHARME, charmeActivated)
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