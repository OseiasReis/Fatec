using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio01
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] num = new int[10];
            int i;
            int soma;

            for (i = 0; i < 10; i++)
            {
                Console.Write("Digite o {0}º número: ", i + 1);
                num[i] = int.Parse(Console.ReadLine());
            }

            Console.WriteLine();

            soma = 0;

            for (i = 0; i <= num[i]; i++)
            {
                if (num[i] % 2 == 0)
                    i += 1;
                else
                    if (num[i] % 2 == 1)
                    soma = num[i] + num[i];
            }

            Console.WriteLine("Números pares é de {0}", i);
            Console.WriteLine("A soma dos números impares é de {0}", soma);

            Console.ReadKey();
        }
    }
}
