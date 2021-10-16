package com.example.examen.Presentador;

import com.example.examen.Modelo.Usuario;
import com.example.examen.Modelo.UsuarioInt;
import com.example.examen.Vista.ViewInt;

public class Presenter  implements PresenterInt{
    private UsuarioInt user;
    private ViewInt view;
    public Presenter(ViewInt view){
        this.view = view;
        user = new Usuario(this);

    }
    @Override
    public void register(String name, String email, String password) {
        if(user != null){
            user.register(name, email, password);
        }
    }

    @Override
    public void registerTravel(String myLocation, String myDestiny) {
        if(user != null){
            user.registerTravel(myLocation, myDestiny);
        }
    }

    @Override
    public void showName(String name) {
        if (view != null){
            view.showName(name);
        }
    }

    @Override
    public void showTravels(String travels) {
        if (view != null){
            view.showTravels(travels);
        }
    }
}
