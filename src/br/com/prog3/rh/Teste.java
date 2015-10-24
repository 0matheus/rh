package br.com.prog3.rh;

import java.sql.Connection;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        Cargo c = new Cargo();
        CargoDAO cd = new CargoDAO();

        //List<Cargo> lista = cd.listarTodos();
        /*
         if (lista != null) {
         for (Cargo cargo : lista) {
         System.out.println("Codigo: " + cargo.getCodigo());
         System.out.println("Descrição: " + cargo.getDescricao());
         System.out.println("Salario: " + cargo.getSalario());
         }
         }*/

        Cargo cargo = cd.buscaPorDescricao("Médico");
        if (cargo != null) {
            System.out.println("Codigo: " + cargo.getCodigo());
            System.out.println("Descrição: " + cargo.getDescricao());
            System.out.println("Salario: " + cargo.getSalario());
        }

    }

}
