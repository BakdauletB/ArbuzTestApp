package com.baha.arbuztestapp.ui.basket

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baha.arbuztestapp.databinding.ListItemBasketBinding
import com.baha.arbuztestapp.databinding.ListItemDescriptionBinding
import com.baha.arbuztestapp.model.Watermelon
import com.baha.arbuztestapp.ui.ui_extensions.getUIStatus

class BasketListAdapter:
        RecyclerView.Adapter<BasketListAdapter.DescriptionVH>(){

    private val watermelonList = arrayListOf<Watermelon>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionVH {
        return DescriptionVH(ListItemBasketBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DescriptionVH, position: Int) {
        holder.bind(watermelonList[position])
    }

    override fun getItemCount(): Int {
        return watermelonList.size
    }

    fun updateList(newWatermelon: List<Watermelon>){
        watermelonList.clear()
        watermelonList.addAll(newWatermelon)
        notifyDataSetChanged()
    }

    inner class DescriptionVH(private val binding: ListItemBasketBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(watermelon: Watermelon){
                binding.tvWeight.text  = "${watermelon.weight} кг"
                binding.tvAmount.text = watermelon.amount.toString()
                binding.tvStatus.text = watermelon.getUIStatus(binding.root.context)
            }
        }

}
