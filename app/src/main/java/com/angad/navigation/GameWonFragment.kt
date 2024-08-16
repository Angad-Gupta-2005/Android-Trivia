package com.angad.navigation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.angad.navigation.databinding.FragmentGameWonBinding


@Suppress("DEPRECATION")
class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game_won, container, false)

        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false)

//      This logic move to the gameFragment on clicking the nextMatch button
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

//    Follow the steps to share a message in another apps like whatsapp
//   Step: 1-  This method prepared the intent messages which is share
    private fun getShareIntent(): Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain").putExtra(
//            Intent.EXTRA_TEXT,
//            getString(R.string.share_success_text, args.numCorrect, args.numQuestions)
//        )
//        return shareIntent

//            OR
        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_success_text,
                args.numCorrect, args.numQuestions))
            .setType("text/plain")
            .intent
    }

//  Step: 2-  This method share the intent messages which is created in above message
    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

//  Step: 3-  This method create the share option(icon) in overflow menu_bar
    @SuppressLint("QueryPermissionsNeeded")
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

//    handling the intent if sharing app is not available
        if(null==getShareIntent().resolveActivity(requireActivity().packageManager)){
            menu.findItem(R.id.share).isVisible = false
        }
    }

//  Step: 4-  This method send the message on clicking the share icon
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}