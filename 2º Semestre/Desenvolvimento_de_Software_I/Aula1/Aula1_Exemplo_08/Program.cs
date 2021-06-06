using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula1_Exemplo7
{
    class Program
    {
        static void Main(string[] args)
        {
            int a, b;
            string verdade = "sim", falso = "não"; 

            Console.Write("Digite um numero inteiro: ");
            a = int.Parse(Console.ReadLine());

            Console.Write("Digite outro numero inteiro: ");
            b = int.Parse(Console.ReadLine());

            Console.WriteLine();
            Console.Write("{0} > {1} ? Resposta: ", a, b);
            Console.WriteLine(a > b ? verdade : falso);

            Console.ReadKey();
        }
    }
}
