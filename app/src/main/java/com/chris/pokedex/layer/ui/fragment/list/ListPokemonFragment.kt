package com.chris.pokedex.layer.ui.fragment.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import com.chris.pokedex.R
import com.chris.pokedex.base.BaseFragment
import com.chris.pokedex.databinding.ListPokemonFragmentBinding
import com.chris.pokedex.utils.Constants

class ListPokemonFragment : BaseFragment() {

    private val viewModel: ListPokemonViewModel by viewModels { viewModelFactory }

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

        setHasOptionsMenu(true)

        _binding = ListPokemonFragmentBinding.inflate(inflater, container, false)

        lifecycle.addObserver(viewModel)

        binding.texto.text = generation.id.toString()

        viewModel.getListPokemonByGeneration(generation)

        addObservers()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top_actions, menu)
    }

    private fun addObservers() {
        //Observador de la variable postsModel
        viewModel.test.observe(viewLifecycleOwner, {
            binding.texto.text = generation.id.toString() + " " + it
        })
    }

}