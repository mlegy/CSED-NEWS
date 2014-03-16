package com.melegy.csed;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.melegy.csed.R;
import com.melegy.csed.data.RssItem;
import com.melegy.csed.util.RssReader;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set view
		setContentView(R.layout.main);

		try {
			// Create RSS reader
			RssReader rssReader = new RssReader("http://csedapp.blogspot.com/feeds/posts/default?alt=rss");
			// Get a ListView from main view
			ListView itcItems = (ListView) findViewById(R.id.listMainView);
			
			// Create a list adapter
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,android.R.layout.simple_list_item_1, rssReader.getItems());
			// Set list adapter for the ListView
			itcItems.setAdapter(adapter);
				
		} catch (Exception e) {
			Log.e("CSED-NEWS", e.getMessage());
		}
		
	}
	
}