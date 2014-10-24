package com.example.myesempio2;

import java.util.ArrayList;
import java.util.HashMap;

import android.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//array di string
				Sezione[] sezioni = {
						new Sezione("Affitti",R.drawable.ic_home),
						new Sezione("Locali",R.drawable.ic_beer),
						new Sezione("Librerie",R.drawable.ic_book),
						new Sezione("Cibo",R.drawable.ic_hamburger),
						/*new Sezione("auto",R.drawable.ic_launcher),
						new Sezione("mobile",R.drawable.ic_launcher),
						new Sezione("seconda",R.drawable.ic_launcher),
						new Sezione("provola",R.drawable.ic_launcher),
						new Sezione("cosa",R.drawable.ic_launcher),
						new Sezione("pc",R.drawable.ic_launcher),*/
						
				};
				//array List
				ArrayList<Sezione> list = new ArrayList<Sezione>();
				for(int i = 0; i<sezioni.length ; ++i){
					list.add(sezioni[i]);
				}
				
				 ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
				 
				 for(int i=0;i<list.size();i++){
		             Sezione p=list.get(i);// per ogni sezione 
		             
		             HashMap<String,Object> sezionMap=new HashMap<String, Object>();//creiamo una mappa di valori
		             
		             sezionMap.put("image", p.getPhotoRes()); // per la chiave image, inseriamo la risorsa dell immagine
		             sezionMap.put("sezione", p.getSezione());// per la chiave sezione, l'informazione
		             data.add(sezionMap);  //aggiungiamo la mappa di valori alla sorgente dati
				 }
				
				
				 String[] from = {"image","sezione"}; //dai valori contenuti in queste chiavi
			     int[] to={R.id.sezioneImage,R.id.sezione};//agli id delle view

				//recupero la lista dal layout
				final ListView myList = (ListView) findViewById(R.id.listView1);
				
				//creo e istruisco l'adattatore
				SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.sezione_item,from,to);
				
				//inietto i dati
				myList.setAdapter(adapter);
				
				//item clic
				myList.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

						int itemPosition = position;
						//ArrayList<HashMap<String, Object>> itemValue = (ArrayList<HashMap<String, Object>>) myList.getItemAtPosition(position);
						Toast.makeText(getApplicationContext(), "Position: "+itemPosition+" ListItem: "+myList.getItemAtPosition(position), Toast.LENGTH_LONG).show();
					}
				});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
