using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo9
{
    class Program
    {
        static void Main(string[] args)
        {
            int op, n;
            do
            {
                Console.Clear();
                Console.WriteLine("1 - Par/Impar");
                Console.WriteLine("2 - Decrescente até 0 (zero)");
                Console.WriteLine("3 - Sair");
                Console.Write("\nInforme a opção desejada: "); op = int.Parse(Console.ReadLine());

                switch (op)
                {
                    case 1: Console.Write("Digite um número: "); n = int.Parse(Console.ReadLine());
                        Console.WriteLine(n + " é " + (n % 2 == 0 ? " par " : " impar "));
                        break;

                    case 2: Console.Write("Digite um número: "); n = int.Parse(Console.ReadLine());
                        while (n >= 0)
                            Console.Write("{0}", n--);
                        break;

                    case 3: Console.WriteLine("Fim da execução do programa");
                        break;

                    default: Console.WriteLine("Opção Inválida - Teste novamente");
                        break;
                }
                Console.WriteLine("\ntecle algo para continuar");
                Console.ReadKey();
            } while (op != 3);
        }
    }
}
