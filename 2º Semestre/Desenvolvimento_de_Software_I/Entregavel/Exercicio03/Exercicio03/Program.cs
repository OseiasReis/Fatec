using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio03
{
    class Program
    {
        static void Main(string[] args)
        {
            float n1, n2;

            Console.WriteLine("Digite um número:");
            n1 = float.Parse(Console.ReadLine());

            Console.WriteLine("Digite outro número:");
            n2 = float.Parse(Console.ReadLine());

            diferenca(n1, n2);

            Console.ReadKey();
        }

        static void diferenca(float n1, float n2)
        {
            Console.Write("-------------------------------------------------------------------");
            if (n1 < n2)
                Console.Write("\n" + n2 + "\n" + n1);
            else
                Console.Write("\n" + n1 + "\n" + n2);
        }
    }
}
