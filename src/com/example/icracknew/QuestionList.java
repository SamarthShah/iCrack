package com.example.icracknew;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuestionList extends Activity{

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.questions_list);
	        Bundle extras = getIntent().getExtras();
	        final String value = extras.getString("CategoryId");
	        //TextView textView = (TextView) findViewById(R.id.section_label);
	        setTitle(value);
	        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
	        ArrayList<String> questionsArray=new ArrayList<String>();
	        final List<Questions> questionList=db.getQuestion(value);
	        for (Questions questions : questionList) {
				questionsArray.add(questions.getQuestion());
			}
	        ListView questionsListView = (ListView) findViewById(R.id.questionList);
	        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1, questionsArray);
	        questionsListView.setAdapter(adapter1);
	        
	        questionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() 
	        { 
	             @Override 
	             public void onItemClick(@SuppressWarnings("rawtypes") AdapterView arg0, View arg1,int qId, long arg3) 
	             { 
	            	 
	            	 Intent intent = new Intent(QuestionList.this,SecondActivity.class);
	            	 intent.putExtra("questionId",questionList.get(qId).getQid());
	            	 intent.putExtra("question",questionList.get(qId).getQuestion());
	            	 intent.putExtra("categoryId", value);
	        		 startActivity(intent);
	             } 
	        });
	        
	        }

}
