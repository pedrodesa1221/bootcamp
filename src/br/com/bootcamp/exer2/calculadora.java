package br.com.bootcamp.exer2;

public class calculadora {

    private Integer numero1;
    private Integer numero2;
    private Integer resultado;


    public Integer somar(Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }

    public Integer subtrair(Integer numero1, Integer numero2) {
        return numero1 - numero2;
    }

    public Double dividir(Integer numero1, Integer numero2) {
        return (double) numero1 / numero2;
    }

    public Integer multiplicar(Integer numero1, Integer numero2) {
        return numero1 * numero2;
    }
}