using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Questao_05
{
    class Questao_05
    {
        static void Main(string[] args)
        {
            int Z, Y;
            int A, B, C, D, E;
            float F, G, H;
            float Gas, Eta;

            Console.WriteLine("Insira o valor de Y");
            Y = int.Parse(Console.ReadLine());

            Console.WriteLine("Insira o valor de Z");
            Z = int.Parse(Console.ReadLine());

            if (Z == Y * Y)
                Console.WriteLine("\nZ é multiplo de Y");
            else
                Console.WriteLine("\nZ não é multiplo de Y");

            Console.WriteLine("\n\n\nInsira o valor de A");
            A = int.Parse(Console.ReadLine());

            Console.WriteLine("\nInsira o valor de B");
            B = int.Parse(Console.ReadLine());

            Console.WriteLine("\nInsira o valor de C");
            C = int.Parse(Console.ReadLine());

            Console.WriteLine("\nInsira o valor de D");
            D = int.Parse(Console.ReadLine());

            Console.WriteLine("\nInsira o valor de E");
            E = int.Parse(Console.ReadLine());

            if (A > B && A > C && A > D && A > E)
                Console.WriteLine("\nA variavel A é a maior");

            if (B > A && B > C && B > D && B > E)
                Console.WriteLine("\nA variavel B é a maior");

            if (C > A && C > B && C > D && C > E)
                Console.WriteLine("\nA variavel C é a maior");

            if (D > A && D > B && D > C && D > E)
                Console.WriteLine("\nA variavel D é a maior");

            else
                Console.WriteLine("\nA variavel E é a maior");

            Console.WriteLine("\n\n\nDigite um lado do triangulo:");
            F = int.Parse(Console.ReadLine());

            Console.WriteLine("\nDigite outro lado do trinagulo:");
            G = int.Parse(Console.ReadLine());

            Console.WriteLine("\nDigite outro lado do triangulo:");
            H = int.Parse(Console.ReadLine());
            if ((F < G + H) && (G < F + H) && (H < F + G))
            {
                if ((F == G) && (G == H))
                    Console.WriteLine("\nO trinagulo é equilátero");
                else
                {
                    if ((F == G) || (F == H) || (G == H))
                        Console.WriteLine("\nO triangulo é isoceles");
                    else
                        Console.WriteLine("\nO triangulo é escaleno");
                }
            }
            else
                Console.WriteLine("\nEstes valores não formam um triangulo");



            Console.ReadKey();
        }
    }
}
