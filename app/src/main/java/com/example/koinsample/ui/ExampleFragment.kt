package com.example.koinsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.koinsample.R
import com.example.koinsample.R.layout
import org.koin.android.viewmodel.ext.android.viewModel

class ExampleFragment : Fragment() {

    // Same as in Activity
    private val viewModel: ExampleFragmentViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layout.fragment_example, container, false)

        val textView = view.findViewById<TextView>(R.id.title)

        viewModel.greetings.observe(this, Observer {
            textView.text = it
        })
        return view
    }
}