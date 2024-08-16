package com.angad.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//---------------------------------
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.angad.navigation.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game_over, container, false)

//        **************************************************************

        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false)

//        This logic move to the gameFragment on clicking the tryAgain button
        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragment2ToGameFragment())
        }
        return binding.root

    }

}