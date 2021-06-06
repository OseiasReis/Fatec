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
            
            float A, B, C;
            Console.WriteLine("Digite um lado do triangulo:");
            A = float.Parse(Console.ReadLine());

            Console.WriteLine("Digite outro lado do trinagulo:");
            B = float.Parse(Console.ReadLine());

            Console.WriteLine("Digite outro lado do triangulo:");
            C = float.Parse(Console.ReadLine());

            triangulo(A, B, C);

            Console.ReadKey();
        }

        static void triangulo (float A, float B, float C)
        {
        if (A < B + C && B < A + C && C < A + B)
           {
               if (A == B && B == C)
                    Console.WriteLine("\n\n\nO trinagulo é equilátero");
                    else
                    {
                        if (A == B || A == C || B == C)
                            Console.WriteLine("\n\n\nO triangulo é isoceles");
                        else
                            Console.WriteLine("\n\n\nO triangulo é escaleno");
                    }
                }
            else
                Console.WriteLine("\n\n\nEstes valores não formam um triangulo");
        }
    }
}
