package com.utils


import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import com.DEFAULT_INPUT_DEBOUNCE
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

object RxUtils {

	fun subscribeRadioButton(radioButton: RadioButton): Observable<Boolean> {
		return Observable.create { emitter ->
			radioButton.setOnCheckedChangeListener { compoundButton, isChecked ->
				emitter.onNext(isChecked)
			}
		}
	}

	fun subscribeSpinner(spinnerPump: Spinner): Observable<Boolean> {
		return Observable.create { emitter ->
			spinnerPump.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
				override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int,
											id: Long) {
					emitter.onNext(position != 0)
				}

				override fun onNothingSelected(adapterView: AdapterView<*>) {

				}
			}
		}
	}

	fun subscribeEditText(editText: EditText): Observable<String> {
		val observable: Observable<String> = Observable.create { emitter ->
			editText.addTextChangedListener(object : DefaultTextWatcher() {
				override fun afterTextChanged(editable: Editable) {
					emitter.onNext(editable.toString())
				}
			})
		}
		observable.debounce(DEFAULT_INPUT_DEBOUNCE, TimeUnit.MILLISECONDS)
				.observeOn(AndroidSchedulers.mainThread())
		return observable
	}

}
