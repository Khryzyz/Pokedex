package com.chris.pokedex.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chris.pokedex.utils.viewModel.ViewModelFactory
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject

abstract class BaseViewBindingDialogFragment<VB : ViewBinding>
    (private val inflate: Inflate<VB>) : DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: VB? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}