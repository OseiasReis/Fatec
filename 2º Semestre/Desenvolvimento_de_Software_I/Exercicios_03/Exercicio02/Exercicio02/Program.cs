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
            Random random = new Random();

            int i;
            float media;
            float[] valores = new float[100];

            valores[i] = random.Next(0, 100);

            media = valores[i] / 2;

            for (i = 0; i <= 100; i++)
            {
                if (valores[i] > media)
                    i++;
            }

            Console.WriteLine("{0} valores acima da média do grupo", i);
        }
    }
}
