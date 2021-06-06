using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula6_Exemplo1
{
    class Aula7_Exemplo1
    {
        static void Main(string[] args)
        {
            const int TAM = 15;
            Pessoa[] p = new Pessoa[TAM]; //Declaração de um vetor de pessoas
            int c = 0; //Variavel que servira como um contador de pessoas cadastradas
            int op = 0;
            do
            {
                op = menu();
                switch (op)
                {
                    case 1: p[c++] = cadastrarPessoa(); break;

                    case 2: listarPessoas(p, c); break;

                    case 3: exibirMediaPesoIdeal(p, "MASCULINO", c); break;

                    case 4: exibirMediaPesoIdeal(p, "FEMININO", c); break;

                    case 0: break;

                    default: Console.WriteLine("Opção Inválida."); break;
                }
                Console.SetCursorPosition(50, 20);
                Console.Write("Tecle algo para continuar!");
                Console.ReadKey();
            } while (op != 0);
        }

        public static int menu()
        {
            Console.Clear();
            Console.WriteLine("*** Menu Principal - Pessoas***\n");
            Console.WriteLine(" 1 - Cadastrar");
            Console.WriteLine(" 2 - Listar todas as pessoas");
            Console.WriteLine(" 3 - Média do Peso Ideal dos Homens");
            Console.WriteLine(" 4 - Média do Peso Ideal das Mulheres");
            Console.WriteLine(" 0 - Sair");
            Console.Write("\n Digite uma opção: ");
            return int.Parse(Console.ReadLine());
        }

        public static Pessoa cadastrarPessoa()
        {
            //Entrada de dados usando variaveis auxiliares
            Console.Clear();
            Console.Write("Digite o nome da pessoa: "); string n = Console.ReadLine();
            Console.Write("Digite a idade de {0}: ", n); int i = int.Parse(Console.ReadLine());
            Console.Write("Digite a altura de {0}: ", n); double a = double.Parse(Console.ReadLine());
            Console.Write("Digite a letra correspondente ao sexo (F/M): ");
            char s = char.Parse(Console.ReadLine());

            //Retornando um objeto, que foi criado usando o construtor com parâmetros
            return new Pessoa(n, i, a, s);
        }

        public static void listarPessoas(Pessoa[] ps, int cp)
        {
            Console.Clear();
            Console.WriteLine("\n\n*** Dados da Pessoa ***\n");
            for (int x = 0; x < cp; x++)
                Console.WriteLine(ps[x].ToString());
        }

        public static void exibirMediaPesoIdeal(Pessoa[] p, string sx, int t)
        {
            double soma = 0; //variavel criada para acumular a soma dos pesos ideais
            int cont = 0; // variavel criada para contar a qtde de pessoas do sexo sx
            for (int x = 0; x < t; x++)
            {
                if ((p[x].Sexo).Equals(sx))
                {
                    soma += p[x].calcularPesoIdeal();
                    cont++;
                }
            }
            Console.WriteLine("Média do Peso Ideal - {0}: {1} ", sx, soma / cont);
        }
    }
}
