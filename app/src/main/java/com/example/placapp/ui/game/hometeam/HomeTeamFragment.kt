package com.example.placapp.ui.game.hometeam


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.example.placapp.R
import com.example.placapp.ui.extensions.setupClearButtonWithAction
import kotlinx.android.synthetic.main.fragment_home_team.*

class HomeTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputHomeTeam.setupClearButtonWithAction()
        btNextStep.setOnClickListener {
            sendHomeTeamName()
        }
    }

    private fun sendHomeTeamName() {
        val intent = Intent("FILTER_HOME_TEAM")
        intent.putExtra("home_team", inputHomeTeam.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }





}
