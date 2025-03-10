/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio09;

/**
 *
 * @author juan.antonio
 */
public class Libro extends Publicacion implements IPrestable {
    private String ISBN;
    private boolean prestado;
    
    Libro(String titulo, String autor, String ISBN){
        super(titulo,autor);
        this.ISBN=ISBN;
        this.prestado=false;
        
    }

    @Override
    public void imprimir() {
        if (prestado)
            System.out.printf("LIBRO %s %s %s (\033[31mPRESTADO\033[30m)\n",titulo,autor,ISBN);
        else
            System.out.printf("LIBRO %s %s %s (DISPONIBLE)\n",titulo,autor,ISBN);
    }

    @Override
    public void prestar() {
        this.prestado=true;
    }

    @Override
    public void devolver() {
        this.prestado=false;
    }

    @Override
    public boolean estaPrestado() {
        return this.prestado;
    }

    
}
