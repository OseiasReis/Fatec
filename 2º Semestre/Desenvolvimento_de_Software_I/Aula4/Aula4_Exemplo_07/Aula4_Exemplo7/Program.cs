using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo7
{
    class Program
    {
        static void Main(string[] args)
        {
            const int N_LIN = 3, N_COL = 3;
            int[,] mat = new int[N_LIN, N_COL];
            int l,c;
            Console.WriteLine("Cadastrando dados na matriz\n");
            Console.WriteLine("\nEntre com o valor em cada posição da matriz:\n");
            for(l=0; l<N_LIN; l++)
            {
                for(c=0; c<N_COL; c++)
                {
                    Console.Write(" mat[{0}][{1}] = ", l, c);
                    mat[l,c] = int.Parse(Console.ReadLine());
                } /*fim do for c*/
            } /*fim do for l*/

            Console.WriteLine("\n\nExibindo os dados da matriz:\n");
            for(l=0; l<N_LIN; l++)
            {
                for(c=0; c<N_COL; c++)
                {
                    Console.Write(" {0} ",mat[l,c]);
                }
                Console.WriteLine();
            }
            Console.ReadKey();
        }
    }
}
