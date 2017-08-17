package com.blueicon.searchable.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.blueicon.searchable.R;
import com.blueicon.searchable.models.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 16/08/17.
 */

public class AdaptadorPersona extends ArrayAdapter<Persona> {
    private List<Persona> personasList;


    public AdaptadorPersona( Context context,List<Persona> personasList) {
        super(context, 0,personasList);
        this.personasList =  personasList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView  = convertView;
        if(itemView ==  null){
            itemView =  inflater.inflate(R.layout.item_persona,viewGroup,false);

        }
        TextView textView =  (TextView) itemView.findViewById(R.id.nomprePersona);
        final Persona persona = getItem(position);
        textView.setText(persona.getNombre());
        return  itemView;
    }
    @Override
    public Filter getFilter(){
        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                System.out.println("ITEM PERSONA1: "+constraint);
                constraint = constraint.toString().toLowerCase();
                FilterResults result = new FilterResults();

                if (constraint != null && constraint.toString().length() > 0) {
                    List<Persona> founded = new ArrayList<>();
                    for(Persona persona: personasList){
                        if(persona.toString().toLowerCase().contains(constraint)){
                            founded.add(persona);
                            System.out.println("ITEM PERSONA3: "+persona.getNombre());
                        }
                    }

                    result.values = founded;
                    result.count = founded.size();
                }else {
                    result.values = personasList;
                    result.count = personasList.size();
                }
                return result;


            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                for (Persona persona : (List<Persona>) results.values) {
                    System.out.println("ITEM PERSONA2: "+persona.getNombre());
                    add(persona);
                }
                notifyDataSetChanged();
            }
        };
    }


}
