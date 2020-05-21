package com.gelu.insider.view.textView

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Created by Ravi Gelani on 28/1/2020.
 */

class TextView_regular :AppCompatTextView {

    constructor(context : Context) :super(context){
        this.typeface = Typeface.createFromAsset(context.assets, "fonts/poppins_regular.ttf")
    }
    constructor(context :Context,attributeSet: AttributeSet) :super(context,attributeSet){
        this.typeface = Typeface.createFromAsset(context.assets, "fonts/poppins_regular.ttf")

    }

    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(tf)
    }
}