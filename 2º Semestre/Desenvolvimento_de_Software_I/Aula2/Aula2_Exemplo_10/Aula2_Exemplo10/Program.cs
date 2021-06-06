using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo10
{
    class Program
    {
        static void Main(string[] args)
        {
            int q = 0, n;
            do
            {
                Console.WriteLine("\n\nPara sair digite 0 (zero) ");
                Console.Write("\nDigite um número: ");
                n = int.Parse(Console.ReadLine());
                if (n != 0)
                    q++;
            } while (n != 0);

            Console.WriteLine("\nForam digitados {0} números inteiros", q);
            Console.WriteLine("\n\nTecle algo para continuar");
            Console.ReadKey();

        }
    }
}
