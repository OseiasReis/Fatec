using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo10
{
    class Program
    {
        public static void Main(string[] args)
        {
            int l, c;
            const int QTD_COL = 3;
            const int QTD_LIN = 5;
            string[,] nomes = new string[QTD_LIN, QTD_COL];

            String n = "Fulano ";
            int cont = 1;
            //Atribuição de nomes na matriz
            for (l = 0; l < QTD_LIN; l++)
                for (c = 0; c < QTD_COL; c++)
                    nomes[l, c] = n + cont++;

            Console.WriteLine("\n *** Nomes cadastrados na Matriz ***\n ");
            exibirDados(nomes);
            Console.ReadKey();
        }

        static void exibirDados(string[,] m)
        {
            //Exibição dos dados da matriz
            for (int i = 0; i < m.GetLength(0); i++)
            {
                for (int j = 0; j < m.GetLength(1); j++)
                {
                    Console.Write("{0}\t", m[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}
