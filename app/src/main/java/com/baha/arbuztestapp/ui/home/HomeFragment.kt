package com.baha.arbuztestapp.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.baha.arbuztestapp.R
import com.baha.arbuztestapp.repository.WatermelonRepositoryImpl
import com.baha.arbuztestapp.databinding.FragmentHomeBinding
import com.baha.arbuztestapp.model.Cell
import com.baha.arbuztestapp.ui.base.AbstractFragment
import com.baha.arbuztestapp.ui.detail.DetailFragment

class HomeFragment : AbstractFragment<FragmentHomeBinding, HomeVM>() {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    private val watermelonRepository = WatermelonRepositoryImpl()
    private lateinit var gardenBedAdapter: GardenBedAdapter

    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        setupRV()
    }

    private fun setupRV() {
        gardenBedAdapter = GardenBedAdapter(object : GardenBedAdapter.EventListener {
            override fun onCellClicked(cell: Cell) {
                Toast.makeText(requireContext(), cell.name, Toast.LENGTH_SHORT).show()
                //gardenBedAdapter.notifyItemChanged(pos)
                findNavController().navigate(R.id.action_navigation_home_to_navigation_detail,
                    Bundle().apply {
                        putParcelableArrayList(DetailFragment.WATERMELON_LIST, cell.watermelons)
                    }
                )

            }
        })
        binding.rvGardenBed.adapter = gardenBedAdapter
    }

    override fun observeLiveData() {
        vm.gardenBedCells.observe(viewLifecycleOwner, {
            Log.d("#####", "observe gardenBedCells: $it")
            gardenBedAdapter.updateList(it)
        })
    }

    override fun getViewModel(): HomeVM {
        return ViewModelProvider(
            requireActivity(),
            HomeVM.HomeVMFactory(watermelonRepository)
        )[HomeVM::class.java]
    }


}