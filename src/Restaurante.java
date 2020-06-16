public class Restaurante
{

    private String nome;
    private String endereco;
    private String tipo;
    private Float nota;

    public Restaurante(String nome, String endereco, String tipo, Float nota)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.nota = nota;
    }

    public Restaurante()
    {
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public Float getNota()
    {
        return nota;
    }

    public void setNota(Float nota)
    {
        this.nota = nota;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}
