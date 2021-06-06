using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo4
{
    class Program
    {
        static void Main(string[] args)
        {
            double x;

            Console.Write("Digite um valor real (ex.: 34,45): ");
            x = double.Parse(Console.ReadLine());

            if ((x > 10.00) && (x < 50.00))
                Console.WriteLine("{0} ESTÁ entre 10 e 50", x);
            else
                Console.WriteLine("{0} NÃO ESTÁ entre 10 e 50", x);

            Console.ReadLine();
        }
    }
}
