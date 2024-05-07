package com.example.evalution5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.evalution5.databinding.FragmentAddCourseBinding;

public class AddCourseFragment extends Fragment {
    public AddCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentAddCourseBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddCourseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add Course");
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int courseNumber = (int) Double.parseDouble(binding.editTextExpenceAmount.getText().toString());
                String courseName = binding.editTextExpenceName.getText().toString();

                int selectedId = binding.radioGroupGrades.getCheckedRadioButtonId();

                if(courseName.isEmpty() || courseNumber == 0) {
                   Toast.makeText(getContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else if(selectedId == -1){
                    Toast.makeText(getContext(), "Please select Category !!", Toast.LENGTH_SHORT).show();
                } else {
                    String Category;
                    if(selectedId == R.id.radioButtonA) {
                        Category = "Housing";
                    } else if(selectedId == R.id.radioButtonB) {
                        Category = "Transportation";
                    } else if(selectedId == R.id.radioButtonC) {
                        Category = "Food";
                    } else if(selectedId == R.id.radioButtonD) {
                        Category = "Health";
                    } else {
                        Category = "Other";
                    }
                    AppDatabase db= Room.databaseBuilder(getActivity(),AppDatabase.class,"grades-db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();

                    Grade grade = new Grade(courseName,courseNumber,Category);
                    db.gradeDao().insertAll(grade);
                    mListener.doneAddCourse();


                }
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelAddCourse();
            }
        });

    }

    AddCourseListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddCourseListener) {
            mListener = (AddCourseListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement AddCourseListener");
        }
    }

    interface AddCourseListener {
        void doneAddCourse();
        void cancelAddCourse();
    }
}