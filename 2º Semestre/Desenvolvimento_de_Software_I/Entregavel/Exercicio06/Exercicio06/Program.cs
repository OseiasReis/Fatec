using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio06
{
    class Program
    {
        static void Main(string[] args)
        {
            float alt;
            int sexo;

            Console.WriteLine("Digite sua Altura:");
            alt = float.Parse(Console.ReadLine());

            Console.WriteLine("Digite seu Sexo: Masc(1) Femi(2)");
            sexo = int.Parse(Console.ReadLine());

            calcularPesoaIdeal(alt, sexo);

            Console.ReadKey();
        }

        static void calcularPesoaIdeal(float alt, int sexo)
        {
            double peso;

            if (sexo == 1)
                peso = (72.7 * alt) - 58;
            else
                peso = (62.1 * alt) - 44.7;

            Console.WriteLine("Peso ideal: " + Math.Round(peso, 2) + "Kgs");
        }
    }
}
