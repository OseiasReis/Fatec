using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo8
{
    class Program
    {
        static void Main(string[] args)
        {
            double[,] matriz = { { 4.5, 5.2 }, { 4.2, 1 } };

            int x, y;
            Console.WriteLine("\n Impimindo a Matriz\n");
            for (x = 0; x < 2; x++)
            {
                for (y = 0; y < 2; y++)
                {
                    Console.WriteLine("\n mat[{0}][{1}]={2:N1}", x, y, matriz[x, y]);
                }
            }
            Console.ReadKey();
        }
    }
}
