using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo5
{
    class Program
    {
        static void Main(string[] args)
        {
            int i;
            const int tam = 10;
            string[] times = new string[tam];

            Console.WriteLine("*** Times de Futebol ***\n");

            //Atribuição do calculo no vetor salarios
            for (i = 0; i < tam; i++)
            {
                Console.Write("Nome do {0}º time: ", i + 1);
                times[i] = Console.ReadLine();
            }

            Console.WriteLine("\n *** Times cadastrados no Vetor ***\n");
            exibirDados(times);

            Console.ReadKey();
        }

        static void exibirDados(string[] t)
        {
            //Exibição dos dados do vetor
            for (int x = 0; x < t.Length; x++)
                Console.WriteLine("{0}º time: {1}", x + 1, t[x]);
        }
    }
}
