using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace exercicio03
{
    class Program
    {
        static void Main(string[] args)
        {
            float basee, alt;

            Console.WriteLine("Digite a Base de um Triangulo: ");
            basee = float.Parse(Console.ReadLine());

            Console.WriteLine("Digite a Altura de um Triangulo: ");
            alt = float.Parse(Console.ReadLine());

            hipotenusa(basee, alt);

            Console.ReadKey();
        }

        static void hipotenusa(float basee, float alt)
        {

            double hip;

            hip = Math.Sqrt(Math.Pow(basee, 2) + Math.Pow(alt, 2));

            Console.WriteLine("Valor da Hipotenusa é: " + Math.Round(hip, 2));
        }
    }
}
