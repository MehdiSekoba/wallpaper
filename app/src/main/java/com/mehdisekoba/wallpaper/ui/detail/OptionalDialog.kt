package com.mehdisekoba.wallpaper.ui.detail

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.utils.AndroidUtils
import com.mehdisekoba.wallpaper.utils.views.LayoutHelper

class OptionalDialog(context: Context) : AlertDialog(context) {

    private var optionCount: Int = 0

    private lateinit var firstOption: String
    private lateinit var firstOptionListener: OptionalDialogClickListener

    var secondOption: String? = null
    var secondOptionListener: OptionalDialogClickListener? = null

    var thirdOption: String? = null
    private var thirdOptionListener: OptionalDialogClickListener? = null

    private lateinit var dialogContentView: LinearLayout
    private lateinit var contentView: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initContentView()

        initDialogContentView()

        when (optionCount) {
            1 -> addOption(firstOption, firstOptionListener)
            2 -> addTwoOptions()
            else -> {
                addOption(firstOption, firstOptionListener)
                drawLine()
                addOption(secondOption, secondOptionListener)
                drawLine()
                addOption(thirdOption, thirdOptionListener)
            }
        }

        if (optionCount == 3) {
            // Locate the dialog at the bottom
            window!!.setGravity(Gravity.BOTTOM)
            addBottomSpace()
        }

