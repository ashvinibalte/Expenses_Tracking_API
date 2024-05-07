package com.example.evalution5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evalution5.databinding.FragmentPinBinding;

public class PinFragment extends Fragment {

    private FragmentPinBinding binding;
    private PinFragmentListener mListener;
    private SharedPreferences sharedPreferences;

    public PinFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPinBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUsername();
            }
        });

        binding.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSignUp();
            }
        });
    }

    private void validateUsername() {
        String inputUsername = binding.editTextTextName.getText().toString(); // Assuming the input is in editTextPin
        String storedUsername = sharedPreferences.getString("username", null);

        if (inputUsername.equals(storedUsername)) {
            mListener.gotoExpence();
        } else {
            binding.editTextTextName.setError("Invalid PIN. Try again or sign up.");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (PinFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement PinFragmentListener");
        }
    }

    public interface PinFragmentListener {
        void gotoExpence();
        void gotoSignUp();
    }
}
