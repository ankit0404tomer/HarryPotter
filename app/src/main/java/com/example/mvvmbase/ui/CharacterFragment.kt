package com.example.mvvmbase.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.mvvmbase.R
import com.example.mvvmbase.adapter.CharacterAdapter
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.character_fragment.*
import javax.inject.Inject


class CharacterFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: CharacterAdapter
    val snapHelper: SnapHelper = PagerSnapHelper()

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(CharacterViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.character_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacterList()


        viewModel.getCharacterList.observe(viewLifecycleOwner, {
            adapter = CharacterAdapter()
                recycler_view.adapter = adapter
                recycler_view.layoutManager = LinearLayoutManager(
                    activity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                snapHelper.attachToRecyclerView(recycler_view)
                adapter.setCharacterList(it)
            
        })


    }

}


//https://hp-api.herokuapp.com/
