package com.baha.arbuztestapp.ui.basket

import androidx.lifecycle.*
import com.baha.arbuztestapp.model.Watermelon
import com.baha.arbuztestapp.repository.WatermelonRepository

class BasketVM(
    private val watermelonRepository: WatermelonRepository,
    private val watermelonList: List<Watermelon>
    ) : ViewModel() {

    private val listOfWatermelonLV: MutableLiveData<List<Watermelon>> = MutableLiveData()
    val listOfWatermelon: LiveData<List<Watermelon>> = listOfWatermelonLV

    init {
        listOfWatermelonLV.value = watermelonList
    }


    class BasketVMFactory(
        private val watermelonRepository: WatermelonRepository,
        private val watermelonList: List<Watermelon>,
        ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BasketVM(watermelonRepository, watermelonList) as T
        }
    }
}