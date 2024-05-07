package com.example.evalution5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evalution5.databinding.FragmentExpensesBinding;
import com.example.evalution5.databinding.GradeRowItemBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ExpensesFragment extends Fragment {

    ExpensesAdapter adapter;
    public ExpensesFragment() {
        // Required empty public constructor
    }

    ArrayList<Grade> mGrades = new ArrayList<>();
    AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentExpensesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExpensesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ExpensesAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(adapter);
        binding.buttonsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSignUp();
            }
        });
        binding.buttonAddExpence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoAddExpence();
            }
        });
        db= Room.databaseBuilder(getActivity(),AppDatabase.class,"grades-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        loadAndDisplayData();
    }
    void loadAndDisplayData() {
        mGrades.clear();
        mGrades.addAll(db.gradeDao().getAll());
        adapter.notifyDataSetChanged();

        calculateAndDisplayTotalExpense(); // This will handle all expense calculations and UI updates
    }

    private void calculateAndDisplayTotalExpense() {
        double totalExpense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Grade grade : mGrades) {
            String category = grade.getCategory();
            double amount = grade.getCourseNumber();
            totalExpense += amount;  // Accumulate total expense
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);
        }

        // Format the total expense to display it by category
        StringBuilder totalsDisplay = new StringBuilder("Expenses by Category:\n");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            totalsDisplay.append(entry.getKey())
                    .append(": $")
                    .append(String.format("%.2f", entry.getValue()))
                    .append("\n");
        }
        totalsDisplay.append("\nTotal Expense: $").append(String.format("%.2f", totalExpense));

        // Update the TextView to show the categorized expenses and total expense
        binding.textViewGPA.setText(totalsDisplay.toString());
    }





    class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder>{
        @NonNull
        @Override
        public ExpensesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            GradeRowItemBinding rowBinding = GradeRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new ExpensesViewHolder(rowBinding);

        }

        @Override
        public void onBindViewHolder(@NonNull ExpensesViewHolder holder, int position) {
            Grade grade = mGrades.get(position);
            holder.setupUI(grade);

        }

        @Override
        public int getItemCount() {
            return mGrades.size();
        }

        class ExpensesViewHolder extends RecyclerView.ViewHolder{
            GradeRowItemBinding mBinding;
            Grade mGrade;



          public ExpensesViewHolder(GradeRowItemBinding rowBinding) {
              super(rowBinding.getRoot());
              this.mBinding = rowBinding;
          }

            public void setupUI(Grade grade) {
                this.mGrade = grade;

                mBinding.textViewCourseName.setText(mGrade.getCourseName());//expence name
                mBinding.textViewCourseNumber.setText(mGrade.getCourseNumber()+"$");//expence amount
                mBinding.textViewCourseHours.setText(mGrade.getCategory());//expence category
                mBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.gradeDao().delete(mGrade);
                        loadAndDisplayData();

                    }
                });

            }
        }
    }
    ExpensesFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener=(ExpensesFragmentListener) context;
    }

    public interface ExpensesFragmentListener {
        void gotoAddExpence();
        void gotoSignUp();

    }
}