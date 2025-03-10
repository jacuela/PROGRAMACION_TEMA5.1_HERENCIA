/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

/**
 *
 * @author jacuela
 */
public interface Ibd_banco {
    public void insertar(CuentaBancaria c);
    public CuentaBancaria buscar(int numero);
    public void listar();
}
