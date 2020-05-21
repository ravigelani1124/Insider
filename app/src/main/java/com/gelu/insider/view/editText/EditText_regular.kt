package com.gelu.insider.view.editText

import android.content.Context
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

/**
 * Created by Ravi Gelani on 28/1/2020.
 */
class EditText_regular : AppCompatEditText {
    constructor(context: Context) : super(context) {
        this.typeface = Typeface.createFromAsset(context.assets, "fonts/poppins_regular.ttf")
        addTextChangedListener(mTextWatcher)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        //this.setBackgroundColor(Color.parseColor("#fff"));
        this.typeface = Typeface.createFromAsset(
            context.assets,
            "poppins_regular.ttf"
        )
        addTextChangedListener(mTextWatcher)
    }

    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(tf)
    }

    var mTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(
            s: CharSequence,
            start: Int,
            before: Int,
            count: Int
        ) {
        }

        override fun afterTextChanged(s: Editable) {
            if(s?.isNotEmpty()!!)error=null        }
    }
}