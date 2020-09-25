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
import kotlinx.android.synthetic.main.fragment_fleurs.*

class FragmentSelectionFleurs(private var listener: SelectionListener) : BaseFragment() {

    private var isAllSelected = true

    private var pandouilleActivated = true
    private var orchActivated = true
    private var trefleActivated = true
    private var mentheActivated = true
    private var edelActivated = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fleurs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        setImageButton(pandouilleActivated, pandButton)
        setImageButton(orchActivated, orchButton)
        setImageButton(trefleActivated, trefleButton)
        setImageButton(mentheActivated, mentheButton)
        setImageButton(edelActivated, edelButton)

        pandButton.setOnClickListener {
            pandouilleActivated =
                select(pandouilleActivated, pandButton, MarkerTypeResource.PANDOUILLE)
            checkAllSelected()
        }
        orchButton.setOnClickListener {
            orchActivated = select(orchActivated, orchButton, MarkerTypeResource.ORCHIDEE)
            checkAllSelected()
        }
        trefleButton.setOnClickListener {
            trefleActivated = select(trefleActivated, trefleButton, MarkerTypeResource.TREFLE)
            checkAllSelected()
        }
        mentheButton.setOnClickListener {
            mentheActivated = select(mentheActivated, mentheButton, MarkerTypeResource.MENTHE)
            checkAllSelected()
        }
        edelButton.setOnClickListener {
            edelActivated = select(edelActivated, edelButton, MarkerTypeResource.EDELWEISS)
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
        listener.onResSelected(MarkerTypeRes.FLEURS, type, activate)
        return activate
    }

    private fun checkAllSelected() {
        isAllSelected =
            pandouilleActivated && edelActivated && mentheActivated && trefleActivated && orchActivated
    }

    private fun setSelectAll(boolean: Boolean) {
        if (pandouilleActivated == boolean)
            pandouilleActivated = select(boolean, pandButton, MarkerTypeResource.PANDOUILLE)

        if (orchActivated == boolean)
            orchActivated = select(boolean, orchButton, MarkerTypeResource.ORCHIDEE)

        if (trefleActivated == boolean)
            trefleActivated = select(boolean, trefleButton, MarkerTypeResource.TREFLE)

        if (mentheActivated == boolean)
            mentheActivated = select(boolean, mentheButton, MarkerTypeResource.MENTHE)

        if (edelActivated == boolean)
            edelActivated = select(boolean, edelButton, MarkerTypeResource.EDELWEISS)
        checkAllSelected()
    }
}