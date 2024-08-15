package com.angad.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.angad.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game_won, container, false)

        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false)

//      This logic move to the gameFragment on clicking the nextMatch button
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "numCorrect: ${args.numCorrect}, numQuestion: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        return binding.root


    }
}