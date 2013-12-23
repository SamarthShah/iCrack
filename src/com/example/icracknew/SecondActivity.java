package com.example.icracknew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SecondActivity extends Activity{
    /** Called when the activity is first created. */
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle extras = getIntent().getExtras();
        String categoryId = extras.getString("categoryId");
        String question= extras.getString("question");
        Integer questionId=extras.getInt("questionId");
        //TextView textView = (TextView) findViewById(R.id.section_label);
        setTitle(categoryId);
        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
        TextView textView=(TextView)findViewById(R.id.Question);
        //List<Questions> questionList=db.getQuestion(categoryId);
        textView.setText(question);
        ArrayList<String> answersArray=new ArrayList<String>();
        List<Answers> answerList=db.getAnswers(questionId);
        for (Answers answers : answerList) {
			answersArray.add(answers.getAnswer());
		}
        ListView listView = (ListView) findViewById(R.id.questionList);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, answersArray);
        listView.setAdapter(adapter);
        
        }
}
