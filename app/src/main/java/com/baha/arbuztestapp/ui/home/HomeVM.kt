package com.baha.arbuztestapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.baha.arbuztestapp.model.Cell
import com.baha.arbuztestapp.repository.WatermelonRepository
import kotlinx.coroutines.launch

class HomeVM(private val watermelonRepository: WatermelonRepository) : ViewModel() {

    private val gardenBedCellsLV = MutableLiveData<List<Cell>>()
    val gardenBedCells: LiveData<List<Cell>> = gardenBedCellsLV

    init {
        loadGardenBed()
    }

    private fun loadGardenBed() {
        viewModelScope.launch {
            val cells = watermelonRepository.getGardenBedCells()
            gardenBedCellsLV.value = cells
        }
    }

    class HomeVMFactory(private val watermelonRepository: WatermelonRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.d("#####", "HomeVMFactory")
            return HomeVM(watermelonRepository) as T
        }
    }
}