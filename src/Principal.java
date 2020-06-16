import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal
{
    private static List<Restaurante> restauranteList = new ArrayList<>();

    private static void popularListaRestaurantesComExemplo()
    {
        restauranteList.add(new Restaurante("Coco Bambu", "SCN Qd 05 Bloco A", "Brasileira", 5f));
        restauranteList.add(new Restaurante("Kannika", "CLS 408, Loja 13", "Tailandesa", 3f));
        restauranteList.add(new Restaurante("Cantina da Massa", "CLS 303, Bloco B", "Italiana", 4f));
        restauranteList.add(new Restaurante("La Chaumière", "CLS 408, Bloco A, Lj 13", "Francesa", 5f));
    }

    public static void main(String[] args)
    {
        popularListaRestaurantesComExemplo();
        mostraMenu();
    }

    private static void mostraMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nRevista 4 Pneus\nSistema de Gestao de Restaurantes\nMENU PRINCIPAL\n\n" +
                "1 - Cadastrar restaurante\n2 - Mofificar nota de restaurante\n3 - Excluir restaurante\n" +
                "4 - Listar restaurantes por tipo\n5 - Listar restaurantes por nota\n0 - Encerrar");

        Integer opcao = scanner.nextInt();

        switch (opcao)
        {
            case 1:
            {
                inserir();
                break;
            }
            case 2:
            {
                alterarNota();
                break;
            }
            case 3:
            {
                excluir();
                break;
            }
            case 4:
            {
                listarTipo();
                break;
            }
            case 5:
            {
                listarNota();
                break;
            }
            case 0:
            {
                break;
            }
            default:
            {
                System.out.println("Opcao invalida!!!");
                mostraMenu();
            }
        }

    }

    private static void inserir()
    {
        Restaurante restaurante = new Restaurante();

        restauranteList.add(restaurante);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome:");
        restaurante.setNome(scanner.nextLine());

        System.out.println("Informe o endereco:");
        restaurante.setEndereco(scanner.nextLine());

        System.out.println("Informe a nota:");
        restaurante.setNota(Float.parseFloat(scanner.nextLine()));

        System.out.println("Informe o tipo:");
        restaurante.setTipo(scanner.nextLine());

        mostraMenu();
    }

    private static void alterarNota()
    {
        System.out.println("Informe o NOME para pesquisa de restaurantes: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        Restaurante restaurante = pesquisarRestaurantePorNome(nome);
        if (restaurante == null){
            System.out.println("\nRestaurante nao localizado");
        } else {
            System.out.println("\nInforme a nova NOTA do restaurante");
            restaurante.setNota(Float.parseFloat(scanner.nextLine()));
        }
        mostraMenu();
    }

    private static Restaurante pesquisarRestaurantePorNome(String nome)
    {
        for (Restaurante restaurante : restauranteList)
        {
            if (nome.equals(restaurante.getNome()))
            {
                return restaurante;
            }
        }
        return null;
    }

    private static void excluir()
    {
        System.out.println("Informe o NOME do restaurantes para exclusao");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        Restaurante restaurante = pesquisarRestaurantePorNome(nome);
        restauranteList.remove(restaurante);
        mostraMenu();
    }

    private static void listarTipo()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o TIPO para pesquisa de restaurantes: ");
        String tipo = scanner.nextLine();

        System.out.println("nome    |    endereco       |    tipo      |       nota ");
        for (Restaurante restaurante : restauranteList)
        {
            if (tipo.equals(restaurante.getTipo()))
            {
                System.out.println(restaurante.getNome() + "    |    " + restaurante.getEndereco() +
                        "    |    " + restaurante.getTipo() + "    |    " + restaurante.getNota());
            }
        }
        mostraMenu();
    }

    private static void listarNota()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a NOTA para pesquisa de restaurantes: ");
        Float nota = Float.parseFloat(scanner.nextLine());

        System.out.println("nome    |    endereco       |    tipo      |       nota ");
        for (Restaurante restaurante : restauranteList)
        {
            if (nota.equals(restaurante.getNota()))
            {
                System.out.println(restaurante.getNome() + "    |    " + restaurante.getEndereco() +
                        "    |    " + restaurante.getTipo() + "    |    " + restaurante.getNota());
            }
        }
        mostraMenu();
    }

}
