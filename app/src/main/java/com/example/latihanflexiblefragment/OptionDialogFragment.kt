package com.example.latihanflexiblefragment

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbBarcelona: RadioButton
    private lateinit var rbRealMadrid: RadioButton
    private lateinit var rbBayernMunchen: RadioButton
    private lateinit var rbLiverpool: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose_option)
        btnClose = view.findViewById(R.id.btn_close_option)
        rgOptions = view.findViewById(R.id.rg_options)
        rbBarcelona = view.findViewById(R.id.rb_barcelona)
        rbRealMadrid = view.findViewById(R.id.rb_realmadrid)
        rbBayernMunchen = view.findViewById(R.id.rb_bayernmunchen)
        rbLiverpool = view.findViewById(R.id.rb_liverpool)

        btnClose.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        btnChoose.setOnClickListener {
            val checkRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkRadioButtonId != -1) {
                var club = ""
                when (checkRadioButtonId) {
                    R.id.rb_barcelona -> club = rbBarcelona.text.toString().trim()
                    R.id.rb_realmadrid -> club = rbRealMadrid.text.toString().trim()
                    R.id.rb_bayernmunchen -> club = rbBayernMunchen.text.toString().trim()
                    R.id.rb_liverpool -> club = rbLiverpool.text.toString().trim()
                }

                Toast.makeText(activity, "You Choose : $club", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
            } else {
                Toast.makeText(activity, "Please choose one of the options", Toast.LENGTH_SHORT).show()
            }
        }
    }
}