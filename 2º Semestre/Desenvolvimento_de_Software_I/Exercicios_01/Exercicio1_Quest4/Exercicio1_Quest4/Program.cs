using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio1_Quest4
{
    class Program
    {
        static void Main(string[] args)
        {
            int A, B, C;
            double resu;

            Console.WriteLine("Digite um numero inteiro para A: ");
            A = int.Parse (Console.ReadLine());

            Console.WriteLine("Digite um numero inteiro para B: ");
            B = int.Parse (Console.ReadLine());

            Console.WriteLine("Digite um numero para C: ");
            C = int.Parse (Console.ReadLine());

            resu = Math.Pow(A, 2) * 5 - C / (B - A % 4);

            Console.Write("O resultado da expreção é " + resu);

            Console.ReadKey();
        }
    }
}
