package com.baha.arbuztestapp.ui.basket

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.baha.arbuztestapp.databinding.FragmentBasketBinding
import com.baha.arbuztestapp.repository.WatermelonRepositoryImpl
import com.baha.arbuztestapp.ui.base.AbstractFragment
import kz.litro.presentation.spinner.PaymentBSDialog

class BasketFragment : AbstractFragment<FragmentBasketBinding, BasketVM>()  {

    companion object {
        const val TAG = "BasketFragment"
        const val WATERMELON_LIST = "Watermelon_list"
    }
    private val watermelonRepository = WatermelonRepositoryImpl()
    private lateinit var basketAdapter: BasketListAdapter

    override fun getViewBinding(): FragmentBasketBinding {
        return FragmentBasketBinding.inflate(layoutInflater)
    }
    override fun setupUI() {
        setupRV()

        binding.btnPayment.setOnClickListener {
            val dialog = PaymentBSDialog()
            dialog.show(childFragmentManager, PaymentBSDialog.TAG)
        }
    }
    private fun setupRV(){
        basketAdapter = BasketListAdapter()
        binding.rvListWatermelon.adapter = basketAdapter
    }

    override fun observeLiveData() {
        vm.listOfWatermelon.observe(viewLifecycleOwner, {
            Log.d("#####", "$it")
            basketAdapter.updateList(it)
        })
    }

    override fun getViewModel(): BasketVM {
        return ViewModelProvider(
            requireActivity(),
            BasketVM.BasketVMFactory(watermelonRepository, arguments?.getParcelableArrayList(
                WATERMELON_LIST) ?: emptyList())
        )[BasketVM::class.java]
    }

}