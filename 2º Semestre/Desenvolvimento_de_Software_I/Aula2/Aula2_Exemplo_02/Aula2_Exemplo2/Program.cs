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
            int A, B, X;
            Console.Write("Informe um valor para a variavel A: ");
            A = int.Parse(Console.ReadLine());
            Console.Write("Informe um valor para a variavel B: ");
            B = int.Parse(Console.ReadLine());

            X = A + B;

            if (X > 0)
                Console.WriteLine("\nO resultado da soma é {0}, sendo maior que 0 (zero)", X);

            if (X < 0)
                Console.WriteLine("\nO resultado da soma é {0}, sendo menor que 0 (zero)", X);

            if (X == 0)
                Console.WriteLine("\nO resultado da soma é {0}, sendo igual que 0 (zero)", X);
            
            Console.ReadKey();
        }
    }
}
