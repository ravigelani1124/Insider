package com.gelu.insider.view.textView

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextView_bold : AppCompatTextView {

    /**
     * Created by Ravi Gelani on 28/1/2020.
     */

    constructor(context : Context): super(context){
        this.typeface= Typeface.createFromAsset(context.assets,"fonts/poppins_bold.ttf")
    }
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        this.typeface= Typeface.createFromAsset(context.assets,"fonts/poppins_bold.ttf")

    }

    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(tf)
    }
}