package com.example.pint_android_v3;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.pint_android_v3.menus.menu_municipe;
import com.example.pint_android_v3.perfis.perfil_cliente;
import com.example.pint_android_v3.perfis.perfil_motorista;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class barra_lateral_pro extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_lateral_pro);
       Bar_Settings();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.LogOut_btn_menu:
                Intent intent1 = new Intent(this, MainActivity_Login.class);
                startActivity(intent1);
                break;
            case R.id.User_btn_menu:
                Intent intent2 = new Intent(this, perfil_cliente.class);
                startActivity(intent2);
                break;
            case R.id.Home_btn_menu:
                Intent intent3 = new Intent(this, menu_municipe.class);
                startActivity(intent3);
                break;
            //Criar activity Notificações
            //Default?
            //Trocar perfil_motorista por municipe



        }
        return false;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }





    public void Bar_Settings()
    {
        toolbar = findViewById(R.id.barra_lateral_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);


        drawerLayout = findViewById(R.id.barra_lateral_drawer_layout);
        navigationView = findViewById(R.id.nav_view_barra);

        Menu menu = navigationView.getMenu();

        MenuItem tools= menu.findItem(R.id.op_menu_cliente_barra);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        tools.setTitle(s);

        tools= menu.findItem(R.id.sair_menu_cliente_barra);
        s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        tools.setTitle(s);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }
}