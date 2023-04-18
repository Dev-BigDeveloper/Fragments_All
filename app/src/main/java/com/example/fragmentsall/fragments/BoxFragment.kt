package com.example.fragmentsall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsall.R
import com.example.fragmentsall.contract.HasCustomTitle
import com.example.fragmentsall.contract.navigator
import com.example.fragmentsall.databinding.FragmentBoxBinding

class BoxFragment : Fragment(), HasCustomTitle {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBoxBinding.inflate(inflater,container,false).apply {
        toMainMenuButton.setOnClickListener { onToMainMenuPressed() }
    }.root

    private fun onToMainMenuPressed() {
        navigator().goToMenu()
    }

    override fun getTitleRes(): Int = R.string.box

}