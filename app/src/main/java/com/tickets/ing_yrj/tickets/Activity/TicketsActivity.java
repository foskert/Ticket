package com.tickets.ing_yrj.tickets.Activity;

import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import com.tickets.ing_yrj.tickets.Adapter.TicketAdapter;
import com.tickets.ing_yrj.tickets.Model.Ticket;
import com.tickets.ing_yrj.tickets.Model.itemTicket;
import com.tickets.ing_yrj.tickets.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TicketsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Toolbar toolbar_ticket;
    private static TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        inicialiceComponen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tickets, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ListView list_ticket;
        public  ArrayList<itemTicket> item;
        public PlaceholderFragment() { }
        public boolean ban=true;
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tickets, container, false);
            list_ticket=(ListView) rootView.findViewById(R.id.list_ticket);

            if(ban){
                Bundle information = this.getActivity().getIntent().getExtras();
                getArrayItemTicket(information.getString("response"));
                ban=false;
            }
            ticketAdapter = new TicketAdapter(rootView.getContext(), item.get(getArguments().getInt(ARG_SECTION_NUMBER)-1).getTicket());
            list_ticket.setAdapter(ticketAdapter);
            ticketAdapter.notifyDataSetChanged();
            return rootView;
        }
        private  void getArrayItemTicket(String value){
            try {
                if (!value.equals("")){
                    JSONObject Obj = new JSONObject(value);
                    JSONArray jArrayItem = Obj.getJSONArray("items");
                    item = new ArrayList<itemTicket>();
                    for (int i=0; i<jArrayItem.length(); i++){
                        JSONObject json_data_item = jArrayItem.getJSONObject(i);
                        itemTicket resultRaw_item = new itemTicket();
                        resultRaw_item.setNumber(json_data_item.getString("number"));
                        JSONArray jArrayTicket= new JSONArray(json_data_item.getString("ticket"));
                        ArrayList<Ticket> ticket = new ArrayList<Ticket>();
                        for (int j=0; j<jArrayTicket.length();j++ ){
                            JSONObject json_data_ticket=jArrayTicket.getJSONObject(j);
                            Ticket resultRaw_ticket=new Ticket();
                            resultRaw_ticket.setText_1(json_data_ticket.getString("text_1"));
                            resultRaw_ticket.setText_2(json_data_ticket.getString("text_2"));
                            resultRaw_ticket.setDate_1(json_data_ticket.getString("date_1"));
                            resultRaw_ticket.setDate_2(json_data_ticket.getString("date_2"));
                            resultRaw_ticket.setUrlImg( json_data_ticket.getString("urlImg"));
                            resultRaw_ticket.setPoint(json_data_ticket.getInt("point") );
                            ticket.add(resultRaw_ticket);
                        }
                        resultRaw_item.setTicket(ticket);
                        item.add(resultRaw_item);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 7;
        }
    }
    private  void inicialiceComponen(){
        toolbar_ticket= (Toolbar) findViewById(R.id.toolbar_ticket);
        setSupportActionBar(toolbar_ticket);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }
}
