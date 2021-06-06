using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio1_Quest6
{
    class Program
    {
        static void Main(string[] args)
        {
            int ida;
            string verdade = "Você é maior de 18 anos", falso = "Você é menor de 18 anos";

            Console.WriteLine("Digite sua idade: ");
            ida = int.Parse (Console.ReadLine());

            Console.WriteLine(ida > 18 ? verdade : falso);
            Console.ReadKey();
        }
    }
}
