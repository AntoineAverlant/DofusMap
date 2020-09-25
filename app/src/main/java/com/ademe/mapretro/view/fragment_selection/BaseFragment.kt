package com.ademe.mapretro.view.fragment_selection

import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.ademe.mapretro.R

abstract class BaseFragment : Fragment() {
    abstract fun selectAll()

    protected fun setImageButton(activated: Boolean, imageButton: ImageButton) {
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