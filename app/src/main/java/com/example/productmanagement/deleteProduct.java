package com.example.productmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class deleteProduct extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.BtnSubmit) Button mBtnSubmit;
    @BindView(R.id.EditDelete) EditText mEditDelete;
    @BindView(R.id.deleteTextView) TextView mDeleteTextView;

    private ProgressDialog mProgressDialog;
    String httpUrl = "http://192.168.43.248/scripts/delete_product.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        ButterKnife.bind(this);
        createProgressDialog();



        mBtnSubmit.setOnClickListener(this);

    }

    private void createProgressDialog() {

        mProgressDialog = new ProgressDialog(this);

        mProgressDialog.setTitle("Loading ......");
        mProgressDialog.setMessage("Removing Data from Data");
        mProgressDialog.setCancelable(false);
    }


    @Override
    public void onClick(View v) {
        if (v == mBtnSubmit){
            removeProduct();

            Intent intent = new Intent(deleteProduct.this,MainScreen.class);
            startActivity(intent);
            finish();

        }

    }

    private void removeProduct() {

        mProgressDialog.show();

        final String pid = mEditDelete.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(deleteProduct.this, response, Toast.LENGTH_SHORT).show();
                        mProgressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(deleteProduct.this , error.toString(),Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String ,String> getParams(){
            Map<String,String> params = new HashMap<String,String>();
                    params.put("pid",pid);
                    return params;


            }

        };
        RequestQueue mRequestQue = Volley.newRequestQueue(this);
        mRequestQue.add(stringRequest);
    }
}
