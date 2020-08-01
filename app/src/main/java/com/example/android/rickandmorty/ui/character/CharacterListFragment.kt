package com.example.android.rickandmorty.ui.character

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.rickandmorty.R

class CharacterListFragment : Fragment() {

    companion object {
        fun newInstance() =
            CharacterListFragment()
    }

    private lateinit var viewModel: CharacterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = CharacterListFragmentBinding.inflate(inflater)

        return inflater.inflate(R.layout.characterList_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}