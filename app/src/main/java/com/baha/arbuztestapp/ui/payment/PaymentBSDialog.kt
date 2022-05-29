package kz.litro.presentation.spinner

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.baha.arbuztestapp.R
import com.baha.arbuztestapp.databinding.BsDialogPaymentBinding
import com.baha.arbuztestapp.support.extensions.enablePhoneMask
import com.baha.arbuztestapp.support.extensions.formatDate
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*


class PaymentBSDialog : BottomSheetDialogFragment() {

    private lateinit var binding: BsDialogPaymentBinding

    companion object {
        const val TAG = "PaymentBSDialog"
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BsDialogPaymentBinding.inflate(inflater)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        with(binding) {
            etDeliveryDate.setOnClickListener {
                showDatePicker()
            }
            btnPay.setOnClickListener {
                Toast.makeText(requireContext(), "Заказ успешно создан", Toast.LENGTH_SHORT).show()
                dismiss()
            }

        }
        binding.phoneEditText.enablePhoneMask()
        initDeliveryDate()
    }

    private fun initDeliveryDate() {
        val calendar = Calendar.getInstance()
        updateDeliveryDate(formatDate(calendar.time) ?: "")
    }

    private fun showDatePicker() {
        val minDate = Calendar.getInstance()
        val maxDate = Calendar.getInstance()
        maxDate.add(Calendar.DAY_OF_MONTH, 9)

        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            requireContext(),
            { datePicker, year, month, day ->
                Toast.makeText(requireContext(), "$year $month $day", Toast.LENGTH_SHORT).show()
                val cal = Calendar.getInstance()
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                updateDeliveryDate(formatDate(cal.time) ?: "")
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePicker.datePicker.minDate = minDate.timeInMillis
        datePicker.datePicker.maxDate = maxDate.timeInMillis
        datePicker.show()
    }

    private fun updateDeliveryDate(date: String) {
        binding.etDeliveryDate.setText(date)
    }

}