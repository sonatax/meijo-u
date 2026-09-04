package jp.ac.meijou.android.yuuicnak;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jp.ac.meijou.android.yuuicnak.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        var list = List.of(
            new ListItem(getDrawable(R.drawable.outline_code), "MainActivity2", MainActivity2.class),
            new ListItem(getDrawable(R.drawable.outline_123), "MainActivity3", MainActivity3.class),
            new ListItem(getDrawable(R.drawable.outline_android), "MainActivity4", MainActivity4.class),
            new ListItem(getDrawable(R.drawable.outline_api), "MainActivity5", MainActivity5.class),
            new ListItem(getDrawable(R.drawable.baseline_network_check), "MainActivity6", MainActivity6.class)
        );

        binding.recyclerView.setAdapter(new MainAdapter(list));
        var layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }
}