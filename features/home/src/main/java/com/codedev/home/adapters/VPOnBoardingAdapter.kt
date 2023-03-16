package com.codedev.home.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codedev.home.databinding.LayoutBoardingItemBinding
import com.codedev.home.models.VPOnBoardingModel

class VPOnBoardingAdapter(
    private val items: List<VPOnBoardingModel> = VPOnBoardingModel.items,
    private val onClickAction: (Int) -> Unit
): RecyclerView.Adapter<VPOnBoardingAdapter.VPOnBoardingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VPOnBoardingViewHolder {
        return VPOnBoardingViewHolder(
            LayoutBoardingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VPOnBoardingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VPOnBoardingViewHolder(
        private val binding: LayoutBoardingItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VPOnBoardingModel) {
            binding.apply {
                ivBoardingItem.setImageResource(item.icon)
                tvHeading.text = item.title
                tvSubHeading.text = item.subtitle
                tvDescription.text = binding.root.context.resources.getString(item.description)
            }
        }
    }
}