package com.baha.arbuztestapp.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baha.arbuztestapp.databinding.ListItemDescriptionBinding
import com.baha.arbuztestapp.model.Watermelon
import com.baha.arbuztestapp.ui.ui_extensions.getUIStatus

class DescriptionWatermelonAdapter(private val eventListener: EventListener):
        RecyclerView.Adapter<DescriptionWatermelonAdapter.DescriptionVH>(){

    interface EventListener {
        fun onWatermelonAmountIncreased(watermelon: Watermelon)
        fun onWatermelonAmountDecreased(watermelon: Watermelon)

    }
    private val watermelonList = arrayListOf<Watermelon>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionVH {
        return DescriptionVH(ListItemDescriptionBinding.inflate(LayoutInflater.from(parent.context)))
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
    fun updateItem(watermelon: Watermelon){
        val index = watermelonList.indexOfFirst {
            it.id == watermelon.id
        }
        Log.d("#####", "updateItem ${watermelon.id}, ${watermelon.weight}, $index, ${watermelon.amount}")
        watermelonList[index] = watermelon
        notifyItemChanged(index)
    }
    inner class DescriptionVH(private val binding: ListItemDescriptionBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(watermelon: Watermelon){
                binding.tvWeight.text  = "${watermelon.weight} кг"
                binding.textViewAmount.text = watermelon.amount.toString()
                binding.tvStatus.text = watermelon.getUIStatus(binding.root.context)
                binding.buttonPlus.setOnClickListener {
                    if(watermelon.amount < 3) {
                        eventListener.onWatermelonAmountIncreased(watermelon)
                    }
                }
                binding.buttonMinus.setOnClickListener {
                    if(watermelon.amount > 0) {
                        eventListener.onWatermelonAmountDecreased(watermelon)
                    }
                }

            }
        }

}
