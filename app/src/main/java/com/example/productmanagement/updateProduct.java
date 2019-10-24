package com.example.productmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class updateProduct extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.UpdateText) TextView mUpdateText;
    @BindView(R.id.IdEdit) EditText mIdEdit;
    @BindView(R.id.PriceEdit) EditText mPriceEdit;
    @BindView(R.id.QuantityEdit) EditText mQuantityEdit;
    @BindView(R.id.UpdateBtn) Button mUpdateBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        ButterKnife.bind(this);
        mUpdateBtn.setOnClickListener(this);
        
        
    }

    @Override
    public void onClick(View v) {
        
        if (v == mUpdateBtn){
            UpdateProduct();
        }

    }

    private void UpdateProduct() {
    }
}
