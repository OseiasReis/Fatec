using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio02
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1;

            Console.WriteLine("Digite um número:");
            n1 = int.Parse(Console.ReadLine());

            calcularFatorial(n1);

            Console.ReadKey();
        }

        static void calcularFatorial(int n1)
        {
            int i, Fato = 1;

            for (i = 2; i <= n1; i++)
            {
                Fato *= i;
            }

            Console.WriteLine("O fatorial de " + n1 + " é " + Fato);
        }
    }
}
