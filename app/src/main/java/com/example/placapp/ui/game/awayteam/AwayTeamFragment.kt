package com.example.placapp.ui.game.awayteam


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.example.placapp.R
import com.example.placapp.ui.extensions.setupClearButtonWithAction
import com.example.placapp.ui.game.GameActivity
import kotlinx.android.synthetic.main.fragment_away_team.*

class AwayTeamFragment : Fragment() {

    interface AwayTeamSelectedListener  {
        fun onAwayTeam(awayName: String)
    }

    private var listener: AwayTeamSelectedListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AwayTeamSelectedListener) {
            listener = context
        }
    }

    companion object {

        fun newInstance(homeTeam: String = "", eventName: String = "") : AwayTeamFragment{
            val args = Bundle()
            args.putSerializable("homeTeam", homeTeam)
            val fragment = AwayTeamFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_away_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputAwayTeam.setupClearButtonWithAction()
        btNextStep.setOnClickListener {
            sendAwayTeamName()
        }

        //textView2.text = arguments?.getString("homeTeam")

    }

    private fun sendAwayTeamName() {
        /*val intent = Intent("FILTER_EVENT")
        intent.putExtra("away_team", inputAwayTeam.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)*/
        listener?.onAwayTeam(inputAwayTeam.text.toString())
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView2.text = (activity as GameActivity).getHomeTeam()
    }



}
