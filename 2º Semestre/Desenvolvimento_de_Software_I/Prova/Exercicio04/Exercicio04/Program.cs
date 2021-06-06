using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio04
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] n1 = new int[15];
            int i, x;
            int med = 5, media, abai;

            for (i = 0; i < 15; i++)
            {
                Console.WriteLine("Digite a {0}ª nota: ", i + 1);
                n1[i] = int.Parse(Console.ReadLine());

                media = n1[i] / 15;

                for (x = 0; media < med; x++)
                {
                    
                }
            }

            abai = n1[i]-x;

            Console.WriteLine("A sua média é: " + media + "\n" + x + " estão acima da média.\n" + abai + " estão abaxio da média.");

            Console.ReadKey();
        }
    }
}
