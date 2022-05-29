package com.baha.arbuztestapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class AbstractFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected lateinit var vm: VM

    abstract fun getViewBinding(): VB
    abstract fun getViewModel(): VM
    abstract fun setupUI()
    abstract fun observeLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        setupUI()
        observeLiveData()
        return binding.root
    }
}