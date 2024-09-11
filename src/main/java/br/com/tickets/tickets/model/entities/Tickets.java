package br.com.tickets.tickets.model.entities;

import java.sql.Date;

import jakarta.persistence.*;


@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 250)
    private String observacao;

    private Date data;

    @Column(nullable = false, length = 50)
    private String prioridade;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setores setor;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios funcionario;

    public Tickets() {
    super();
    }

    public Tickets(String titulo, String observacao, Date data, String prioridade, Setores setor, Status status,
            Funcionarios funcionario) {
        this.titulo = titulo;
        this.observacao = observacao;
        this.data = data;
        this.prioridade = prioridade;
        this.setor = setor;
        this.status = status;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    
    
    
    

    

}
