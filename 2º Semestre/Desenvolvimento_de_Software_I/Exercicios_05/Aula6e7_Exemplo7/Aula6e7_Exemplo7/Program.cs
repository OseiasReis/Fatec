using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula6e7_Exemplo7
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Console.Write("Digite um número: ");

                int numero = Convert.ToInt32(Console.ReadLine());

                int resultado = 100 / numero;

                Console.WriteLine("Resultado de 100 / {0} = {1}", numero, resultado);
            }
            catch (FormatException)
            {
                Console.WriteLine("Formato de números inválido!");
            }
            catch (DivideByZeroException) {
                Console.WriteLine("O número não pode ser zero!");
            }
            catch (Exception e){ //exceção para caso ocorrer qualquer outro tipo de erro
                Console.WriteLine("ERRO: {0}",e.Message);
            }
            Console.ReadKey();
        }
    }
}
