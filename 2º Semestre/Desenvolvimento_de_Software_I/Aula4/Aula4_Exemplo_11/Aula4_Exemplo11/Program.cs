using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo11
{
    class Program
    {
        static void Main(string[] args)
        {
            const int QTD_COL = 3;
            const int QTD_LIN = 5;
            double[,] notas = new double[QTD_LIN, QTD_COL];

            notas = cadastrarNotas(QTD_LIN, QTD_COL);

            Console.WriteLine("\n *** Nomes cadastrados na Matriz ***\n ");
            exibirDados(notas);
            Console.ReadKey();
        }

        static double[,] cadastrarNotas(int nLin, int nCol)
        {
            double[,] n = new double[nLin, nCol];
            //Atribuição de notas na matriz
            for (int l = 0; l < nLin; l++)
            {
                Console.WriteLine("\nNotas do {0}º aluno", l + 1);
                for (int c = 0; c < nCol; c++)
                {
                    Console.Write(" {0}º nota: ", c + 1);
                    n[l, c] = double.Parse(Console.ReadLine());
                }
            }
            return n;
        }

        static void exibirDados(double[,] nt)
        {
            //Exibição dos dados da matriz
            Console.WriteLine("\nAluno \t\tNota1 \t\tNota2 \t\tNota3 \n");
            for (int i = 0; i < nt.GetLength(0); i++)
            {
                Console.Write("{0}º Aluno: ", i + 1);
                for (int j = 0; j < nt.GetLength(1); j++)
                {
                    Console.Write("\t{0:N1}\t", nt[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}
