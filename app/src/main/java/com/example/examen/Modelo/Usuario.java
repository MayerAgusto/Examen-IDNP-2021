package com.example.examen.Modelo;

import com.example.examen.Presentador.Presenter;
import com.example.examen.Presentador.PresenterInt;

import java.util.ArrayList;

public class Usuario  implements UsuarioInt{
    private String name;
    private String email;
    private String password;
    private ArrayList<Travel> travels;
    private PresenterInt presenter;


    public Usuario(PresenterInt presenterInt){
        presenter = presenterInt;
        travels = new ArrayList<Travel>();
    }
    private class Travel{
        private String myLocation;
        private String myDestiny;
        public Travel(String myLocation, String myDestiny){
            this.myLocation = myLocation;
            this.myDestiny = myDestiny;
        }
        public String  showTravel(){
            String message= "["+"\n";
            message += "Ubicacion:" + "\t" + this.myLocation + "\n";
            message += "Destino:" + "\t" + this.myDestiny + "\n";
            message += "]"+"\n";
            return message;
        }
    }

    public void setName(String name){this.name = name;}
    public void setEmail(String email){this.email = email;}
    public void setPassword(String password){this.password = password;}

    @Override
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        presenter.showName(this.name);
    }

    @Override
    public void registerTravel(String myLocation, String myDestiny) {
        Travel travel = new Travel(myLocation,myDestiny);
        travels.add(travel);
        String message="";
        for (int i= 0; i < travels.size(); i++){
            message += travels.get(i).showTravel();
        }
        presenter.showTravels("Viajes: " +"\n" + message);
    }

}
