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
 * Use the {@link FragmentAppetizer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAppetizer extends Fragment {
    View view;
    private RecyclerView appetizerRV;
    private Vector<ItemList> itemListVector;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAppetizer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAppetizer.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAppetizer newInstance(String param1, String param2) {
        FragmentAppetizer fragment = new FragmentAppetizer();
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
        itemListVector.add(new ItemList("Gravlax", "A Nordic dish made of cured salmon infused with fresh dill, vodka (optional) and seasonings. A good bagel goes well with this appetizing treat.",34000));
        itemListVector.add(new ItemList("Korean Pancake", "These Korean pancakes are so so addictive! Don’t think they’re just some ordinary pancakes. These babies will take you on a culinary adventure. With seafood in the mix, this could be my breakfast.", 23000));
        itemListVector.add(new ItemList("Mexican Queso Fundido", "Layers of ooey gooey melted cheese loaded with spicy chorizo sausage. How can you resist?!! For Cinco de Mayo, nothing could be more perfect. Serve it with red, white, and blue tortilla chips and they could be what your Fourth of July cookout needs.", 30000));
        itemListVector.add(new ItemList("Malaysian Chicken Satay", "The best chicken satay you’ll ever have with its oriental flair and exotic flavors! The shallots, turmeric, and lemongrass mixture of seasonings will leave a taste in your mouth that will surely boost your appetite.", 22000));
        itemListVector.add(new ItemList("Filipino Lumpia", "The Filipino version of spring rolls served with sweet and sour dipping sauce. If you can get your hand on some bean sprouts, throw some in the filling mixture for a truly out of this world experience. You might also want to take a look at these easy spring roll recipes which works as tasty appetizers!", 24500));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appetizer, container, false);
        appetizerRV = view.findViewById(R.id.appetizerRV);
        RvAdapter adapter = new RvAdapter(getContext(), itemListVector);
        appetizerRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        appetizerRV.setAdapter(adapter);
        return view;
    }
}