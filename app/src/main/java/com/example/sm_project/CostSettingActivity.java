package com.example.sm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CostSettingActivity extends AppCompatActivity {
    Spinner spinner;
    Button cost_save_btn;
    TextView mode_description;
    EditText editText;

    int t_cost;
    int per_rest, per_shop, per_cafe, per_bar, per_etc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_setting);

        final Bundle bundle = new Bundle();

        spinner = findViewById(R.id.spinner);


        cost_save_btn = findViewById(R.id.cost_save_btn);
        mode_description = findViewById(R.id.mode_des);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selItem = (String) spinner.getSelectedItem();


                switch (selItem) {
                    case "식당 위주":
                        mode_description.setText("'식당 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "식당 5 : 카페 2 : 기타 3 \n" +
                                "의 비율로 자동 배분됩니다.");
                        per_rest = 5;
                        per_cafe = 2;
                        per_etc = 3;
                        per_shop = 0;
                        per_bar = 0;

                        break;
                    case "쇼핑 위주":
                        mode_description.setText("'쇼핑 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "쇼핑 5 : 식사 3 : 기타 2 \n" +
                                "의 비율로 자동 배분됩니다.");
                        per_shop = 5;
                        per_rest = 3;
                        per_etc = 2;
                        per_cafe = 0;
                        per_bar = 0;

                        break;
                    case "카페 위주":
                        mode_description.setText("'카페 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "카페 5 : 식사 3 : 기타 2 \n" +
                                "의 비율로 자동 배분됩니다.");
                        per_cafe = 5;
                        per_rest = 3;
                        per_etc = 2;
                        per_shop = 0;
                        per_bar =0;
                        break;
                    case "주점 위주":
                        mode_description.setText("'주점 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "주점 5 : 기타 5 \n" +
                                "의 비율로 자동 배분됩니다.");
                        per_bar = 5;
                        per_etc = 5;
                        per_shop = 0;
                        per_rest = 0;
                        per_cafe = 0;

                        break;
                    case "기타(노래방, 이색카페 등) 위주":
                        mode_description.setText("'기타(노래방, 이색카페 등) 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "기타 5 : 식사 3 : 카페 2 \n" +
                                "의 비율로 자동 배분됩니다.");
                        per_etc = 5;
                        per_rest = 3;
                        per_cafe = 2;
                        per_shop = 0;
                        per_bar = 0;
                        break;

                    case "직접 지정":
                        mode_description.setText("직접 지정이 가능합니다. 비율을 설정해주세요.");

                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mode_description.setText("모드는 필수적으로 선택해야합니다.");

            }
        });

        cost_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_test.class);
                editText = (EditText)findViewById(R.id.txt_totalcost);
                t_cost = Integer.parseInt(editText.getText().toString());
                String[] cost_array = new String[5];
                cost_array[0] = String.valueOf(t_cost * 0.1 * per_rest);
                cost_array[1] = String.valueOf(t_cost * 0.1 * per_shop);
                cost_array[2] = String.valueOf(t_cost * 0.1 * per_cafe);
                cost_array[3] = String.valueOf(t_cost * 0.1 * per_bar);
                cost_array[4] = String.valueOf(t_cost * 0.1 * per_etc);
                bundle.putStringArray("array",cost_array);
                intent.putExtra("myBundle", bundle);
                startActivity(new Intent(getApplicationContext(), activity_test.class));
                finish();

            }
        });


    }


    public int[] Cost_Calculator(int t, int p_r, int p_s, int p_c, int p_b, int p_e){
//        int c_restaurant, c_shopping, c_cafe, c_bar, c_etc;

//        c_restaurant = (int) (t * 0.1 * p_r);
//        c_shopping = (int) (t * 0.1 * p_s);
//        c_cafe = (int) (t * 0.1 * p_c);
//        c_bar = (int) (t * 0.1 * p_b);
//        c_etc = (int) (t * 0.1 * p_e);

        int[] cost_array = new int[5];
        cost_array[0] = (int) (t * 0.1 * p_r);
        cost_array[1] = (int) (t * 0.1 * p_s);
        cost_array[2] = (int) (t * 0.1 * p_c);
        cost_array[3] = (int) (t * 0.1 * p_b);
        cost_array[4] = (int) (t * 0.1 * p_e);



        return cost_array;
    }


}

