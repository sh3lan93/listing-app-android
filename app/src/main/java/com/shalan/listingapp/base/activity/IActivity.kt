package com.shalan.listingapp.base.activity

import android.os.Bundle

/**
 * Created by Mohamed Shalan on 4/18/20.
 */

interface IActivity {

	val layoutId: Int

	fun onCreateInit(savedInstance: Bundle?)

}
