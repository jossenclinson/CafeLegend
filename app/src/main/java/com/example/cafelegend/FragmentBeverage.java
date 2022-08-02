package com.example.cafelegend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cafelegend.adapter.RvAdapter;
import com.example.cafelegend.model.ItemList;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBeverage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBeverage extends Fragment {
    View view;
    private RecyclerView beverageRV;
    private Vector<ItemList> itemListVector;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBeverage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBeverage.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBeverage newInstance(String param1, String param2) {
        FragmentBeverage fragment = new FragmentBeverage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        itemListVector = new Vector<>();
        itemListVector.add(new ItemList("Mango Lassi", "Some of India's lucky workers have migrated into the air-conditioned confines of its call centers and IT offices. For the rest, and for travelers there, reprieve comes in the form of a cooling, sweat-beating summer drink that acts like an internal sun screen.", 25000, R.drawable.p1));
        itemListVector.add(new ItemList("Pina Colada", "Just looking at the drink brings you closer to a beach and sipping this mixture of coconut milk, pineapple juice and rum will send you directly to a hammock between palm trees in the Caribbean.", 28000, R.drawable.p2));
        itemListVector.add(new ItemList("Cendol", "Strictly speaking this is more of a watery dessert than a drink, and is served in a bowl, but at least that way you get to take bigger gulps. The mixture of creamy coconut milk and sweet palm sugar chilled by shaved ice will is the perfect antidote to the hawkers on Kuta beach.", 17000, R.drawable.p3));
        itemListVector.add(new ItemList("Chocolate Milkshake", "This artery-clogging third musketeer (after burger and fries) of the fast-food world gives a sweet ending to all family meals out. And it may not even be as fattening as you think -- the amount of energy spent trying to slurp this thick sludge up the straw must burn off at least a few of those calories.", 64000, R.drawable.p4));
        itemListVector.add(new ItemList("Eggnog", "Bring in the eggnog and the otherwise long and torturous family gathering where everyone wears hideous sweaters turns into a joyous Christmas dinner. This sweetened beverage of milk and beaten eggs tastes like an alcoholic creamy egg custard. Best served warm.", 65000, R.drawable.p5));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beverage, container, false);
        beverageRV = view.findViewById(R.id.beverageRV);
        RvAdapter adapter = new RvAdapter(getContext(), itemListVector);
        beverageRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        beverageRV.setAdapter(adapter);
        return view;
    }
}