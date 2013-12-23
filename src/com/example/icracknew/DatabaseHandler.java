package com.example.icracknew;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "iCrackManager";

	// Questions table name
	private static final String TABLE_QUESTIONS = "questions";

	// Questions Table Columns names
	private static final String COL_QID = "qid";
	private static final String COL_CATEGORY = "main_category";
	private static final String COL_QUESTION= "question";

	// Answers table name
	private static final String TABLE_ANSWERS = "answers";

	// Answers Table Columns names
	private static final String COL_QIDC = "qId";
	private static final String COL_ANSWER= "answers";
	private static final String COL_UID= "uId";
	private static final String COL_RATING= "rating";

	// Users table name
	private static final String TABLE_USERS= "users";

	// Users Table Columns names
	private static final String COL_UIDQ = "uId";
	private static final String COL_USERNAME = "username";
	private static final String COL_POINTS= "points";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS+ "("
				+ COL_QID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_CATEGORY + " TEXT,"
				+ COL_QUESTION + " TEXT" +")";
		db.execSQL(CREATE_QUESTIONS_TABLE);

		String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS+ "("
				+ COL_UIDQ + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_USERNAME + " TEXT,"
				+ COL_POINTS + " INTEGER" +")";
		db.execSQL(CREATE_USERS_TABLE);

		String CREATE_ANSWERS_TABLE = "CREATE TABLE " + TABLE_ANSWERS+ "("
				+COL_QIDC+" INTEGER ,"
				+ COL_ANSWER + " TEXT,"
				+COL_UID+" INTEGER ,"
				+COL_RATING + " INTEGER ,"
				+ "FOREIGN KEY("+COL_QIDC+") REFERENCES "+TABLE_QUESTIONS+"("+COL_QID+"),"
				+ "FOREIGN KEY("+COL_UID+") REFERENCES "+TABLE_USERS+"("+COL_UIDQ+")) ";

		db.execSQL(CREATE_ANSWERS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	// Adding questions to the Questions table
	public void addQuestion(Questions question){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		//values.put(COL_QID, question.getQid());
		values.put(COL_QUESTION, question.getQuestion());
		values.put(COL_CATEGORY,question.getCategory());
		db.insert(TABLE_QUESTIONS, null, values);
		db.close(); 
	}

	//Getting questions from Questions table
	public List<Questions> getQuestion(String colCategory) {
		List<Questions> questionList = new ArrayList<Questions>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONS + " WHERE "+COL_CATEGORY+"='"+colCategory+"' ";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Questions question = new Questions();
				question.setQid(Integer.parseInt(cursor.getString(0)));
				question.setCategory(cursor.getString(1));
				question.setQuestion(cursor.getString(2));
				
				// Adding question to list
				questionList.add(question);
			} while (cursor.moveToNext());
		}
		// return question list
		return questionList;
	}

	// Adding new Users from users table
	public void addUsers(Users users) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COL_USERNAME, users.getUsername()); // Users Name
		values.put(COL_POINTS, users.getPoints()); // Users points

		// Inserting Row
		db.insert(TABLE_USERS, null, values);
		db.close(); // Closing database connection
	}

	// Getting All Users from users table
	public List<Users> getAllUsers(int uidq) {
		List<Users> usersList = new ArrayList<Users>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE "+COL_UIDQ +"=" + uidq;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Users user = new Users();
				user.setuId(Integer.parseInt(cursor.getString(0)));
				user.setUsername(cursor.getString(1));
				user.setPoints(Integer.parseInt(cursor.getString(2)));
				// Adding users to list
				usersList.add(user);
			} while (cursor.moveToNext());
		}
		// return users list
		return usersList;
	}

	// Adding answer to answers table
	public void addAnswer(Answers answer)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_QIDC, answer.getqId());
		values.put(COL_UID, answer.getuId());
		values.put(COL_ANSWER, answer.getAnswer());
		values.put(COL_RATING,answer.getRating());
		db.insert(TABLE_ANSWERS, null, values);
		db.close(); 
	}

	//Getting all answers from Answers table
	public List<Answers> getAnswers(int questionId)
	{
		List<Answers> answerList = new ArrayList<Answers>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_ANSWERS + " WHERE "+COL_QIDC+"=" + questionId;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Answers answer = new Answers();
				answer.setqId(Integer.parseInt(cursor.getString(0)));
				answer.setAnswer(cursor.getString(1));
				answer.setuId(Integer.parseInt(cursor.getString(2)));
				answer.setRating(Integer.parseInt(cursor.getString(3)));
				// Adding users to list
				answerList.add(answer);
			} while (cursor.moveToNext());
		}
		// return users list
		return answerList;
	}

	// Updating single answer
	public void updateAnswer(int uid, int qid, int rating) {
		SQLiteDatabase db = this.getWritableDatabase();
		String updateQuery = "UPDATE " + TABLE_ANSWERS + " SET COL_RATING = COL_RATING +" + rating + " WHERE COL_UIDQ=" + uid +" AND COL_QID=" +qid;
		// updating row
		db.rawQuery(updateQuery,null);

	}
	// closing database
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}
}
