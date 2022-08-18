package com.joaquin.ct5studentgradesv1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class StudentDialogFragment extends DialogFragment {

    public interface OnStudentEnteredListener {
        void onStudentEntered(String studentText);
    }

    private OnStudentEnteredListener listener;

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstance) {
        final EditText studentEditText = new EditText(requireActivity());
        studentEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        studentEditText.setMaxLines(4);
        return new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.student)
                .setView(studentEditText)
                .setPositiveButton(R.string.create, (dialog, whichButton) -> {
                    String student = studentEditText.getText().toString();
                    listener.onStudentEntered(student.trim());
                }).setNegativeButton(R.string.cancel, null).create();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnStudentEnteredListener) context;
    }

    public void onDetach() {

        super.onDetach();
        listener = null;
    }
}
