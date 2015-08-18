package tn.codeit.darna;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.android.effectivenavigation.R;

import java.util.ArrayList;


public class Publier extends Fragment implements AdapterView.OnItemSelectedListener    {
    private enum Ville {Selectionnez_votre_Gouvernorat, Ariana, Beja, Ben_Arous, Bizerte, Gabes, Gafsa, Jendouba, Kairouan, Kasserine, Kebili, Kef, Mahdia, Manouba, Medenine, Monastir, Nabeul, Sfax, Sidi_Bouzid, Siliana, Sousse, Tataouine, Tozeur, Tunis, Zaghouan};
    private enum local {Type_de_bien, Maison, Studio, Appartement, Bureau, Garage, Villa};
    private enum piece {Nbre_de_pieces, un, deux, troi, quatre, cinq, plus_que_cinq};
    private LinearLayout lnrImages;
    private Button btnAddPhots;
    private ArrayList<String> imagesPathList;
    private Bitmap yourbitmap;
    private final int PICK_IMAGE_MULTIPLE =1;
    View view;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_publier,container,false);


        //prix
        EditText edit=(EditText)view.findViewById(R.id.Text6);
        Button button=(Button)view.findViewById(R.id.btnPublier);
        String str=edit.getText().toString();
        //button.setOnClickListener(this);
        //Button ajout image
        lnrImages = (LinearLayout)view.findViewById(R.id.lnrImages);
        btnAddPhots = (Button)view.findViewById(R.id.btnAddPhots);
        //btnAddPhots.setOnClickListener(this);
        //Button radio choix de vendre ou de location
        String M = "2";
        RadioGroup rb1 = (RadioGroup) view.findViewById(R.id.radio);
        RadioButton rbu1 = (RadioButton) view.findViewById(R.id.radioButton1);
        RadioButton rbu2 = (RadioButton) view.findViewById(R.id.radioButton2);

        if (M.equalsIgnoreCase("1")) {
            rbu1.setChecked(true);
        } else if (M.equalsIgnoreCase("2")) {

            rbu2.setChecked(true);
        }
        //choix du gouvernorat
        Spinner choix = (Spinner) view.findViewById(R.id.choixp);
        ArrayAdapter<Ville> V = new ArrayAdapter<Ville>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Ville.values());
        V.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choix.setOnItemSelectedListener(this);
        choix.setAdapter(V);
        //choix type de bien
        Spinner choix1 = (Spinner) view.findViewById(R.id.choixp1);
        ArrayAdapter<local> L = new ArrayAdapter<local>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, local.values());
        L.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choix1.setOnItemSelectedListener(this);
        choix1.setAdapter(L);
        //choix du nombre de piece
        Spinner choix2 = (Spinner) view.findViewById(R.id.choixp2);
        ArrayAdapter<piece> P = new ArrayAdapter<piece>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, piece.values());
        P.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choix2.setOnItemSelectedListener(this);
        choix2.setAdapter(P);

    return view;
    }


    //choix du bien
    public void onItemSelected1(AdapterView<?> parent, View vue, int position, long id) {
        local L = local.values()[position];
    }
    public void onNothingSelected1(AdapterView<?> parent ){}
    //choix du gouvernorat
    public void onItemSelected(AdapterView<?> parent, View vue, int position, long id) {
        Ville v = Ville.values()[position];
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    //choix du pièce
    public void onItemSelected2(AdapterView<?> parent, View vue, int position, long id) {
        piece P = piece.values()[position];
    }
    public void onNothingSelected2(AdapterView<?> parent) {}
    //map
    public void sendMessageR(View view) {
      //  Intent intent = new Intent(this, MapsActivity.class);
      //  startActivity(intent);
    }
    //valider
   /* public void sendMessage(View view)
    {
        Intent intent = new Intent(this, ValidatActivity.class);
        Intent.putExtra("ae",prix);
        startActivity(intent);
    }
*/
/*
    private void addMapFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MapsActivity fragment = new MapsActivity();
        transaction.add(R.id.map, fragment);
        transaction.commit();
    }
*/
//ajout des images de location
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_MULTIPLE) {
                imagesPathList = new ArrayList<String>();
                String[] imagesPath = data.getStringExtra("data").split("\\|");
                try {
                    lnrImages.removeAllViews();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < imagesPath.length; i++) {
                    imagesPathList.add(imagesPath[i]);
                    yourbitmap = BitmapFactory.decodeFile(imagesPath[i]);
                    ImageView imageView = new ImageView(this);
                    imageView.setImageBitmap(yourbitmap);
                    imageView.setAdjustViewBounds(true);
                    lnrImages.addView(imageView);
                }
            }
        }

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddPhots:
                Intent intent = new Intent(MainActivity.this,select_image.class);
                startActivityForResult(intent,PICK_IMAGE_MULTIPLE);
                break;
            case R.id.btnPublier:

                EditText edit1=(EditText)view.findViewById(R.id.Text6);
                EditText edit2=(EditText)view.findViewById(R.id.Text7);
                EditText edit3=(EditText)view.findViewById(R.id.Text4);

                Spinner choix = (Spinner) view.findViewById(R.id.choix);
                Spinner choix1 = (Spinner) view.findViewById(R.id.choix1);
                Spinner choix2= (Spinner) view.findViewById(R.id.choix2);

                Intent intent1=new Intent(MainActivity.this, ValidatActivity.class);
                intent1.putExtra("prix",edit1.getText().toString());
                intent1.putExtra("address",edit3.getText().toString());
                intent1.putExtra("surface",edit2.getText().toString());
                intent1.putExtra("immobilier",choix1.getSelectedItem().toString());
                intent1.putExtra("gouvernorat",choix.getSelectedItem().toString());
                intent1.putExtra("nbr",choix2.getSelectedItem().toString());

                startActivity(intent1);
                break;

        }
    }

*/

}