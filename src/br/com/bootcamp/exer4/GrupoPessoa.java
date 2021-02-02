package br.com.bootcamp.exer4;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class GrupoPessoa {
    private final List<Pessoa> pessoaList = new ArrayList<>();
    private final LocalDate dataAtual = LocalDate.now();

    public GrupoPessoa() {

    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void adicionar(Pessoa pessoa) {
        if (ehMenorDe18Anos(pessoa.getDataNascimento())) {
            System.out.println("Não foi possível adicionar a pessoa " + pessoa.getNome() + ", menor de 18 anos.");
        } else {
            pessoaList.add(pessoa);
            System.out.println("Pessoa " + pessoa.getNome() + " adiconada com sucesso!");
        }
    }

    private boolean ehMenorDe18Anos(LocalDate dataNascimento) {
        LocalDate dataAniversarioDe18Anos = getDataAniversarioDe18Anos(dataNascimento);
        return !dataAniversarioDe18Anos.isEqual(dataAtual) && !dataAniversarioDe18Anos.isBefore(dataAtual);
    }

    private LocalDate getDataAniversarioDe18Anos(LocalDate dataNascimento) {
        return dataNascimento.plusYears(18);
    }

    public void dadosDoGrupoPessoa() {
        for (int i = 0; i < pessoaList.size(); i++) {
            System.out.println(pessoaList.get(i));
        }
    }


    public void dadosDoGrupoPessoaComMaiorIdade() {
        Integer maiorIdade = getMaiorIdade();
        if (maiorIdade != null) {
            for (int i = 0; i < pessoaList.size(); i++) {
                Integer idadeDaPessoaAtual = getIdade(pessoaList.get(i).getDataNascimento());
                if (idadeDaPessoaAtual.equals(maiorIdade)) {
                    System.out.println(pessoaList.get(i));
                }
            }
        }

    }

    public void dadosDoGrupoPessoaComMenorIdade() {
        Integer menorIdade = getMenorIdade();
        if (menorIdade != null) {
            for (int i = 0; i < pessoaList.size(); i++) {
                Integer idadeDaPessoaAtual = getIdade(pessoaList.get(i).getDataNascimento());
                if (idadeDaPessoaAtual.equals(menorIdade)) {
                    System.out.println(pessoaList.get(i));
                }
            }
        }
    }

    private Integer getMaiorIdade() {
        if (existeAlgumaPessoaNaLista()) {
            int menorIdade = getIdade(pessoaList.get(0).getDataNascimento());

            for (int i = 1; i < pessoaList.size(); i++) {
                Integer idadeDaPessoaAtual = getIdade(pessoaList.get(i).getDataNascimento());

                if (idadeDaPessoaAtual > getMaiorIdade()) {
                    getMenorIdade() = idadeDaPessoaAtual;
                }
            }
            return maiorIdade;
        }
        return null;
    }

    public Integer getMenorIdade() {
        if (existeAlgumaPessoaNaLista()) {

            int menorIdade = getIdade(pessoaList.get(0).getDataNascimento());

            for (int i = 1; i < pessoaList.size(); i++) {
                Integer idadeDaPessoaAtual = getIdade(pessoaList.get(i).getDataNascimento());

                if (idadeDaPessoaAtual < menorIdade) {
                    menorIdade = idadeDaPessoaAtual;
                }
            }
            return menorIdade;
        }
        return null;
    }


    private boolean existeAlgumaPessoaNaLista() {
        return !pessoaList.isEmpty();
    }

    private Integer getIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }

}

}
