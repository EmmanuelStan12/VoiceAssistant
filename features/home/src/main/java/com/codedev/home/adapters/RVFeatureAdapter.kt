package com.codedev.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codedev.home.databinding.LayoutFeatureItemBinding
import com.codedev.home.models.RVFeatureModel

class RVFeatureAdapter(
    private val items: List<RVFeatureModel> = RVFeatureModel.items,
    private val onFeatureItemClick: (Int) -> Unit
): RecyclerView.Adapter<RVFeatureAdapter.RVFeatureViewHolder>() {

    inner class RVFeatureViewHolder(
        private val binding: LayoutFeatureItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RVFeatureModel) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.subtitle
            binding.ivFeature.setImageResource(item.icon)
            binding.btnLearnMore.setOnClickListener {
                onFeatureItemClick(item.id)
            }

            binding.root.setOnClickListener {
                onFeatureItemClick(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVFeatureViewHolder {
        return RVFeatureViewHolder(
            LayoutFeatureItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVFeatureViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}