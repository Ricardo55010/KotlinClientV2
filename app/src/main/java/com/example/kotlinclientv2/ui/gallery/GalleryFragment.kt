package com.example.kotlinclientv2.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlinclientv2.databinding.FragmentGalleryBinding
import com.example.kotlinclientv2.R

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null //helpful to avoid memory leaks

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!! //this is the setter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false) //inflating
        val root: View = binding.root
        //binding.textGallery.text  = "Manual modiicaction from fragment" this won't work because the livedata is overwriting it instantly
        val textView: TextView = binding.textGallery
        galleryViewModel.secondText.observe(viewLifecycleOwner){
            binding.secondaryText.text = it
        }
        galleryViewModel.text.observe(viewLifecycleOwner) { //livedata
            textView.text = it/*it is the default name for the property
            when no other is assigned*/
        } //observing the viewModel for changes in text variable
        binding.button.setOnClickListener { findNavController().navigate(R.id.nav_home) } //adding navigation to another fragment based on the id defined in mobile/navigation.xml
        return root //this is the view, its return rather than used for setContentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //deleting the fragment with the mutable var
    }
}