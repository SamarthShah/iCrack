package com.example.icracknew;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	DatabaseHandler db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Test data for adding into database
		db = new DatabaseHandler(getApplicationContext());

		String strC1 = "Python";
		String strC2 = "Java";
		String strC3 = "DBMS";
		String strC4 = "Data Structure";

		String strQ1 = "What is python?";
		String strA1 = "Ans: Python is an open source language that is getting a lot of attention from the market.1) Created by: Guido van Rossum nearly 11 years ago. 2) Python is an interpreted, high-level programming language, pure object-oriented and powerful server-side scripting language for the Web. 3) Python is a good prototype language. In just a few minutes, you can develop prototypes that would take you several hours in other languages.";

		String strQ2 = "Is python the right choice for Web based Programming?";
		String strA2 = "Ans: Python is another open source programming that has become popular for creating web-related applications and large programs. Scripts written in Python are often very clear to read; the language is also known for its flexibility. Whether you are looking for database tools, image manipulation scripts, or something else entirely, if it is written in Python, you will find it here.";

		String strQ3 = "When you need ordered container of things, which will be manipulated, use lists.";
		String strA3 = "Dictionary is key, value pair container and hence is not ordered. Use it when you need fast access to elements, not in ordered fashion. Lists are indexed and index of the list cannot be “string” e.g. list [‘myelement’] is not a valid statement in python.";

		String strQ4 = "When do you use list vs. tuple vs. dictionary vs. set?";
		String strA4 = "List and Tuple are both ordered containers. If you want an ordered container of  constant elements use tuple as tuples are immutable objects.";

		String strQ5 = "Why cannot lambda forms in Python contain statements?";
		String strA5 = "A lambda statement is used to create new function objects and then return them at runtime that is why lambda forms in Python did not contain statement.";

		String strQ6 = "What is serialization?";
		String strA6 = "Serialization is a mechanism by which you can save the state of an object by converting it to a byte stream.";

		String strQ7 = "What is the common usage of serialization?";
		String strA7 = "Whenever an object is to be sent over the network, objects need to be serialized. Moreover if the state of an object is to be saved, objects need to be serilazed.";

		String strQ8 = "What are checked exceptions?";
		String strA8 = "Checked exceptions are those which the Java compiler forces you to catch.";

		String strQ9 = "How to create custom exceptions?";
		String strA9 = "Your class should extend class Exception, or some more specific type thereof.";

		String strQ10 = "How does Java handle integer overflows and underflows?";
		String strA10 = "It uses those low order bytes of the result that can fit into the size of the type allowed by the operation.";
		String strrQ1 = "What is a Database system?";
		String strrA1 = "The database and DBMS software together is called as Database system.";

		String strrQ2 = "What is Data Model?";
		String strrA2 = "A collection of conceptual tools for describing data, data relationships data semantics and constraints.";

		String strrQ3 = "What is an Entity?";
		String strrA3 = " It is a 'thing' in the real world with an independent existence.";

		String strrQ4 = "What is an Entity type?";
		String strrA4 = "It is a collection (set) of entities that have same attributes.";

		String strrQ5 = "What is an Entity set?";
		String strrA5 = "It is a collection of all entities of particular entity type in the database.";
		
		Questions q1= new Questions();
		q1.setCategory(strC1);
		q1.setQuestion(strQ1);
		db.addQuestion(q1);

		Questions q2= new Questions();
		q2.setCategory(strC1);
		q2.setQuestion(strQ2);
		db.addQuestion(q2);

		Questions q3= new Questions();
		q3.setCategory(strC1);
		q3.setQuestion(strQ3);
		db.addQuestion(q3);

		Questions q4= new Questions();
		q4.setCategory(strC1);
		q4.setQuestion(strQ4);
		db.addQuestion(q4);

		Questions q5= new Questions();
		q5.setCategory(strC1);
		q5.setQuestion(strQ5);
		db.addQuestion(q5);

		Answers answer1=new Answers();
		answer1.setqId(0);
		answer1.setRating(4);
		answer1.setAnswer(strA1);
		answer1.setuId(0);
		db.addAnswer(answer1);

		Answers answer2=new Answers();
		answer2.setqId(1);
		answer2.setRating(4);
		answer2.setAnswer(strA2);
		answer2.setuId(0);
		db.addAnswer(answer2);

		Answers answer3=new Answers();
		answer3.setqId(2);
		answer3.setRating(4);
		answer3.setAnswer(strA3);
		answer3.setuId(1);
		db.addAnswer(answer3);

		Answers answer4=new Answers();
		answer4.setqId(3);
		answer4.setRating(4);
		answer4.setAnswer(strA4);
		answer4.setuId(2);
		db.addAnswer(answer4);

		Answers answer5=new Answers();
		answer5.setqId(4);
		answer5.setRating(4);
		answer5.setAnswer(strA5);
		answer5.setuId(3);
		db.addAnswer(answer5);


		Questions q6= new Questions();
		q6.setCategory(strC2);
		q6.setQuestion(strQ6);
		db.addQuestion(q6);

		Questions q7= new Questions();
		q7.setCategory(strC2);
		q7.setQuestion(strQ7);
		db.addQuestion(q7);

		Questions q8= new Questions();
		q8.setCategory(strC2);
		q8.setQuestion(strQ8);
		db.addQuestion(q8);

		Questions q9= new Questions();
		q9.setCategory(strC2);
		q9.setQuestion(strQ9);
		db.addQuestion(q9);

		Questions q10= new Questions();
		q10.setCategory(strC2);
		q10.setQuestion(strQ10);
		db.addQuestion(q10);

		Answers answer6=new Answers();
		answer6.setqId(6);
		answer6.setRating(4);
		answer6.setAnswer(strA6);
		answer6.setuId(0);
		db.addAnswer(answer6);

		Answers answer7=new Answers();
		answer7.setqId(7);
		answer7.setRating(4);
		answer7.setAnswer(strA7);
		answer7.setuId(0);
		db.addAnswer(answer7);

		Answers answer8=new Answers();
		answer8.setqId(8);
		answer8.setRating(4);
		answer8.setAnswer(strA8);
		answer8.setuId(1);
		db.addAnswer(answer8);

		Answers answer9=new Answers();
		answer9.setqId(9);
		answer9.setRating(4);
		answer9.setAnswer(strA9);
		answer9.setuId(2);
		db.addAnswer(answer9);

		Answers answer10=new Answers();
		answer10.setqId(10);
		answer10.setRating(4);
		answer10.setAnswer(strA10);
		answer10.setuId(3);
		db.addAnswer(answer10);




		Questions rq1= new Questions();
		rq1.setCategory(strC3);
		rq1.setQuestion(strrQ1);
		db.addQuestion(rq1);

		Questions q12= new Questions();
		q12.setCategory(strC3);
		q12.setQuestion(strrQ2);
		db.addQuestion(q12);

		Questions q13= new Questions();
		q13.setCategory(strC3);
		q13.setQuestion(strrQ3);
		db.addQuestion(q13);

		Questions q14= new Questions();
		q14.setCategory(strC3);
		q14.setQuestion(strrQ4);
		db.addQuestion(q14);

		Questions q15= new Questions();
		q15.setCategory(strC3);
		q15.setQuestion(strrQ5);
		db.addQuestion(q15);

		Answers Ranswer1=new Answers();
		Ranswer1.setqId(11);
		Ranswer1.setRating(4);
		Ranswer1.setAnswer(strrA1);
		Ranswer1.setuId(0);
		db.addAnswer(Ranswer1);

		Answers Ranswer2=new Answers();
		Ranswer2.setqId(12);
		Ranswer2.setRating(4);
		Ranswer2.setAnswer(strrA2);
		Ranswer2.setuId(0);
		db.addAnswer(Ranswer2);

		Answers Ranswer8=new Answers();
		Ranswer8.setqId(13);
		Ranswer8.setRating(4);
		Ranswer8.setAnswer(strrA3);
		Ranswer8.setuId(1);
		db.addAnswer(Ranswer8);

		Answers Ranswer4=new Answers();
		Ranswer4.setqId(14);
		Ranswer4.setRating(4);
		Ranswer4.setAnswer(strrA4);
		Ranswer4.setuId(2);
		db.addAnswer(Ranswer4);

		Answers Ranswer10=new Answers();
		Ranswer10.setqId(15);
		Ranswer10.setRating(4);
		Ranswer10.setAnswer(strrA5);
		Ranswer10.setuId(3);
		db.addAnswer(Ranswer10);
		
		// End of test data code

		//For populating ListView with our data
		ListView listView1 = (ListView) findViewById(R.id.category);

		final Product[] items = { 
				new Product(1, "Python"), 
				new Product(2, "Java"), 
				new Product(3, "DBMS"), 
				new Product(4, "Data Structure")				
		};

		ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
				android.R.layout.simple_list_item_1, items);

		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{ 
			@Override 
			public void onItemClick(@SuppressWarnings("rawtypes") AdapterView arg0, View arg1,int questionId, long arg3) 
			{ 

				Intent intent = new Intent(MainActivity.this,QuestionList.class);
				intent.putExtra("CategoryId",items[questionId].getName());
				startActivity(intent);
				/*
            	 // Code to show dialog box
            	 AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                 // Setting Dialog Title
                 alertDialog.setTitle("Alert Dialog");

                 // Setting Dialog Message
                 alertDialog.setMessage("Welcome to Android Application");

                 // Setting Icon to Dialog
                 //alertDialog.setIcon(R.drawable.tick);

                 // Setting OK Button
                 alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                             public void onClick(DialogInterface dialog,int which) 
                             {
                                 // Write your code here to execute after dialog closed
                             Toast.makeText(getApplicationContext(),"You clicked on OK", Toast.LENGTH_SHORT).show();
                             }
                         });

                 // Showing Alert Message
                 alertDialog.show();
				 */
			} 
		});

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
				// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(
						actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1,
						new String[] {
							getString(R.string.title_section1),
							getString(R.string.title_section2),
							getString(R.string.title_section3),
						}),
						this);
	}


	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
				getActionBar().getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.container, fragment)
		.commit();
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
			TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
	}


}
