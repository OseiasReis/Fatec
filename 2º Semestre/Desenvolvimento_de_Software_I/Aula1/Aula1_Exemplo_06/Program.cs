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
            int a, b, c;
            Console.Write("Digite um numero: ");
            a = Convert.ToInt32(Console.ReadLine());

            Console.Write("Digite outro numero: ");
            b = Convert.ToInt32(Console.ReadLine());

            c = a + b;

            Console.Write(a + " + " + b + " = " + c);

            Console.ReadKey();
        }
    }
}
