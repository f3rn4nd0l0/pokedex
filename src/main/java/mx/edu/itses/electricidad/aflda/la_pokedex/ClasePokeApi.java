/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.aflda.la_pokedex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author ferlo
 */
public class ClasePokeApi {
    
    private Set <Pokemon> lista = new HashSet();
    
     public Set<Pokemon> getLista(){
                return lista;
            }

    
    public void Pokemon(JTable Pokemo, JTextField Buscador, JTextField nombre, JTextField peso, JTextField altura, JTextField experienciaBase, JLabel foto){
        DefaultTableModel model = new DefaultTableModel();
        String[] nombreCol = {"Nombre", "Peso", "Altura"};
                

        model.setColumnIdentifiers(nombreCol);
        
        Pokemo.setModel(model);
        
        
        try{
            
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + Buscador.getText());
            
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            
            conn.setRequestMethod("GET");
            
            BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            StringBuilder response = new StringBuilder();
            
            String Line;
            
            while((Line = read.readLine())!= null){
                response.append(Line);
            }
            
            read.close();
            
            JSONObject jsonObject = new JSONObject(response.toString());
            
            String name = jsonObject.getString("name");
            int weight = jsonObject.getInt("weight");
            int height = jsonObject.getInt("height");
            int experience = jsonObject.getInt("base_experience");
            
            Pokemon p = new Pokemon(name, weight, height, experience);
            lista.add(p);
            
            
            model.setRowCount(0);
            
            for(Pokemon pp : lista){
                model.addRow(new Object[]{pp.getNombr(), pp.getPes(), pp.getAltur()} );
            }
            
            //model.addRow(new Object[]{name, weight, height});
            
            nombre.setText(name);
            peso.setText(String.valueOf(weight));
            altura.setText(String.valueOf(height));
            experienciaBase.setText(String.valueOf(experience));
            

                      
            String imageURL = jsonObject.getJSONObject("sprites").getString("front_default");
            
            ImageIcon icon = new ImageIcon(new URL(imageURL));
            foto.setIcon(icon);
                                    

           
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Ingrese valores correctos: ID o Nombre del pokemon existente, ERROR: " + e.toString());
            
        }
    }
    
}
