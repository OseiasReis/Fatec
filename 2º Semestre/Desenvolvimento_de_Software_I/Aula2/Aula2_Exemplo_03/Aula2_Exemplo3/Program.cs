using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo3
{
    class Program
    {
        static void Main(string[] args)
        {
            int ida1, ida2;
            string nome1, nome2;

            Console.Write("Digite o nome da 1ª pessoa: "); nome1 = Console.ReadLine();
            Console.Write("Digite a idade da 1ª pessoa: "); ida1 = int.Parse(Console.ReadLine());

            Console.Write("Digite o nome da 2ª pessoa: "); nome2 = Console.ReadLine();
            Console.Write("Digite a idade da 2ª pessoa: "); ida2 = int.Parse(Console.ReadLine());

            if (ida1 > ida2)
            {
                Console.Write("\n{0} é mais velho(a) ", nome1);
                Console.Write("com {0} anos de idade", ida1);
            }
            else
            {
                if (ida2 > ida1)
                {
                    Console.Write("\n{0} é mais velho(a) ", nome2);
                    Console.Write("com {0} anos de idade", ida2);
                }
                else
                {
                    Console.Write("\n{0} e {1} tem {2} anos de idade.", nome1, nome2, ida1);
                }
            }
            Console.ReadLine();
        }
    }
}
