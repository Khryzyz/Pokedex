package com.chris.pokedex.layer.ui.fragment.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import com.chris.pokedex.R
import com.chris.pokedex.base.BaseFragment
import com.chris.pokedex.databinding.ListPokemonFragmentBinding
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.layer.ui.fragment.list.adapter.ListPokemonAdapter
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemonLocal
import com.chris.pokedex.utils.uiState.UIStateListPokemonRemote

class ListPokemonFragment : BaseFragment() {

    private val viewModel: ListPokemonViewModel by viewModels { viewModelFactory }

    private var _binding: ListPokemonFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: ListPokemonAdapter

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

        getListPokemon()

        setAdapter()

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

    private fun setAdapter() {
        adapter = ListPokemonAdapter()
        binding.rcwListPokemon.adapter = adapter

    }

    private fun addObservers() {
        //Observador de la variable responsePost
        viewModel.responseRemote.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateListPokemonRemote.Load -> handlerLoad()
                is UIStateListPokemonRemote.Success -> handlerSuccess(state.data)
                is UIStateListPokemonRemote.Error -> handlerError(state.message)
                is UIStateListPokemonRemote.Progress -> handlerProgress(state.progress, state.total)
            }
        })

        viewModel.responseLocal.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateListPokemonLocal.Load -> handlerLoad()
                is UIStateListPokemonLocal.Success -> handlerSuccess(state.listPokemonModel)
                is UIStateListPokemonLocal.Error -> handlerError(state.message)
                is UIStateListPokemonLocal.Progress -> handlerProgress(state.progress, state.total)
            }
        })
    }

    private fun getListPokemon() {
        viewModel.getListPokemonByGeneration(generation)
    }

    private fun handlerLoad() {
        binding.flipperPost.displayedChild =
            binding.flipperPost.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
    }

    private fun handlerProgress(progress: Int, total: Int) {
        if (binding.flipperPost.displayedChild == binding.flipperPost.indexOfChild(binding.incLoadLayout.cnlLoadLayout)) {
            val percent = progress * 100 / total
            binding.incLoadLayout.lpiLoadPokemon.apply {
                visibility = View.VISIBLE
                setProgress(percent)
            }

            binding.incLoadLayout.txvLoadPokemon.apply {
                visibility = View.VISIBLE
                text = context?.getString(R.string.text_loading, progress, total)
            }
        }
    }

    private fun handlerSuccess(listPokemonModel: List<PokemonBasicModel>) {
        adapter.submitList(listPokemonModel)
        binding.flipperPost.displayedChild =
            binding.flipperPost.indexOfChild(binding.rcwListPokemon)
    }
//
//    private fun handlerSuccess(listPokemonModel: List<PokemonModel>) {
//        adapter.submitList(listPokemonModel)
//        binding.flipperPost.displayedChild =
//            binding.flipperPost.indexOfChild(binding.rcwListPokemon)
//    }

    private fun handlerError(messageError: String) {
        binding.incErrorLayout.txvErrorMessage.text = messageError
        binding.flipperPost.displayedChild =
            binding.flipperPost.indexOfChild(binding.incErrorLayout.cnlErrorLayout)
    }
}