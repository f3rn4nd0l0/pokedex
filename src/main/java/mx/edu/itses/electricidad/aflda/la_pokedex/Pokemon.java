/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.aflda.la_pokedex;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ferlo
 */
public class Pokemon {

    
        private String nombr;
    private int pes, altur, experience;
    
    public Pokemon(){
        
    }

    public Pokemon(String nombr, int pes, int altur, int experience) {
        this.nombr = nombr;
        this.pes = pes;
        this.altur = altur;
        this.experience = experience;
    }

    public String getNombr() {
        return nombr;
    }

    public int getPes() {
        return pes;
    }

    public int getAltur() {
        return altur;
    }
    
    public int getExperience(){
        return experience;
    }
    
}
