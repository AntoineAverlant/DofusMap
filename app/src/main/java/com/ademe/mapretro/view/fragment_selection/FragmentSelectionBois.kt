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
import kotlinx.android.synthetic.main.fragment_bois.*

class FragmentSelectionBois(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bois, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(kaliptusActivated, kaliptusButton)
        setImageButton(bombuActivated, bombuButton)
        setImageButton(erableActivated, erableButton)
        setImageButton(freneActivated, freneButton)
        setImageButton(bambouSacreActivated, bambouSacreButton)
        setImageButton(bambouSombreActivated, bambouSombreButton)
        setImageButton(bambouActivated, bambouButton)
        setImageButton(olivioletActivated, olivioletButton)
        setImageButton(merisierActivated, merisierButton)
        setImageButton(noyerActivated, noyerButton)
        setImageButton(chataignerActivated, chatButton)
        setImageButton(ormeActivated, ormeButton)
        setImageButton(ebeneActivated, ebeneButton)
        setImageButton(ifActivated, ifButton)
        setImageButton(cheneActivated, cheneButton)
        setImageButton(charmeActivated, charmeButton)



        kaliptusButton.setOnClickListener {
            kaliptusActivated =
                select(kaliptusActivated, kaliptusButton, MarkerTypeResource.KALIPTUS)
            checkAllSelected()
        }
        bombuButton.setOnClickListener {
            bombuActivated = select(bombuActivated, bombuButton, MarkerTypeResource.BOMBU)
            checkAllSelected()
        }
        erableButton.setOnClickListener {
            erableActivated = select(erableActivated, erableButton, MarkerTypeResource.ERABLE)
            checkAllSelected()
        }
        freneButton.setOnClickListener {
            freneActivated = select(freneActivated, freneButton, MarkerTypeResource.FRENE)
            checkAllSelected()
        }
        bambouSacreButton.setOnClickListener {
            bambouSacreActivated =
                select(bambouSacreActivated, bambouSacreButton, MarkerTypeResource.BAMBOU_SACRE)
            checkAllSelected()
        }
        bambouSombreButton.setOnClickListener {
            bambouSombreActivated =
                select(bambouSombreActivated, bambouSombreButton, MarkerTypeResource.BAMBOU_SOMBRE)
            checkAllSelected()
        }
        bambouButton.setOnClickListener {
            bambouActivated = select(bambouActivated, bambouButton, MarkerTypeResource.BAMBOU)
            checkAllSelected()
        }
        olivioletButton.setOnClickListener {
            olivioletActivated =
                select(olivioletActivated, olivioletButton, MarkerTypeResource.OLIVIOLET)
            checkAllSelected()
        }
        merisierButton.setOnClickListener {
            merisierActivated =
                select(merisierActivated, merisierButton, MarkerTypeResource.MERISIER)
            checkAllSelected()
        }
        noyerButton.setOnClickListener {
            noyerActivated = select(noyerActivated, noyerButton, MarkerTypeResource.NOYER)
            checkAllSelected()
        }
        chatButton.setOnClickListener {
            chataignerActivated =
                select(chataignerActivated, chatButton, MarkerTypeResource.CHATAIGNIER)
            checkAllSelected()
        }
        ormeButton.setOnClickListener {
            ormeActivated = select(ormeActivated, ormeButton, MarkerTypeResource.ORME)
            checkAllSelected()
        }
        ebeneButton.setOnClickListener {
            ebeneActivated = select(ebeneActivated, ebeneButton, MarkerTypeResource.EBENE)
            checkAllSelected()
        }
        ifButton.setOnClickListener {
            ifActivated = select(ifActivated, ifButton, MarkerTypeResource.IF)
            checkAllSelected()
        }
        cheneButton.setOnClickListener {
            cheneActivated = select(cheneActivated, cheneButton, MarkerTypeResource.CHENE)
            checkAllSelected()
        }
        charmeButton.setOnClickListener {
            charmeActivated = select(charmeActivated, charmeButton, MarkerTypeResource.CHARME)
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
        listener.onResSelected(MarkerTypeRes.BOIS, type, activate)
        return activate
    }

    private fun checkAllSelected() {
        isAllSelected =
            kaliptusActivated && bombuActivated && erableActivated && freneActivated && bambouSacreActivated
                    && bambouSombreActivated && bambouActivated && olivioletActivated && merisierActivated
                    && noyerActivated && chataignerActivated && ormeActivated && ebeneActivated && ifActivated
                    && cheneActivated && charmeActivated
    }

    private fun setSelectAll(boolean: Boolean) {
        if (kaliptusActivated == boolean)
            kaliptusActivated = select(boolean, kaliptusButton, MarkerTypeResource.KALIPTUS)

        if (bombuActivated == boolean)
            bombuActivated = select(boolean, bombuButton, MarkerTypeResource.BOMBU)

        if (erableActivated == boolean)
            erableActivated = select(boolean, erableButton, MarkerTypeResource.ERABLE)

        if (freneActivated == boolean)
            freneActivated = select(boolean, freneButton, MarkerTypeResource.FRENE)

        if (bambouSacreActivated == boolean)
            bambouSacreActivated =
                select(boolean, bambouSacreButton, MarkerTypeResource.BAMBOU_SACRE)

        if (bambouSombreActivated == boolean)
            bambouSombreActivated =
                select(boolean, bambouSombreButton, MarkerTypeResource.BAMBOU_SOMBRE)

        if (bambouActivated == boolean)
            bambouActivated = select(boolean, bambouButton, MarkerTypeResource.BAMBOU)

        if (olivioletActivated == boolean)
            olivioletActivated = select(boolean, olivioletButton, MarkerTypeResource.OLIVIOLET)

        if (merisierActivated == boolean)
            merisierActivated = select(boolean, merisierButton, MarkerTypeResource.MERISIER)

        if (noyerActivated == boolean)
            noyerActivated = select(boolean, noyerButton, MarkerTypeResource.NOYER)

        if (chataignerActivated == boolean)
            chataignerActivated = select(boolean, chatButton, MarkerTypeResource.CHATAIGNIER)

        if (ormeActivated == boolean)
            ormeActivated = select(boolean, ormeButton, MarkerTypeResource.ORME)

        if (ebeneActivated == boolean)
            ebeneActivated = select(boolean, ebeneButton, MarkerTypeResource.EBENE)

        if (ifActivated == boolean)
            ifActivated = select(boolean, ifButton, MarkerTypeResource.IF)

        if (cheneActivated == boolean)
            cheneActivated = select(boolean, cheneButton, MarkerTypeResource.CHENE)

        if (charmeActivated == boolean)
            charmeActivated = select(boolean, charmeButton, MarkerTypeResource.CHARME)
        checkAllSelected()
    }
}