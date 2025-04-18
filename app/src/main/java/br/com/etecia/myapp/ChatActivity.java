package br.com.etecia.myapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChatActivity extends AppCompatActivity {
    BottomNavigationView idChatBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chat_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        idChatBottomNav = findViewById(R.id.idChatBottomNav);

        idChatBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            Fragment select_fragment = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mChatConversas) {
                    select_fragment = new ConversasFragment();
                }
                if (id == R.id.mChatAtualizacoes) {
                    select_fragment = new AtualizacoesFragment();
                }
                if (id == R.id.mChatComunicaoes) {
                    select_fragment = new ComunidadesFragment();
                }
                if (id == R.id.mChatLigacoes) {
                    select_fragment = new LigacoesFragment();
                }

                if (select_fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select_fragment).commit();

                }

                return true;
            }


        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ConversasFragment()).commit();

        }
    }
}