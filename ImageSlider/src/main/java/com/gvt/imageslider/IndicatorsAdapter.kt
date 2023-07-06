package com.gvt.imageslider
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import kotlin.properties.Delegates

class IndicatorsAdapter(
    private val activeIndicator: Drawable,
    private val inactiveIndicator: Drawable,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<IndicatorsAdapter.ViewHolder>() {

    var list: List<CarouselItem> by updateList(emptyList()) { old, new ->
        old == new
    }

    var positionActive: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_indicator, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(positionActive, position, activeIndicator, inactiveIndicator) {
            listener.invoke(position)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewIndicator: ImageView = itemView.findViewById(R.id.imageViewIndicator)

        internal fun bind(
            positionActive: Int,
            position: Int,
            activeIndicator: Drawable,
            inactiveIndicator: Drawable,
            completion: () -> Unit
        ) {
            imageViewIndicator.setImageDrawable(if (position == positionActive) activeIndicator else inactiveIndicator)
            imageViewIndicator.setOnClickListener { completion.invoke() }
        }
    }

    inline fun <VH : RecyclerView.ViewHolder, T> RecyclerView.Adapter<VH>.updateList(
        initialValue: List<T>,
        crossinline areItemsTheSame: (T, T) -> Boolean = { old, new -> old == new },
        crossinline areContentsTheSame: (T, T) -> Boolean = { old, new -> old == new }
    ) = Delegates.observable(initialValue) { _, old, new ->
        val diffCallback = object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                areItemsTheSame(old[oldItemPosition], new[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                areContentsTheSame(old[oldItemPosition], new[newItemPosition])

            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size
        }

        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this@updateList)
    }
}