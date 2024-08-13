package com.angad.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//---------------------------------
import androidx.databinding.DataBindingUtil
import com.angad.navigation.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game_over, container, false)

//        **************************************************************

        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false)
        return binding.root

    }


}