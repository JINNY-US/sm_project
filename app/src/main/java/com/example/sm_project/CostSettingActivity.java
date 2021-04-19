package com.example.sm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CostSettingActivity extends AppCompatActivity {
    Spinner spinner;
    Button cost_save_btn;
    TextView mode_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_setting);

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
                        break;
                    case "쇼핑 위주":
                        mode_description.setText("'쇼핑 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "쇼핑 5 : 식사 3 : 기타 2 \n" +
                                "의 비율로 자동 배분됩니다.");
                        break;
                    case "카페 위주":
                        mode_description.setText("'카페 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "카페 5 : 식사 3 : 기타 2 \n" +
                                "의 비율로 자동 배분됩니다.");
                        break;
                    case "주점 위주":
                        mode_description.setText("'주점 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "주점 5 : 기타 5 \n" +
                                "의 비율로 자동 배분됩니다.");
                        break;
                    case "기타(노래방, 이색카페 등) 위주":
                        mode_description.setText("'기타(노래방, 이색카페 등) 위주'를 선택하시면 전체 금액에서 세부 금액이\n" +
                                "기타 5 : 식사 3 : 카페 2 \n" +
                                "의 비율로 자동 배분됩니다.");
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
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();

            }
        });


    }
}