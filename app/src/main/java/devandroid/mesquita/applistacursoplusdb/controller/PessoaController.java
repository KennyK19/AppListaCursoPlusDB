package devandroid.mesquita.applistacursoplusdb.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.mesquita.applistacursoplusdb.database.ListaVipDB;
import devandroid.mesquita.applistacursoplusdb.model.Pessoa;
import devandroid.mesquita.applistacursoplusdb.view.MainActivity;

public class PessoaController extends ListaVipDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVIP;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences =
                mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVIP = preferences.edit();
    }


    public void salvar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();

        listaVIP.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVIP.putString("sobrenome",pessoa.getSobrenome());
        listaVIP.putString("CursoDesejado",pessoa.getCursoDesejado());
        listaVIP.putString("TelefoneContato",pessoa.getTelefoneContato());
        listaVIP.apply();

        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobrenome",pessoa.getSobrenome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        salvarObjeto("Pessoa", dados);

    }

    public Pessoa buscarDadosSharedPreferences(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("TelefoneContato", "NA"));

        return pessoa;
    }

    public void limpar (){

        listaVIP.clear();
        listaVIP.apply();

    }

    public void alterar(Pessoa pessoa){

        ContentValues dados = new ContentValues();

        dados.put("id",pessoa.getId());
        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobrenome",pessoa.getSobrenome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        alterarObjeto("Pessoa", dados);

    }

    public void deletar (int id){
        deletarObjeto("Pessoa",id);
    }


    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
