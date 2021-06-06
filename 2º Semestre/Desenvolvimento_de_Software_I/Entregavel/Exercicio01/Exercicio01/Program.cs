using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio03
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1, n2;

            Console.WriteLine("Digite um número: ");
            n1 = int.Parse(Console.ReadLine());

            Console.WriteLine("Digite outro número: ");
            n2 = int.Parse(Console.ReadLine());

            calcularMedia(n1, n2);

            Console.ReadKey();
        }

        static void calcularMedia(int n1, int n2)
        {
            int media;

            media = (n1 + n2) / 2;

            if (media < 7)
                Console.WriteLine("Você foi Aprovado, com a media de " + media);
            else
                Console.WriteLine("Você foi Reprovado, com a media " + media);
        }
    }
}
