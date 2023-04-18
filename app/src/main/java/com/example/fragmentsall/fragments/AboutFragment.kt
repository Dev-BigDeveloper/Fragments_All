package com.example.fragmentsall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsall.BuildConfig
import com.example.fragmentsall.R
import com.example.fragmentsall.contract.HasCustomTitle
import com.example.fragmentsall.contract.navigator
import com.example.fragmentsall.databinding.FragmentAboutBinding

class AboutFragment : Fragment(), HasCustomTitle {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAboutBinding.inflate(inflater, container, false).apply {

        versionNameTextView.text = BuildConfig.VERSION_NAME
        versionCodeTextView.text = BuildConfig.VERSION_CODE.toString()
        okButton.setOnClickListener { onOkPressed() }

    }.root

    override fun getTitleRes(): Int = R.string.about

    private fun onOkPressed() {
        navigator().goBack()
    }
}