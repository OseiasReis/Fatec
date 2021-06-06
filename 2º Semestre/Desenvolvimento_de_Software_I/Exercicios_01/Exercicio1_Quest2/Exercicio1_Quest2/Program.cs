using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio1_Quest2
{
    class Program
    {
        static void Main(string[] args)
        {
            int a, res;
            Console.Write("Digite um numero: ");
            a = Convert.ToInt32(Console.ReadLine());

            res = a*2;

            Console.Write("O dobro de "  + a + " é " + res);

            Console.ReadKey();
        }
    }
}