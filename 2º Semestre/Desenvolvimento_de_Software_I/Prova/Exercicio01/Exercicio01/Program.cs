using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio01
{
    class Program
    {
        static void Main(string[] args)
        {
            float real, dolar;

            Console.Write("Digite um Valor em Reais: ");
            real = float.Parse(Console.ReadLine());

            Console.WriteLine("Valor do Dólar: U$4,05");
            dolar = 4.05f;

            convercao(real, dolar);

            Console.ReadKey();
        }

        static void convercao(float real, float dolar){

        float dinheiro1, dinheiro2;

        dinheiro1 = real/dolar;

        Console.WriteLine("\n\n" + real + " convertido para dolar fica " + Math.Round(dinheiro1, 2) + " Dólares.\n");

        dinheiro2 = real * dolar;

        Console.WriteLine("Dólar convertido para real fica " + Math.Round(dinheiro2, 2) + " Reais.");
        }
    }
}
