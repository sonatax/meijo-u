package jp.ac.meijou.android.yuuicnak;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.yuuicnak.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // intent を取得します
        Intent intent = getIntent();
        String sentText = intent.getStringExtra("editText");
        binding.calcField.setText(sentText);

        // OK button の処理
        binding.buttonOk.setOnClickListener(view -> {
            var ok_intent = new Intent();
            ok_intent.putExtra("ret", "OK");
            setResult(RESULT_OK, ok_intent);
            finish();
        });

        // Cancel button の処理
        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });


        // 電卓用のコード
        binding.button0.setOnClickListener(view -> {

        });
    }
}