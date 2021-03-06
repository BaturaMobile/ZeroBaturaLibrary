package com.baturamobile.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast

private val TAGACTIVITY = "ActivityExtentions"

@SuppressLint("WrongConstant")
fun Activity.expandNotificationPanel(){
    try{

        val service  = getSystemService("statusbar");
        val statusbarManager = Class.forName("android.app.StatusBarManager");
        val expand = statusbarManager.getMethod("expandNotificationsPanel");
        expand.invoke(service)

    }
    catch(throwable : Throwable){
        Toast.makeText(this,"ExpandNotification is not avaiable",Toast.LENGTH_LONG).show()
        Log.e(TAGACTIVITY,"error ExpandNotificationPanel",throwable)
    }
}

@SuppressLint("WrongConstant")
fun Activity.collapsePanels(){
    try{

        val service  = getSystemService("statusbar");
        val statusbarManager = Class.forName("android.app.StatusBarManager");
        val expand = statusbarManager.getMethod("collapsePanels");
        expand.invoke(service)

    }
    catch(throwable : Throwable){
        Toast.makeText(this,"ColappsePanels is not avaiable",Toast.LENGTH_LONG).show()
        Log.e(TAGACTIVITY,"error ColappsePanels",throwable)
    }
}

fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}


