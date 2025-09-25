package com.example.kotlinclientv2.ui.settings

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinclientv2.R
import com.example.kotlinclientv2.databinding.FragmentSettingsBinding
class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?):View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        viewModel.text.observe(viewLifecycleOwner) { value ->
            binding.textViewSettings.text = value
        }

        binding.buttonGoBack.setOnClickListener {
            findNavController().navigateUp()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}