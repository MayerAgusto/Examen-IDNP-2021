package com.example.examen.Presentador;

public interface PresenterInt {
    void register(String name, String email, String password);
    void registerTravel(String myLocation, String myDestiny);
    void showName(String name);
    void showTravels(String travels);

}
