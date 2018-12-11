package com.example.raffael.apploja;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.raffael.apploja.subclasses.Carrinho;
import com.example.raffael.apploja.subclasses.Produtos;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Chama automaticamente a tela de "Produtos"
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Produtos()).commit();
            navigationView.setCheckedItem(R.id.nav_produtos);
        }
        setDados(); //Chama o método que vai setar as informações do usuário(Email)
    }
    //Seta o email do usuário no cabeçalho
    public void setDados(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.email);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            navUsername.setText(bundle.getString("user"));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart, menu);
        return true;
    }

    //Abre a tela de carrinho quando eu clicar no ícone do carrinho
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.cart_bar) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Carrinho()).commit();
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setCheckedItem(R.id.nav_carrinho);
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Chama as telas de acordo com as opções que eu selecionar
        int id = item.getItemId();

        if (id == R.id.nav_produtos) {
            // Chama as classes que está na pasta "subclasses"
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Produtos()).commit();
        } else if (id == R.id.nav_carrinho) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Carrinho()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
