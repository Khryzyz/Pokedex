package com.chris.pokedex.layer.ui.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chris.pokedex.databinding.ListPokemonFragmentBinding
import com.chris.pokedex.utils.Constants

class ListPokemonFragment : Fragment() {

    private var _binding: ListPokemonFragmentBinding? = null

    private val binding get() = _binding!!

    private var generation: Constants.Generation = Constants.Generation.FIRST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            generation = it.getSerializable(Constants.BundleKeys.GENERATION) as Constants.Generation
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ListPokemonFragmentBinding.inflate(inflater, container, false)

        binding.texto.text = generation.id.toString()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}