        // set window background transparent
        window!!.setBackgroundDrawableResource(android.R.color.transparent)
    }

    private fun initContentView() {
        contentView = LinearLayout(context)
        contentView.orientation = LinearLayout.VERTICAL
        contentView.gravity = Gravity.CENTER
        addContentView(
            contentView,
            LayoutHelper.createLinear(
                context,
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.MATCH_PARENT,
                Gravity.CENTER,
                AndroidUtils.dp(context, 10f),
                0,
                AndroidUtils.dp(context, 10f),
                0,

            ),
        )
    }

    private fun initDialogContentView() {
        dialogContentView = LinearLayout(context)
        val shape = GradientDrawable()
        shape.cornerRadius = AndroidUtils.dp(context, 20f).toFloat()
        shape.shape = GradientDrawable.RECTANGLE
        shape.color = AppCompatResources.getColorStateList(context, R.color.white)
        dialogContentView.background = shape
        dialogContentView.orientation = LinearLayout.VERTICAL
        dialogContentView.gravity = Gravity.CENTER

        contentView.addView(
            dialogContentView,
            LayoutHelper.createLinear(
                context,
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.WRAP_CONTENT,
                Gravity.CENTER,
            ),
        )
    }

    private fun addOption(text: String?, listener: OptionalDialogClickListener?) {
        if (text.isNullOrEmpty()) {
            return
        }
        val option = TextView(context)
        option.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
        option.maxLines = 1
        option.isSingleLine = true
        option.pivotX = 0f
        option.gravity = Gravity.CENTER
        option.isClickable = true
        val outValue = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            outValue,
            true,
        )
        option.setBackgroundResource(outValue.resourceId)
        option.setTextColor(ContextCompat.getColor(context, R.color.Raisin_Black))
        option.setPadding(0, AndroidUtils.dp(context, 14f), 0, AndroidUtils.dp(context, 14f))
        option.text = text
        val linearView = LayoutHelper.createLinear(
            context,
            LayoutHelper.MATCH_PARENT,
            LayoutHelper.WRAP_CONTENT,
            Gravity.CENTER,
        )

        option.setOnClickListener { listener?.onClick(this) }
        dialogContentView.addView(
            option,
            linearView,
        )
    }

    private fun addTwoOptions() {
        val options = LinearLayout(context)
        options.orientation = LinearLayout.HORIZONTAL
        options.gravity = Gravity.CENTER

        val firstOptionTxtView = TextView(context)
        firstOptionTxtView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
        firstOptionTxtView.maxLines = 1
        firstOptionTxtView.isSingleLine = true
        firstOptionTxtView.pivotX = 0f
        firstOptionTxtView.gravity = Gravity.CENTER
        firstOptionTxtView.isClickable = true
        var outValue = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            outValue,
            true,
        )
        firstOptionTxtView.setBackgroundResource(outValue.resourceId)
        firstOptionTxtView.setTextColor(ContextCompat.getColor(context, R.color.Raisin_Black))
        firstOptionTxtView.setPadding(
            0,
            AndroidUtils.dp(context, 14f),
            0,
            AndroidUtils.dp(context, 14f),
        )
        firstOptionTxtView.text = firstOption
        firstOptionTxtView.setOnClickListener { firstOptionListener.onClick(this) }
        val linearView = LayoutHelper.createLinear(
            context,
            LayoutHelper.MATCH_PARENT,
            LayoutHelper.WRAP_CONTENT,
            1f,
            Gravity.CENTER,
        )

        options.addView(
            firstOptionTxtView,
            linearView,
        )

        drawLine(view = options, orientation = LinearLayout.VERTICAL)

        val secondOptionTxtView = TextView(context)
        secondOptionTxtView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
        secondOptionTxtView.maxLines = 1
        secondOptionTxtView.isSingleLine = true
        secondOptionTxtView.pivotX = 0f
        secondOptionTxtView.gravity = Gravity.CENTER
        secondOptionTxtView.isClickable = true
        outValue = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            outValue,
            true,
        )
        secondOptionTxtView.setBackgroundResource(outValue.resourceId)
        secondOptionTxtView.setTextColor(ContextCompat.getColor(context, R.color.Raisin_Black))
        secondOptionTxtView.setPadding(
            0,
            AndroidUtils.dp(context, 14f),
            0,
            AndroidUtils.dp(context, 14f),
        )
        secondOptionTxtView.setOnClickListener { secondOptionListener?.onClick(this) }
        secondOptionTxtView.text = secondOption
        options.addView(
            secondOptionTxtView,
            linearView,
        )

        dialogContentView.addView(
            options,
            LayoutHelper.createLinear(
                context,
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.WRAP_CONTENT,
                Gravity.CENTER,
            ),
        )
    }

    private fun drawLine(
        view: LinearLayout = dialogContentView,
        orientation: Int = LinearLayout.HORIZONTAL,
        length: Float = .3f,
        colorId: Int = android.R.color.darker_gray,
    ) {
        val line = LinearLayout(context)
        line.setBackgroundColor(ContextCompat.getColor(context, colorId))
        val width: Int
        val height: Int
        if (orientation == LinearLayout.HORIZONTAL) {
            width = LayoutHelper.MATCH_PARENT
            height = AndroidUtils.dp(context, length)
        } else {
            width = AndroidUtils.dp(context, length)
            height = LayoutHelper.MATCH_PARENT
        }
        view.addView(
            line,
            LayoutHelper.createLinear(
                context,
                width,
                height,
                Gravity.CENTER,
            ),
        )
    }

    class Builder(private val context: Context) {
        private val params = DialogParams()

        fun setFirstOption(text: String, listener: OptionalDialogClickListener): Builder {
            params.mFirstOption = text
            params.mFirstOptionListener = listener
            return this
        }

        fun setSecondOption(text: String, listener: OptionalDialogClickListener): Builder {
            params.mSecondOption = text
            params.mSecondOptionListener = listener
            return this
        }

        fun setThirdOption(text: String, listener: OptionalDialogClickListener?): Builder {
            params.mThirdOption = text
            params.mThirdOptionListener = listener!!
            return this
        }

        fun create(): OptionalDialog {
            val dialog = OptionalDialog(context)
            params.apply(dialog)
            return dialog
        }

        fun show(): OptionalDialog {
            val dialog: OptionalDialog = create()
            dialog.show()
            return dialog
        }
    }

    class DialogParams {
        var mCancelable = true

        lateinit var mFirstOption: String
        lateinit var mFirstOptionListener: OptionalDialogClickListener

        var mSecondOption: String? = null
        var mSecondOptionListener: OptionalDialogClickListener? = null

        var mThirdOption: String? = null
        var mThirdOptionListener: OptionalDialogClickListener? = null

        fun apply(dialog: OptionalDialog) {
            dialog.firstOption = mFirstOption
            dialog.firstOptionListener = mFirstOptionListener

            dialog.secondOption = mSecondOption
            dialog.secondOptionListener = mSecondOptionListener

            dialog.thirdOption = mThirdOption
            dialog.thirdOptionListener = mThirdOptionListener
            dialog.setCancelable(mCancelable)
            var optionCount = 3
            if (mFirstOption.isEmpty()) {
                optionCount -= 1
            }
            if (mSecondOption.isNullOrEmpty()) {
                optionCount -= 1
            }
            if (mThirdOption.isNullOrEmpty()) {
                optionCount -= 1
            }
            dialog.optionCount = optionCount
        }
    }
    private fun addBottomSpace() {
        val layoutParams = dialogContentView.layoutParams as LinearLayout.LayoutParams
        val bottomMargin = AndroidUtils.dp(context, 80f)
        layoutParams.bottomMargin = bottomMargin
        dialogContentView.layoutParams = layoutParams
    }

    interface OptionalDialogClickListener {
        fun onClick(dialog: OptionalDialog)
    }
}
