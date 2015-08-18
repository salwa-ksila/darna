package tn.codeit.darna;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.support.v4.app.FragmentManager;

import com.example.android.effectivenavigation.R;

import java.util.ArrayList;
import java.util.HashMap;


public class Accueil extends Fragment {

    ListView list;

    public ArrayList<HashMap<String, String>> listItem ;
    public ArrayList<HashMap<String, ImageView>> listItem2 ;

    String[] titre = {
            "Villa avec Piscine",
            "Villa style Americain",
            "Villa avec une belle jardin",
            "Maison luxe",
            "Maison dans la nature",
            "Maison confort",
            "Espace calme",
            "Maison bien équipé",
            "Studio",
            "Bureau",
            "Bureau plus salon",
            "Petite maison",
            "Maison pour petite famille",
            "Maison neuve",
            "Villa"
    } ;
    String[] prix = {
            "1500 dt",
            "1000 dt",
            "700 dt",
            "500 dt",
            "1500 dt",
            "1000 dt",
            "700 dt",
            "500 dt",
            "1500 dt",
            "1000 dt",
            "700 dt",
            "500 dt",
            "1500 dt",
            "1000 dt",
            "700 dt"
    } ;
    Integer[] imageId = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,

            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,

            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5

    };



    public Accueil() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil,container,false);





        list = (ListView)view.findViewById(R.id.list);


        AsyncCallWS task = new AsyncCallWS();
        task.execute();

       /* list.setAdapter(adapter);
        list.setClickable(true);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Log.d("click item","true");
                Toast.makeText(getActivity().getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });*/

        return view; }

    public void displaylist(){
        Log.d("display", "list");
        //Log.d("list item" , String.valueOf(listItem));

        SimpleAdapter my_adapter = new SimpleAdapter (getActivity(), listItem, R.layout.list_single,
                new String[] {"img","prix", "titre"}, new int[] {R.id.img, R.id.txt2, R.id.txt});
        list.setAdapter(my_adapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }






    public void chargeList(){
        Log.d("test","get bus station");
        //Log.d("data",String.valueOf(data));
        listItem = new ArrayList<HashMap<String, String>>();


        HashMap<String, String> map;
for(int i =0;i<imageId.length;i++){

    map = new HashMap<String, String>();
    map.put("prix", prix[i]);
    map.put("titre",titre[i]);
    map.put("img", String.valueOf(imageId[i]));
    listItem.add(map);

}


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Detail f = new Detail();
                Log.d("click listner","true");
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                tr.replace(R.id.pager, f).addToBackStack(null);
                tr.commit();

            }
        });
    }
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            // Log.i(TAG, "doInBackground");
            try {
                chargeList();

            } catch (Exception e) {
                Log.d("error", e.getMessage() + "-RESULT");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d("done", "onPostExecute");
            displaylist();
            // HIDE THE SPINNER AFTER LOADING STATIONS

        }

        @Override
        protected void onPreExecute() {
            // SHOW THE SPINNER WHILE LOADING STATIONS

            Log.d("on pre execute", "onPreExecute");

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.d("done", "onProgressUpdate");
        }

    }


}
