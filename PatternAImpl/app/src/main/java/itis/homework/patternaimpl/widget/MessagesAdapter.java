package itis.homework.patternaimpl.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import itis.homework.patternaimpl.R;
import itis.homework.patternaimpl.content.Message;

/**
 * @author Artur Vasilov
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.Holder> {

    private final List<Message> mMessages;

    public MessagesAdapter(@NonNull List<Message> messages) {
        mMessages = messages;
    }

    public void setMessages(@NonNull List<Message> messages) {
        mMessages.clear();
        mMessages.addAll(messages);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mTextView.setText(mMessages.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        public Holder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
