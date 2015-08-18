package tn.codeit.darna;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.effectivenavigation.R;


public class Filtrer extends Fragment implements AdapterView.OnItemSelectedListener {
    private enum Ville {Ariana,Beja,Ben_Arous,Bizerte,Gabes,Gafsa,Jendouba,Kairouan,Kasserine,Kebili,Kef,Mahdia,Manouba,Medenine,Monastir,Nabeul,Sfax,Sidi_Bouzid,Siliana,Sousse,Tataouine,Tozeur,Tunis,Zaghouan};
    private enum local {Maison,Studio,Appartement,Bureau,Garage,Villa};
    private TextView textView1;
    private SeekBar seekBar1;
    private RadioGroup radio;
    View view;
    TextView min,max;
    EditText edt_prixmin,edt_prixmax;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_filtrer,container,false);
        //transaction (achat ou bien location )
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio);
        int checkedRadioButton = radioGroup.getCheckedRadioButtonId();

        String radioButtonSelected = "";

        switch (checkedRadioButton) {
            case R.id.radioButton1 : radioButtonSelected = "radiobutton1";
                break;
            case R.id.radioButton2 : radioButtonSelected = "radiobutton2";
                break;}

        //choix du gouvernorat
        Spinner choix = (Spinner) view.findViewById(R.id.choix);

        ArrayAdapter<Ville> V = new ArrayAdapter<Ville>(getActivity().getApplicationContext(), R.layout.spinner_item, Ville.values());
        V.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choix.setOnItemSelectedListener(this);
        choix.setAdapter(V);

        //choix type de bien
        Spinner choix1 = (Spinner) view.findViewById(R.id.choix1);
        ArrayAdapter<local> L = new ArrayAdapter<local>(getActivity().getApplicationContext(), R.layout.spinner_item, local.values());
        L.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choix1.setOnItemSelectedListener(this);
        choix1.setAdapter(L);
        //boutton recherche
        final Button B = (Button) view.findViewById(R.id.button);
        B.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, recherche.class);
                //startActivity(intent);
            }
        });
        //choix superficie
        initializeVariables1();
        textView1.setText(seekBar1.getProgress() + " m" + "\u00B2");
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView1.setText(progress + " m" + "\u00B2");
            }
        });

        return view;

    }
    //choix superficie
    private void initializeVariables1() {
        seekBar1 = (SeekBar) view.findViewById(R.id.seekBar);
        textView1 = (TextView) view.findViewById(R.id.Text6);}
    //choix du bien
    public void onItemSelected1(AdapterView<?> parent, View vue, int position, long id) {
        local L = local.values()[position];}
    public void onNothingSelected1(AdapterView<?> parent ){}
    //choix du gouvernorat
    public void onItemSelected(AdapterView<?> parent, View vue, int position, long id) {
        Ville v = Ville.values()[position];}
    public void onNothingSelected(AdapterView<?> parent) {}

    // transaction (achat ou bien location ) bouton radio
    public void addListenerOnButton() {
        radio = (RadioGroup) view.findViewById(R.id.radio);}




}