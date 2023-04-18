package com.example.fragmentsall.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsall.MainActivity
import com.example.fragmentsall.R
import com.example.fragmentsall.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater,container,false)

        binding.counterTextView.text = getString(R.string.screen_label,getCounterValue())
        binding.quoteTextView.setOnClickListener { goBack() }

//        binding.launchNextButton.setOnClickListener {launchNext()}
//        binding.goBackButton.setOnClickListener { goBack() }

        return binding.root
    }

//    private fun launchNext() {
//        val fragment = CounterFragment.newInstance(
//            counterValue = (requireArguments() as MainActivity).getScreenCount() + 1,
//            quote = (requireActivity() as MainActivity).createQuote()
//        )
//    }

    private fun goBack() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    private fun getCounterValue(): Int = requireArguments().getInt(ARG_COUNTER)

    private fun getQuote() : String = requireArguments().getString(ARG_QUOTE)!!

    companion object {
        @JvmStatic
        private val ARG_COUNTER = "ARG_COUNTER_VALUE"

        @JvmStatic
        private val ARG_QUOTE = "ARG_QUOTE"
        @JvmStatic
        fun newInstance(counterValue: Int, quote:String) : CounterFragment {
            val args = Bundle().apply {
                putInt(ARG_COUNTER,counterValue)
                putString(ARG_QUOTE,quote)
            }
            val fragment = CounterFragment()
            fragment.arguments = args
            return fragment
        }
    }
}