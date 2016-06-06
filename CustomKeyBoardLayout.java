package com.dunzo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dunzo.user.R;

/**
 * Created by Appple on 08/02/16.
 */
public class CustomKeyBoardLayout extends LinearLayout implements View.OnClickListener {
    private static final String TAG = CustomKeyBoardLayout.class.getName();
    private EditText mEditText;

    public CustomKeyBoardLayout(Context context) {
        super(context);
        initViews();
    }

    public CustomKeyBoardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public CustomKeyBoardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.custom_keyboard_layout, this);
        findViewById(R.id.key1).setOnClickListener(this);
        findViewById(R.id.key2).setOnClickListener(this);
        findViewById(R.id.key3).setOnClickListener(this);
        findViewById(R.id.key4).setOnClickListener(this);
        findViewById(R.id.key5).setOnClickListener(this);
        findViewById(R.id.key6).setOnClickListener(this);
        findViewById(R.id.key7).setOnClickListener(this);
        findViewById(R.id.key8).setOnClickListener(this);
        findViewById(R.id.key9).setOnClickListener(this);
        findViewById(R.id.key0).setOnClickListener(this);
        findViewById(R.id.back_icon_layout).setOnClickListener(this);
        setUpKeyText();
    }


    public void registerEditText(EditText edtText) {
        mEditText = edtText;
    }

    @Override
    public void onClick(View v) {

        handleKeyClick(v);
    }

    private void handleKeyClick(View keyView) {
        int selection = mEditText.getSelectionStart();
        String beforeSel = "", afterSel = "";
        String mEditTextString = mEditText.getText().toString();
        Log.d(TAG, "selection is " + selection);
        if (keyView.getId() == R.id.back_icon_layout) {
            // remove the character from edit text
            if (selection == 0)
                return;
            if (selection > 0) {
                beforeSel= mEditTextString.substring(0,selection-1);
                if(mEditTextString.length() > selection){
                    afterSel= mEditTextString.substring(selection,mEditTextString.length());
                }

            }
            mEditText.setText(beforeSel+afterSel);
            mEditText.setSelection(selection-1);



        } else {
            if(mEditTextString.length()==3)
                return;

            String enteredChar = ((TextView) keyView.findViewById(R.id.key_no)).getText().toString();

            if (mEditTextString.length() == 0) {
                // no string , so no need for substring
                mEditText.setText(beforeSel + enteredChar + afterSel);
                mEditText.setSelection(mEditText.getSelectionStart() + 1);
            } else {

                beforeSel = mEditTextString.substring(0, selection);
                // process hard keys
                if (selection < mEditText.getText().toString().length()) {
                    afterSel = mEditTextString.substring(selection , mEditTextString.length());
                }
            }

            mEditText.setText(beforeSel + enteredChar + afterSel);
            mEditText.setSelection(selection + 1);
        }
    }

    private void setUpKeyText() {
        // first row layout
        View view = findViewById(R.id.key2);
        ((TextView) view.findViewById(R.id.key_no)).setText("2");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("ABC");
        // key 3
        view = findViewById(R.id.key3);
        ((TextView) view.findViewById(R.id.key_no)).setText("3");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("DEF");
        // key 4
        view = findViewById(R.id.key4);
        ((TextView) view.findViewById(R.id.key_no)).setText("4");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("GHI");

        // jey 5
        view = findViewById(R.id.key5);
        ((TextView) view.findViewById(R.id.key_no)).setText("5");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("JKL");
        // jey 6
        view = findViewById(R.id.key6);
        ((TextView) view.findViewById(R.id.key_no)).setText("6");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("MNO");
        // key 7
        view = findViewById(R.id.key7);
        ((TextView) view.findViewById(R.id.key_no)).setText("7");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("PQRS");
        // key 8
        view = findViewById(R.id.key8);
        ((TextView) view.findViewById(R.id.key_no)).setText("8");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("TUV");
        // key 9
        view = findViewById(R.id.key9);
        ((TextView) view.findViewById(R.id.key_no)).setText("9");
        ((TextView) view.findViewById(R.id.key_alphabet)).setText("WXY");
        // key 0
        view = findViewById(R.id.key0);
        ((TextView) view.findViewById(R.id.key_no)).setText("0");

    }
}
