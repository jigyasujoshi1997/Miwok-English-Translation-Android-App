package com.example.android.miwok;

        import android.app.Activity;
        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class wordAdapter extends ArrayAdapter<word> {

    public wordAdapter(Activity context,ArrayList<word>words){
        super(context, 0, words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_item, parent, false); }
        word currentWord = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTranslation);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.imageicon);

        if (currentWord.hasImage()){
            image.setImageResource(currentWord.getmImageResourceId());
            image.setVisibility(View.VISIBLE);

        }else
            image.setVisibility(View.GONE);
        return listItemView;
    }
}