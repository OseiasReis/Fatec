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
            Livro livro;

            livro = cadastrarLivro();
            exibirDados(livro);

            Console.ReadKey();

        }

        static Livro cadastrarLivro()
        {
            Livro l;

            Console.WriteLine("**** CADASTRANDO UM LIVRO ****\n");
            Console.Write("\nTítulo do livro: "); l.titulo = Console.ReadLine();
            Console.Write("\nAno de lançamento: "); l.ano = int.Parse(Console.ReadLine());
            Console.Write("\nPreço: "); l.preco = float.Parse(Console.ReadLine());
            return l;
        }

        static void exibirDados(Livro l)
        {
            Console.WriteLine("\n\n\n**** EXIBINDO OS DADOS DO LIVRO ****\n");
            Console.WriteLine("\nTítulo do livro: {0}", l.titulo);
            Console.WriteLine("\nAno de Lançamento: {0}", l.ano);
            Console.WriteLine("\nPreço: R${0:N2}", l.preco);
        }
    }
}
