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
 * Use the {@link FragmentMainCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMainCourse extends Fragment {
    View view;
    private RecyclerView mainCourseRV;
    private Vector<ItemList> itemListVector;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMainCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMainCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMainCourse newInstance(String param1, String param2) {
        FragmentMainCourse fragment = new FragmentMainCourse();
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
        itemListVector.add(new ItemList("Rendang", "Often called \"the world's most delicious dish,\" Rendang is prepared by simmering beef with coconut milk with a mixture of the best of spices including turmeric, garlic, lemongrass, ginger, chillies, and galangal.", 75000));
        itemListVector.add(new ItemList("Sushi", "Prepared with vinegared rice and a wide range of ingredients including seafood, vegetables, and sometimes fruits. Sushi tastes best when served with wasabi, pickled ginger, and soy sauce.", 55000));
        itemListVector.add(new ItemList("Ramen", "If not tried, you must have heard of Ramen at least once in your life. However, we are not talking about the packaged instant noodles. Ramen is a Japanese dish made of wheat noodles and served in the broth along with vegetables and meat.", 35000));
        itemListVector.add(new ItemList("Tom Yam Goong", "A type of sour and hot Thai soup, Tom yam goong is prepared with shrimp along with a load of healthy herbs and spices?  lemongrass, lime, kaffir leaves, galangal, and red chili peppers to name a few.", 59900));
        itemListVector.add(new ItemList("Kebab", "A dish popular across the Middle East, Kebabs are originally from Turkey. They consist of ground meat or seafood, fruits, and vegetables in some cases and are cooked on a skewer with a big fire underneath, just like a barbeque on the grill.", 42800));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main_course, container, false);
        mainCourseRV = view.findViewById(R.id.mainCourseRV);
        RvAdapter adapter = new RvAdapter(getContext(), itemListVector);
        mainCourseRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainCourseRV.setAdapter(adapter);
        return view;
    }
}