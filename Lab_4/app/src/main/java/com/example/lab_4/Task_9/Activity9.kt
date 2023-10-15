package com.example.lab_4.Task_9

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_4.R


class MyDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.bottom_sheet_layout)
        // Настройте внешний вид и поведение вашего диалога здесь
    }
}

class Activity9 : AppCompatActivity() {

    private lateinit var bottomSheet: Button;
    private lateinit var mainContent: RelativeLayout;
    private lateinit var tvChosenAction: TextView;
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_9)

        tvChosenAction = findViewById(R.id.tvChosenAction)
        mainContent = findViewById(R.id.mainContentLayout)
        bottomSheet = findViewById(R.id.btnShowMenu)
        bottomSheet.setOnClickListener {
            showDialog()
        }

        // Инициализация GestureDetector
        gestureDetector = GestureDetector(this, MyGestureListener())

        mainContent.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }
    }

    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val deltaY = e2.y - e1.y

            // Определите условие для открытия диалогового окна при свайпе вниз
            if (deltaY < 0 && deltaY < 100) {
                showDialog()
            }

            return super.onFling(e1, e2, velocityX, velocityY)
        }
    }

    private fun showDialog() {
        val dialog: Dialog = Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_layout)

        val editLayout: LinearLayout = dialog.findViewById(R.id.layoutEdit)
        val shareLayout: LinearLayout = dialog.findViewById(R.id.layoutShare)
        val uploadLayout: LinearLayout = dialog.findViewById(R.id.layoutUpload)
        val printLayout: LinearLayout = dialog.findViewById(R.id.layoutPrint)

        editLayout.setOnClickListener {
            val textView = editLayout.getChildAt(1) as TextView
            tvChosenAction.text = textView.text;
            dialog.hide()
        }

        shareLayout.setOnClickListener {
            val textView = shareLayout.getChildAt(1) as TextView
            tvChosenAction.text = textView.text;
            dialog.hide()
        }


        uploadLayout.setOnClickListener {
            val textView = uploadLayout.getChildAt(1) as TextView
            tvChosenAction.text = textView.text;
            dialog.hide()
        }


        printLayout.setOnClickListener {
            val textView = printLayout.getChildAt(1) as TextView
            tvChosenAction.text = textView.text;
            dialog.hide()
        }

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

    }


}