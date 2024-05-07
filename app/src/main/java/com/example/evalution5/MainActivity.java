package com.example.evalution5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements PinFragment.PinFragmentListener,SignUpFragment.SignUpFragmentListener,
ExpensesFragment.ExpensesFragmentListener, AddCourseFragment.AddCourseListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new PinFragment())
                .commit();

    }

    @Override
    public void gotoExpence() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new ExpensesFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSignUp() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SignUpFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void gotoAddExpence() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddCourseFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void doneAddCourse() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelAddCourse() {
        getSupportFragmentManager().popBackStack();

    }
}