package com.baha.arbuztestapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.baha.arbuztestapp.R
import com.baha.arbuztestapp.databinding.FragmentDetailBinding
import com.baha.arbuztestapp.model.Watermelon
import com.baha.arbuztestapp.repository.WatermelonRepositoryImpl
import com.baha.arbuztestapp.ui.base.AbstractFragment
import com.baha.arbuztestapp.ui.home.HomeFragment
import kz.litro.presentation.spinner.PaymentBSDialog

class DetailFragment : AbstractFragment<FragmentDetailBinding, DetailVM>()  {

    companion object {
        const val TAG = "BasketFragment"
        const val WATERMELON_LIST = "Watermelon_list"
    }
    private val watermelonRepository = WatermelonRepositoryImpl()
    private lateinit var descriptionWatermelonAdapter: DescriptionWatermelonAdapter



    override fun getViewBinding(): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }
    override fun setupUI() {
        setupRV()

        binding.btnBasket.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_detail_to_basketFragment,
                Bundle().apply {
                    putParcelableArrayList(DetailFragment.WATERMELON_LIST, vm.basketList)
                }
            )
        }
    }
    private fun setupRV(){
        descriptionWatermelonAdapter = DescriptionWatermelonAdapter(object : DescriptionWatermelonAdapter.EventListener {
            override fun onWatermelonAmountDecreased(watermelon: Watermelon) {
                vm.amountDeCrease(watermelon)
            }
            override fun onWatermelonAmountIncreased(watermelon: Watermelon) {
                vm.amountInCrease(watermelon)
            }
        })
        binding.rvListWatermelon.adapter = descriptionWatermelonAdapter
    }

    override fun observeLiveData() {
        vm.listOfWatermelon.observe(viewLifecycleOwner, {
            Log.d("#####", "observe gardenBedCells: $it")
            descriptionWatermelonAdapter.updateList(it)
        })
        vm.updateItem.observe(viewLifecycleOwner, {
            descriptionWatermelonAdapter.updateItem(it)
        })
    }

    override fun getViewModel(): DetailVM {
        return ViewModelProvider(
            requireActivity(),
            DetailVM.DetailVMFactory(watermelonRepository, arguments?.getParcelableArrayList(
                WATERMELON_LIST) ?: emptyList())
        )[DetailVM::class.java]
    }

}