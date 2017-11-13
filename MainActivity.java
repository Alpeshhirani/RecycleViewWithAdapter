package com.oozeetech.manish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rvExpense)
    RecyclerView rvExpense;
    LedgerListAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        final ArrayList<String> arrayLedgerList=new ArrayList<>();
        arrayLedgerList.add("one");
        arrayLedgerList.add("one");
        arrayLedgerList.add("two");
        arrayLedgerList.add("one");
        arrayLedgerList.add("three");
        arrayLedgerList.add("one");
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvExpense.setLayoutManager(mLayoutManager);
        adapter = new LedgerListAdapter(MainActivity.this);
        rvExpense.setAdapter(adapter);
        adapter.addAll(arrayLedgerList);
        adapter.setEventListener(new LedgerListAdapter.EventListener() {
            @Override
            public void onClick(int ledgerPosition) {
                Toast.makeText(getApplicationContext(),""+arrayLedgerList.get(ledgerPosition).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }


}
