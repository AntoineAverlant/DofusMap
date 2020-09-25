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
import kotlinx.android.synthetic.main.fragment_cereal.*

class FragmentSelectionCereal(private var listener: SelectionListener): Fragment() {
    private var rizActivated = true
    private var orgeActivated = true
    private var maltActivated = true
    private var linActivated = true
    private var chanvreActivated = true
    private var houblonActivated = true
    private var avoineActivated = true
    private var bleActivated = true
    private var seigleActivated = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cereal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        rizButton.setOnClickListener {
            rizActivated = rizActivated.not()
            setImageButton(rizActivated, rizButton)
            listener.onResSelected(MarkerTypeResource.RIZ, rizActivated)
        }
        orgeButton.setOnClickListener {
            orgeActivated = orgeActivated.not()
            setImageButton(orgeActivated, orgeButton)
            listener.onResSelected(MarkerTypeResource.ORGE, orgeActivated)
        }
        maltButton.setOnClickListener {
            maltActivated = maltActivated.not()
            setImageButton(maltActivated, maltButton)
            listener.onResSelected(MarkerTypeResource.MALT, maltActivated)
        }
        linButton.setOnClickListener {
            linActivated = linActivated.not()
            setImageButton(linActivated, linButton)
            listener.onResSelected(MarkerTypeResource.LIN, linActivated)
        }
        chanvreButton.setOnClickListener {
            chanvreActivated = chanvreActivated.not()
            setImageButton(chanvreActivated, chanvreButton)
            listener.onResSelected(MarkerTypeResource.CHANVRE, chanvreActivated)
        }
        houblonButton.setOnClickListener {
            houblonActivated = houblonActivated.not()
            setImageButton(houblonActivated, houblonButton)
            listener.onResSelected(MarkerTypeResource.HOUBLON, houblonActivated)
        }
        avoineButton.setOnClickListener {
            avoineActivated = avoineActivated.not()
            setImageButton(avoineActivated, avoineButton)
            listener.onResSelected(MarkerTypeResource.AVOINE, avoineActivated)
        }
        bleButton.setOnClickListener {
            bleActivated = bleActivated.not()
            setImageButton(bleActivated, bleButton)
            listener.onResSelected(MarkerTypeResource.BLE, bleActivated)
        }
        seigleButton.setOnClickListener {
            seigleActivated = seigleActivated.not()
            setImageButton(seigleActivated, seigleButton)
            listener.onResSelected(MarkerTypeResource.SEIGLE, seigleActivated)
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