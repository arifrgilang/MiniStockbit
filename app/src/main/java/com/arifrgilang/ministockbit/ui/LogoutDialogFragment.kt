package com.arifrgilang.ministockbit.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.arifrgilang.ministockbit.R
import org.jetbrains.anko.sdk27.coroutines.onClick

class LogoutDialogFragment(
        private val callback: DialogCallback
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater
                .from(requireContext())
                .inflate(R.layout.dialog_logout, null)
                .apply {
                    val btnYes = this.findViewById<Button>(R.id.btn_logout_yes)
                    val btnNo = this.findViewById<Button>(R.id.btn_logout_no)

                    btnYes.onClick {
                        callback.isAgree()
                        dismiss()
                    }

                    btnNo.onClick {
                        dismiss()
                    }
                }

        val builder = AlertDialog.Builder(requireContext()).setView(view)
        return builder.create().apply { setCanceledOnTouchOutside(false) }
    }

    interface DialogCallback {
        fun isAgree()
    }
}
