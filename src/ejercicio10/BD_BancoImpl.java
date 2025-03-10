/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.util.ArrayList;

/**
 *
 * @author jacuela
 */
public class BD_BancoImpl implements Ibd_banco {

    private ArrayList<CuentaBancaria> listaCuentasBancarias;
    
    public BD_BancoImpl(){
        listaCuentasBancarias=new ArrayList();
    }
    
    @Override
    public void insertar(CuentaBancaria c) {
        listaCuentasBancarias.add(c);
    }

    @Override
    public CuentaBancaria buscar(int numero) {
        
        for (CuentaBancaria c: listaCuentasBancarias){
                if (c.getNumero()==numero)
                    return c;
        }
        return null;        
    }

    @Override
    public void listar() {
        for (CuentaBancaria c : listaCuentasBancarias) {
            System.out.print(c);
        }
          
    
    }
    
}
