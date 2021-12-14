package com.example.eplaymentexam.mvvmsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Communicator : ViewModel(){

    val message = MutableLiveData<Any>()

    fun setMsgCommunicator(msg:String){
        message.value = msg
    }
}