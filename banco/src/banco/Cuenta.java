/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author ZASALAS
 */
public class Cuenta {
    private int saldo=50;

    public int getSaldo() {
        return saldo;
    }

    public void retiroBanco(int saldo) {
        this.saldo = this.saldo-saldo;
    }

    public Cuenta() {
    }
}