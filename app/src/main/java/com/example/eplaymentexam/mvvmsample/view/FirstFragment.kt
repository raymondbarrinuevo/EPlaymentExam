package com.example.eplaymentexam.mvvmsample.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.eplaymentexam.R
import com.example.eplaymentexam.mvvmsample.viewmodel.Communicator

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    companion object {
        lateinit var mctx: Context
    }

    private var model: Communicator? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProviders.of(requireActivity()!!).get(Communicator::class.java)

        val btn = view.findViewById<View>(R.id.btnSend) as Button
        val edt = view.findViewById<View>(R.id.txSendToFgm) as EditText
        //listener onClick
        btn.setOnClickListener { view ->
            //set the message to share to another fragment
            model!!.setMsgCommunicator(edt.text.toString())
            //Launch the data receiver fragment
            val myfragment = SecondFragment()
            val fragmentTransaction = requireFragmentManager()!!.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, myfragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}