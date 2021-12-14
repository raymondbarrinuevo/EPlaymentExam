package com.example.eplaymentexam.mvvmsample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.eplaymentexam.R
import com.example.eplaymentexam.mvvmsample.viewmodel.Communicator

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView=LayoutInflater.from(container!!.context).inflate(R.layout.fragment_second,container,false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn=view.findViewById<View>(R.id.btnBack) as Button
        val txt=view.findViewById<View>(R.id.txreceiver) as TextView

        val model= ViewModelProviders.of(requireActivity()!!).get(Communicator::class.java)

        model.message.observe(this.viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                txt.text = o!!.toString()
            }
        })
        btn.setOnClickListener { view ->
            //write some code here
        }
    }

}