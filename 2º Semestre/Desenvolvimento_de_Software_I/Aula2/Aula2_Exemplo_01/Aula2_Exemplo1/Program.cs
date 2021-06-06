using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo1
{
    class Program
    {
        static void Main(string[] args)
        {
            int N, R;
            Console.WriteLine("Digite um numero: ");
            N = int.Parse(Console.ReadLine());

            R = N % 2;   //calculo do resto da divisão de N por 2

            if (R == 0)
                Console.WriteLine("\n{0} é par", N);
            else
                Console.WriteLine("\n{0} é impar", N);

            Console.ReadKey();
        }
    }
}
