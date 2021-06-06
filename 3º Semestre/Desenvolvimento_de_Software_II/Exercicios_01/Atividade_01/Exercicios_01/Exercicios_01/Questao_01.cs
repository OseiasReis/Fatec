using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicios_01
{
    class Questao_01
    {
        static void Main(string[] args)
        {
            int X, Y;
            float Z, RESULTADO;

            Console.WriteLine("Insira o valor de X");
            X = int.Parse(Console.ReadLine());

            Console.WriteLine("\nInsira o valor de Y");
            Y = int.Parse(Console.ReadLine());

            Z = X/Y;

            RESULTADO = Y + Z * X;

            if ((X % 2) == 0)
                Console.WriteLine("\nX é Par");
            else
                Console.WriteLine("\nX é Impar");

            if (Z > X && Z < Y || Z < X && Z > Y)
                Console.WriteLine("\nA variavel Z está entre X e Y");
            else
                Console.WriteLine("\nA variavel Z não está entre X e Y");

            Console.ReadKey();
        }
    }
}
