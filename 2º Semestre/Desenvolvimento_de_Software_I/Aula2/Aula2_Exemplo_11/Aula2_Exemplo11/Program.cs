using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo11
{
    class Program
    {
        static void Main(string[] args)
        {
            double soma = 0, n;
            do
            {
                Console.WriteLine("Para sair digite 0 (zero) ");
                Console.Write("\nDigite um número: ");
                n = double.Parse(Console.ReadLine());
                soma += n;
                Console.WriteLine("\nAcumulo da Soma = {0}", soma);
                Console.WriteLine("-------------------------");
            } while (n != 0);

            Console.WriteLine("\n\ntecle algo para continuar");
            Console.ReadKey();
        }
    }
}
