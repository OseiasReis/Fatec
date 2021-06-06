using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        public struct Livro
        {
            public string titulo;
            public int ano;
            public float preco;
        }

        static void Main(string[] args)
        {
            const int TAM = 3;
            Livro[] livros = new Livro[TAM];

            Console.WriteLine("\n****CADASTRANDO LIVROS ****\n");
            for (int X = 0; X < TAM; X++)
                livros[X] = cadastrarLivro();

            Console.WriteLine("\n\n\n**** EXIBINDO OS DADOS DOS LIVROS ****\n");
            exibirDados(livros);
            Console.ReadKey();

        }

        static Livro cadastrarLivro()
        {
            Livro l;
            Console.Write("\nTítulo do livro: "); l.titulo = Console.ReadLine();
            Console.Write("Ano de Lançamento: "); l.ano = int.Parse(Console.ReadLine());
            Console.Write("Preço: "); l.preco = float.Parse(Console.ReadLine());
            return l;
        }

        static void exibirDados(Livro[] l)
        {
            for (int x = 0; x < l.Length; x++)
            {
                Console.WriteLine("\n\tTítulo do livro: {0}", l[x].titulo);
                Console.WriteLine("\tAno de Lançamento: {0}", l[x].ano);
                Console.WriteLine("\tPreço: R${0:N2}", l[x].preco);
            }
        }
    }
}
