using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio02
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] n1 = new int[15];
            int i;
            int maior = 0;

            for (i = 0; i < 15; i++)
            {
                Console.WriteLine("Digite o {0}º número: ", i+1);
                n1[i] = int.Parse(Console.ReadLine());

                if (maior <= n1[i])
                {
                    maior = n1[i];
                }
            }


            
            Console.WriteLine("O maior número digitado é: " + maior);
            
            Console.ReadKey();
        }
    }
}
