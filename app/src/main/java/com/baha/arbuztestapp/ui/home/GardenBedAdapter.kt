package com.baha.arbuztestapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baha.arbuztestapp.databinding.ListItemGardenBedBinding
import com.baha.arbuztestapp.model.Cell

class GardenBedAdapter(private val eventListener: EventListener) :
    RecyclerView.Adapter<GardenBedAdapter.CellVH>() {

    interface EventListener {
        fun onCellClicked(cell: Cell)
    }

    private val cellList = arrayListOf<Cell>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellVH {
        return CellVH(ListItemGardenBedBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CellVH, position: Int) {
        holder.bind(cellList[position])
    }

    override fun getItemCount(): Int {
        return cellList.size
    }

    fun updateList(newCells: List<Cell>) {
        cellList.clear()
        cellList.addAll(newCells)
        notifyDataSetChanged()
    }

    inner class CellVH(private val binding: ListItemGardenBedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cell: Cell) {
            binding.tvName.text = cell.name
            binding.root.setOnClickListener {
                eventListener.onCellClicked(cell)
            }
        }
    }

}