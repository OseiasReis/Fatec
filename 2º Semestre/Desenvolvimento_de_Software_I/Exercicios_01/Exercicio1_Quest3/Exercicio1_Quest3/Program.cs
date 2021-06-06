using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula1_Exemplo6
{
    class Program
    {
        static void Main(string[] args)
        {
            double a, res;

            Console.Write("Digite um numero: ");
            a = Convert.ToInt32(Console.ReadLine());

            res = Math.Pow(a, 2);

            Console.Write(a + " ao quadrado é " + res);

            Console.ReadKey();
        }
    }
}