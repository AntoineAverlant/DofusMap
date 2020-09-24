package com.ademe.mapretro.view

import android.content.Context
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ademe.mapretro.R
import com.ademe.mapretro.utils.marker.MarkerRes
import com.ademe.mapretro.utils.marker.MarkerTypeResource
import com.ademe.mapretro.utils.marker.getBitmapRes
import com.ademe.mapretro.utils.marker.getTitle


class InfoMarkerRes(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    private var close: ImageButton
    private var title: TextView
    private var recycler: RecyclerView

    private val adapter = RecyclerAdapter(hashMapOf(), context)

    private var isVisible = false

    init {
        View.inflate(
            context,
            R.layout.info_marker_res, this
        )

        close = findViewById(R.id.close)
        title = findViewById(R.id.title)
        recycler = findViewById(R.id.recycler)

        close.setOnClickListener {
            hide()
        }
        recycler.adapter = adapter
        this.visibility = View.GONE
    }


    fun showInfo(markerRes: MarkerRes) {
        title.text = markerRes.getTitle(context)

        adapter.mapResource = markerRes.hashMapTypeQte
        adapter.notifyDataSetChanged()

        if (!isVisible) {
            isVisible = true

            val animation: Animation = TranslateAnimation(0F, 0F, -1500F, 0F)
            animation.duration = 300
            animation.fillAfter = true
            this.startAnimation(animation)
            this.visibility = View.VISIBLE
        }
    }

    fun hide() {
        if (isVisible) {
            isVisible = false


            val animation: Animation = TranslateAnimation(0F, 0F, 0F, -1500F)
            animation.duration = 200
            animation.fillAfter = true
            this.startAnimation(animation)
            this.visibility = View.GONE
        }
    }

    private class RecyclerAdapter(
        var mapResource: HashMap<MarkerTypeResource, Int>,
        val context: Context?
    ) :
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        override fun getItemCount() = mapResource.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            mapResource.entries.forEachIndexed { index, mutableEntry ->
                if (index == position) {
                    holder.img.setImageBitmap(getBitmap(mutableEntry.key))
                    holder.title.text = getTitle(mutableEntry.key, mutableEntry.value)
                }
            }
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val img: ImageView = itemView.findViewById(R.id.imageRes)
            val title: TextView = itemView.findViewById(R.id.titleRes)
        }

        private fun getBitmap(markerType: MarkerTypeResource) =
            BitmapFactory.decodeResource(context?.resources, getBitmapRes(markerType))
    }
}