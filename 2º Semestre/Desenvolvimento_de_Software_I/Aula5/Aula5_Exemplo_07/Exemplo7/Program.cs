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
            const int NUM_L = 3, NUM_C = 2;
            Livro[,] livros = new Livro[NUM_L, NUM_C];

            Console.WriteLine("\n**** CADASTRANDO LIVROS ****\n");
            for (int l = 0; l < NUM_L; l++)
            {
                for (int c = 0; c < NUM_C; c++)
                {
                    livros[l, c] = cadastrarLivro();
                }
            }
            Console.Clear();
            Console.WriteLine("\n **** EXIBINDO OS DADOS DOS LIVROS ****\n");
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

        static void exibirDados(Livro[,] lv)
        {
            int px=3, py=3; //variáveis para controlar a posição do cursor na tela
            for ( int l = 0; l < lv.GetLength(0); l++)
            {
                for (int c = 0; c < lv.GetLength(1); c++)
                {
                    Console.SetCursorPosition(px, py+1);
                    Console.Write("\tTítulo: {0}", lv[l,c].titulo);
                    Console.SetCursorPosition(px, py+2);
                    Console.Write("\tAno: {0}", lv[l,c].ano);
                    Console.SetCursorPosition(px, py+3);
                    Console.Write("\tPreço: R${0:N2}", lv[l,c].preco);
                    px +=25;    //para deixar um espaço a direita p/ o próximo registro
                }
                px = 0;
                py += 5;
            }
        }
    }
}
