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
import kotlinx.android.synthetic.main.fragment_cereal.*

class FragmentSelectionCereal(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

    private var rizActivated = true
    private var orgeActivated = true
    private var maltActivated = true
    private var linActivated = true
    private var chanvreActivated = true
    private var houblonActivated = true
    private var avoineActivated = true
    private var bleActivated = true
    private var seigleActivated = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cereal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(rizActivated, rizButton)
        setImageButton(orgeActivated, orgeButton)
        setImageButton(maltActivated, maltButton)
        setImageButton(linActivated, linButton)
        setImageButton(chanvreActivated, chanvreButton)
        setImageButton(houblonActivated, houblonButton)
        setImageButton(avoineActivated, avoineButton)
        setImageButton(bleActivated, bleButton)
        setImageButton(seigleActivated, seigleButton)

        rizButton.setOnClickListener {
            rizActivated = select(rizActivated, rizButton, MarkerTypeResource.RIZ)
            checkAllSelected()
        }
        orgeButton.setOnClickListener {
            orgeActivated = select(orgeActivated, orgeButton, MarkerTypeResource.ORGE)
            checkAllSelected()
        }
        maltButton.setOnClickListener {
            maltActivated = select(maltActivated, maltButton, MarkerTypeResource.MALT)
            checkAllSelected()
        }
        linButton.setOnClickListener {
            linActivated = select(linActivated, linButton, MarkerTypeResource.LIN)
            checkAllSelected()
        }
        chanvreButton.setOnClickListener {
            chanvreActivated = select(chanvreActivated, chanvreButton, MarkerTypeResource.CHANVRE)
            checkAllSelected()
        }
        houblonButton.setOnClickListener {
            houblonActivated = select(houblonActivated, houblonButton, MarkerTypeResource.HOUBLON)
            checkAllSelected()
        }
        avoineButton.setOnClickListener {
            avoineActivated = select(avoineActivated, avoineButton, MarkerTypeResource.AVOINE)
            checkAllSelected()
        }
        bleButton.setOnClickListener {
            bleActivated = select(bleActivated, bleButton, MarkerTypeResource.BLE)
            checkAllSelected()
        }
        seigleButton.setOnClickListener {
            seigleActivated = select(seigleActivated, seigleButton, MarkerTypeResource.SEIGLE)
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
        listener.onResSelected(MarkerTypeRes.CEREAL, type, activate)
        return activate
    }

    private fun checkAllSelected() {
        isAllSelected =
            (rizActivated && orgeActivated && maltActivated && linActivated && chanvreActivated
                    && houblonActivated && avoineActivated && bleActivated && seigleActivated)
    }

    private fun setSelectAll(boolean: Boolean) {
        if (rizActivated == boolean)
            rizActivated = select(boolean, rizButton, MarkerTypeResource.RIZ)

        if (orgeActivated == boolean)
            orgeActivated = select(boolean, orgeButton, MarkerTypeResource.ORGE)

        if (maltActivated == boolean)
            maltActivated = select(boolean, maltButton, MarkerTypeResource.MALT)

        if (linActivated == boolean)
            linActivated = select(boolean, linButton, MarkerTypeResource.LIN)

        if (chanvreActivated == boolean)
            chanvreActivated = select(boolean, chanvreButton, MarkerTypeResource.CHANVRE)

        if (houblonActivated == boolean)
            houblonActivated = select(boolean, houblonButton, MarkerTypeResource.HOUBLON)

        if (avoineActivated == boolean)
            avoineActivated = select(boolean, avoineButton, MarkerTypeResource.AVOINE)

        if (bleActivated == boolean)
            bleActivated = select(boolean, bleButton, MarkerTypeResource.BLE)

        if (seigleActivated == boolean)
            seigleActivated = select(boolean, seigleButton, MarkerTypeResource.SEIGLE)

        checkAllSelected()
    }
}