package com.example.fragmentsall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsall.contract.Options
import com.example.fragmentsall.contract.navigator
import com.example.fragmentsall.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)

        navigator().listenResult(Options::class.java, viewLifecycleOwner) {
            this.options = it
        }

        binding.openBoxButton.setOnClickListener { onOpenBoxPressed() }
        binding.optionsButton.setOnClickListener { onOptionsPressed() }
        binding.aboutButton.setOnClickListener { onAboutPressed() }
        binding.exitButton.setOnClickListener { onExitPressed() }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    private fun onOpenBoxPressed() {
        navigator().showBoxSelectionScreen(options)
    }

    private fun onOptionsPressed() {
        navigator().showOptionsScreen(options)
    }

    private fun onAboutPressed() {
        navigator().showAboutScreen()
    }

    private fun onExitPressed() {
        navigator().goBack()
    }

    companion object {
        @JvmStatic private val KEY_OPTIONS = "OPTIONS"
    }
}