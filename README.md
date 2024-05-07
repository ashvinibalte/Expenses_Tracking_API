<h1><b1>Expenses Tracking API</b1></h1>
<h2><b1> Project Description /b1></h1>

<h2><b1>SignUp Fragment</b1></h2>

1. SharedPreferences Initialization: Initialized in onCreate method because we need the context, which is available after the fragment is attached to its activity.
2. Save User Details: Added a method saveUserDetails that retrieves the username from an input field (assumed as editTextUsername in your layout), saves it to SharedPreferences, and then calls apply() to save the data asynchronously.
3. Button Click Listener: Modified to call saveUserDetails when the submit button is clicked.

<h2><b1>Login Fragment</b1></h2>

1. SharedPreferences Initialization: Initialized in the onCreate method to ensure it's ready to be used once the fragment is alive.
2. Validation Method: Added validateUsername method that retrieves the pin code entered by the user, compares it with the username stored in SharedPreferences, and transitions to the ExpenseFragment if they match.
3. Error Handling: If the pin doesn't match, it sets an error on the EditText and remains on the current screen. Alternatively, the user can go to the sign-up screen via another button.

<h2><b1> Project Description </b1></h2>

<h2><b1>Overview:</b1></h2>

The Expense Tracker Application is a sophisticated mobile application designed to help users manage and monitor their expenses effectively. This application provides a user-friendly interface that allows users to categorize, add, delete, and view expenses in an organized manner. It serves as an invaluable tool for personal finance management, enabling users to keep track of their spending patterns and adhere to their budgets.

<h2><b1>Key Features:</b1></h2>

1. Expense Categorization: Users can categorize each expense under predefined categories such as Housing, Transportation, Food, Health, and Others, making it easier to track and analyze spending habits.
2. Dynamic Expense Listing: The application includes a responsive listing feature where expenses are displayed and updated in real-time as users add, modify, or delete entries.
3. Total Expense Calculation: The app calculates the total expenses automatically and displays this information prominently, offering users a quick overview of their spending.
4. Detailed Views: Each expense can be viewed in detail, allowing users to not only see the amount spent but also the category and other related details.
5. Interactive User Interface: The application is built using a modern and interactive interface, ensuring a smooth user experience. It includes functionalities like buttons for adding new expenses and deleting existing ones directly from the list.
   
<h2><b1> Technology Stack:</b1></h2>

1. Android Studio: The primary IDE for developing the Android application, utilizing Java as the main programming language.
2. Room Database: An abstraction layer over SQLite, used for robust database access while harnessing the full power of SQLite.
3. Android's RecyclerView: Utilized for efficiently displaying dynamic data collections via lists or grids.
4. Data Binding: Implemented to minimize the boilerplate code and to allow for more precise and flexible data handling and presentation.
   
<h2><b1>APIs and Libraries:</b1></h2>

1. Room Persistence Library: Used to define the app's SQLite database using annotations for tables and queries, facilitating easier database management.
2. Android Support Libraries: Utilized for backward compatibility and modern Android UI components such as RecyclerView for displaying lists of data.
3. Project Goals:
The main objective of this project is to provide a convenient and efficient way for individuals to manage their daily expenses. By leveraging the power of modern Android development tools and the Room Persistence Library, the app aims to offer robust performance, reliable data storage, and a seamless user experience
   
![1234](https://github.com/ashvinibalte/Expenses_Tracking_API/assets/125997432/9cf561b4-a56d-4fcb-8a81-2022a00b9e1d)
