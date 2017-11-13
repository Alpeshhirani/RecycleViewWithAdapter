/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.oozeetech.manish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LedgerListAdapter extends RecyclerView.Adapter<LedgerListAdapter.MessageListHolder> {

    public EventListener mEventListener;
    Context context;
    private List<String> data = new ArrayList<>();


    public LedgerListAdapter(Context context) {

        this.context = context;

    }


    public void addAll(List<String> mData) {

        data.addAll(mData);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public boolean checkSize() {
        if (data.size() == 0)
            return true;
        else
            return false;
    }

    public void removeAt(int position) {
        data.remove(position);
        notifyDataSetChanged();
    }

    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public MessageListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.ledger_raw_data, parent, false);
        return new MessageListHolder(v);
    }

    @Override
    public void onBindViewHolder(final MessageListHolder holder, final int position) {
holder.customerName.setText(data.get(position).toString());
        holder.rawItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEventListener != null) {
                    mEventListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public EventListener getEventListener() {
        return mEventListener;
    }

    public void setEventListener(EventListener eventListener) {
        mEventListener = eventListener;
    }


    public interface EventListener {
        void onClick(int position);

    }

    static class MessageListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitle)
        TextView customerName;


        @BindView(R.id.activity_main)
        LinearLayout rawItem;

        public MessageListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
