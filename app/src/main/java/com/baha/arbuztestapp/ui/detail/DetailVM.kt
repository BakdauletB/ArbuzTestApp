package com.baha.arbuztestapp.ui.detail

import androidx.lifecycle.*
import com.baha.arbuztestapp.model.Watermelon
import com.baha.arbuztestapp.repository.WatermelonRepository
import kotlinx.coroutines.launch

class DetailVM(
    private val watermelonRepository: WatermelonRepository,
    private val watermelonList: List<Watermelon>
) : ViewModel() {

    private val listOfWatermelonLV: MutableLiveData<List<Watermelon>> = MutableLiveData()
    val listOfWatermelon: LiveData<List<Watermelon>> = listOfWatermelonLV

    private val _updateItem: MutableLiveData<Watermelon> = MutableLiveData()
    val updateItem: LiveData<Watermelon> = _updateItem

    private var totalAmount = 0
    var basketList = arrayListOf<Watermelon>()

    init {
        listOfWatermelonLV.value = watermelonList
    }

    fun amountInCrease(watermelon: Watermelon) {
        watermelon.amount += 1
        totalAmount += 1
        _updateItem.value = watermelon
        if (basketList.contains(watermelon)) {
            basketList.remove(watermelon)
        }
        basketList.add(watermelon)
    }

    fun amountDeCrease(watermelon: Watermelon) {
        watermelon.amount -= 1
        totalAmount -= 1
        _updateItem.value = watermelon

        if (basketList.contains(watermelon)) {
            basketList.remove(watermelon)
        }
        if (watermelon.amount > 0) {
            basketList.add(watermelon)
        }

    }


    class DetailVMFactory(
        private val watermelonRepository: WatermelonRepository,
        private val watermelonList: List<Watermelon>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DetailVM(watermelonRepository, watermelonList) as T
        }
    }
}