package com.gelu.insider.view.editText

import android.content.Context
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EditText_semibold : AppCompatEditText {

    /**
     * Created by Ravi Gelani on 28/1/2020.
     */
    constructor(context : Context) :super(context){
        this.typeface= Typeface.createFromAsset(context.assets,"fonts/poppins_medium.ttf")
        addTextChangedListener(mTextWatcher)
    }

    constructor(context: Context,attributeSet: AttributeSet) :super(context,attributeSet){
        this.typeface= Typeface.createFromAsset(context.assets,"fonts/poppins_medium.ttf")
        addTextChangedListener(mTextWatcher)
    }


    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(tf)
    }

    var mTextWatcher : TextWatcher = object :TextWatcher{

        override fun afterTextChanged(s: Editable?) {
            if(s?.isNotEmpty()!!)error=null
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }
}