using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio2_Quest2
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1, fato;

            Console.Write("Digite um Numero: ");
            n1 = int.Parse(Console.ReadLine());

            int num = calcularFatorial (n1, fato);

            Console.WriteLine("Fatorial de " + n1 + " é " + fato);
            Console.ReadKey();
        }

        static int calcularFatorial (int n1, int fato)
        {
            fato = n1;

            for (int i = n1 - 1; i > 1; i--)
            {
                fato *= i;
            }         
        }
    }
}